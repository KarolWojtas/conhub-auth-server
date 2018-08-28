package com.karol.config.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@EnableAuthorizationServer
@Configuration
public class Oauth2AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
	
	private AuthenticationManager authManager;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public Oauth2AuthorizationServerConfiguration(AuthenticationManager authManager, PasswordEncoder passwordEncoder) {
		super();
		this.authManager = authManager;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authManager)
		.tokenEnhancer(jwtTokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("isAuthenticated()")
		.checkTokenAccess("isAuthenticated()")
		.passwordEncoder(passwordEncoder)
		;
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("webClient")
		.autoApprove(true)
		.authorizedGrantTypes("password","authorization_code", "refresh_token")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(120)
		.scopes("read")
		.resourceIds("user","test")
		;
	}
	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}
	@Bean
	public JwtAccessTokenConverter jwtTokenEnhancer() {
		KeyStoreKeyFactory keyfactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "secretKey".toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyfactory.getKeyPair("jwt"));
		return converter;
	}
	
}
