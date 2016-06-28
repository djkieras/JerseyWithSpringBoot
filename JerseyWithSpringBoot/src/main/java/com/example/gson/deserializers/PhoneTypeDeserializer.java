package com.example.gson.deserializers;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import com.example.enums.PhoneType;

public class PhoneTypeDeserializer implements JsonDeserializer<PhoneType> {

	@Override
	public PhoneType deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		return PhoneType.forName(json.getAsString());
	}

}
