package com.skilldistillery.projects.spaceships.ships;

public class Combat extends Ship {
	public void fire() {
//		pew pew
		System.out.println(this.getType()+" Fires all!\nPEW!PEW!PEW!PEW!PEW!");
	}
	public Combat() {
		super();
	}
	public Combat(String type, double speed, int range, double price) {
		super(type, speed, range, price);
	}

}
