package com.example.enums;

public enum PhoneType {

	MOBILE("Mobile"), 
	HOME("Home"), 
	WORK("Business"), 
	FAX("Facsimile");
	
	private String name;
	
	private PhoneType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	public static PhoneType forName(String name) {
		PhoneType result = null;
		for (PhoneType phoneType : PhoneType.values()) {
			if (phoneType.getName().equals(name)) {
				result = phoneType;
				break;
			}
		}
		return result;
	}
	
}
