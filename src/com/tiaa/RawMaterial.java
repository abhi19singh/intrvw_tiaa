package com.tiaa;

public enum RawMaterial {
	
	BOLT("Bolt", false),
	MACHINE("Machine", false);
	
	private boolean used;
	private String name;
	private RawMaterial(String name, boolean used) {
		this.used = used;
		this.name = name;
	}

	public boolean isMaterialUsed() {
		return used;
	}
	
	public String getName() {
		return name;
	}
}
