package com.example.model;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

	@Expose
	private String firstName;
	
	@Expose
	@SerializedName("surname")
	private String lastName;
	
	@Expose
	private Set<Phone> phones = new HashSet<Phone>();
	
	private String excluded;
	
	public String getExcluded() {
		return excluded;
	}

	public Person setExcluded(String excluded) {
		this.excluded = excluded;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public Person setPhones(Set<Phone> phones) {
		this.phones = phones;
		return this;
	}
	
	public Person addPhone(Phone phone) {
		this.phones.add(phone);
		return this;
	}

}
