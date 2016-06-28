package com.example.gson.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import com.example.enums.PhoneType;

public class PhoneTypeSerializer implements JsonSerializer<PhoneType> {

	@Override
	public JsonElement serialize(PhoneType phoneType, Type type, JsonSerializationContext context) {
		// TODO Auto-generated method stub
		return new JsonPrimitive(phoneType.toString());
	}

}
