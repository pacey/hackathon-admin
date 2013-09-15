package org.hackers.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:security.properties")
public class SecurityProperties {

	@Autowired
	Environment environment;

	public String getLdapEndpoint() {
		return environment.getRequiredProperty("ldap.endpoint");
	}
}
