package com.skilldistillery.projects.spaceships.ships;

public class Fighter extends Ship implements Weapon{
	public void fire() {
//		pew pew
		System.out.println(this.getType()+" Fires all!\nPEW!PEW!\n\tPEW!PEW!PEW!");
	}
	public Fighter() {
		super();
	}
	public Fighter(String type, double speed, int range, double price) {
		super(type, speed, range, price);
	}

}
