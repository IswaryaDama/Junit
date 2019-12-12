package com.test;

import java.time.LocalDate;
import java.util.Date;

public class Tablet {
 private String name;
 private String manifacturer;
 private String manDate; 
 private LocalDate exDate;
public Tablet() {
	super();
	// TODO Auto-generated constructor stub
}
public Tablet(String name, String manifacturer, String manDate, LocalDate expireData) {
	super();
	this.name = name;
	this.manifacturer = manifacturer;
	this.manDate = manDate;
	this.exDate = expireData;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getManifacturer() {
	return manifacturer;
}
public void setManifacturer(String manifacturer) {
	this.manifacturer = manifacturer;
}
public String getManDate() {
	return manDate;
}
public void setManDate(String manDate) {
	this.manDate = manDate;
}
public LocalDate getExDate() {
	return exDate;
}
public void setExDate(LocalDate exDate) {
	this.exDate = exDate;
}
@Override
public String toString() {
	return "Tablet [name=" + name + ", manifacturer=" + manifacturer + ", manDate=" + manDate + ", exDate=" + exDate
			+ "]";
}
 
 
}
