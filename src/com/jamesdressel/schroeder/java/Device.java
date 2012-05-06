package com.jamesdressel.schroeder.java;

import java.util.UUID;

public class Device {
	private UUID id;
	private String name;
	
	public Device(){
		id = UUID.randomUUID();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
