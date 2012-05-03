package com.jamesdressel.schroeder.java;

import java.util.UUID;

public class Account {
	private UUID id;
	private String name;
	
	public Account(){
		setName("");
		id = UUID.randomUUID();
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
	
	public UUID getID(){
		return id;
	}
	
	
	
	
}
