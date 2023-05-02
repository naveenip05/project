package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="hello")
public class CarModel 
{
	@Id 
   private int carnum;
   private String carname;
   private String carversion;
public int getCarnum() {
	return carnum;
}
public void setCarnum(int carnum) {
	this.carnum = carnum;
}
public String getCarname() {
	return carname;
}
public void setcarname(String carname) {
	this.carname = carname;
}
public String getCarversion() {
	return carversion;
}
public void setCarversion(String carversion) {
	this.carversion = carversion;
}
   
}