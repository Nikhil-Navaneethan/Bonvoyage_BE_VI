package com.example.bonvoy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="places")
public class Places {
@Id
@GeneratedValue
private int Id;
private String image;
private String name;
private String description;
private String category;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}


}
