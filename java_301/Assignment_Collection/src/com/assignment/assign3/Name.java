package com.assignment.assign3;

public class Name {
private String firstName;
private String surName;
public String getFirstName() {
	return firstName;
}

public String getSurName() {
	return surName;
}

public Name(String firstName, String surName) {
	super();
	this.firstName = firstName;
	this.surName = surName;
}

@Override
public String toString() {
	return "Name [firstName=" + firstName + ", surName=" + surName + "]";
}


}
