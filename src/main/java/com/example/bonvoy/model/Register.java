package com.example.bonvoy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registers")
public class Register {
@Id	
@GeneratedValue
private int Id;
private String name;
private String mobileNumber;
private String email;
private String passcode;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPasscode() {
	return passcode;
}
public void setPasscode(String passcode) {
	this.passcode = passcode;
}

}
