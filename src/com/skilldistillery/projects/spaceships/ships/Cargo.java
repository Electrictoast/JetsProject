package com.skilldistillery.projects.spaceships.ships;

public class Cargo extends Ship implements Hold {
	public void load() {
//		load cargo onto ship
		System.out.println(this.getType()+ " is loaded and ready to launch.");
	}
	@Override
	public String toString() {
		return "Cargo [name=" + name + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}
	public Cargo() {
		super();
	}
	public Cargo(String type, double speed, int range, double price) {
		super(type, speed, range, price);
	}

}
