package com.example.model;

import com.google.gson.annotations.Expose;

import com.example.enums.PhoneType;

public class Phone {

	@Expose
	private String phoneNumber;
	
	@Expose
	private PhoneType phoneType;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Phone setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public Phone setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
		return this;
	}

}
