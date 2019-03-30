package com.skilldistillery.projects.spaceships.ships;

public class Civilian extends Ship {
	public void load() {
//		load cargo onto ship
		System.out.println(this.getType()+ " is loaded and ready to launch.");
	}
	public Civilian() {
		super();
	}
	public Civilian(String type, double speed, int range, double price) {
		super(type, speed, range, price);
	}

}
