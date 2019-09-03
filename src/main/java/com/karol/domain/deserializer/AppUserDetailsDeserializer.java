package com.karol.domain.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.karol.domain.AppUserDetails;

public class AppUserDetailsDeserializer extends JsonDeserializer<AppUserDetails>{

	@Override
	public AppUserDetails deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = parser.getCodec();
	    JsonNode node = oc.readTree(parser);
	    final Long id = node.get("id").asLong();
	    final String username = node.get("username").asText();
	    final String password = node.get("password").asText();
	    final String roles = node.get("roles").toString();
	    final boolean accountNonExpired = node.get("accountNonExpired").asBoolean();
	    final boolean accountNonLocked = node.get("accountNonLocked").asBoolean();
	    final boolean credentialsNonExpired = node.get("credentialsNonExpired").asBoolean();
	    final boolean enabled = node.get("enabled").asBoolean();
	    
		return new AppUserDetails(id, username, password, roles);
	}

}
