package com.example.gson.util;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.enums.PhoneType;
import com.example.gson.deserializers.PhoneTypeDeserializer;
import com.example.gson.serializers.PhoneTypeSerializer;

@Component
public class GsonUtil {

	private static final Logger LOG = LoggerFactory.getLogger(GsonUtil.class);
	
	private Gson gson;
	
	@PostConstruct
	private void postConstruct() {
		gson = new GsonBuilder()
			.setPrettyPrinting()
			.registerTypeAdapter(PhoneType.class, new PhoneTypeSerializer())
			.registerTypeAdapter(PhoneType.class, new PhoneTypeDeserializer())
			.excludeFieldsWithoutExposeAnnotation()
			.enableComplexMapKeySerialization()
			.create();
		LOG.debug("Created a GsonUtil");
	}

	public Gson getGson() {
		return gson;
	}
	
}
