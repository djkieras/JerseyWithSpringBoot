package com.example.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		registerEndpoints();
	}

	private void registerEndpoints() {
		register(RequestContextFilter.class);
		packages("com.example.service");
		register(LoggingFilter.class);
	}
}
