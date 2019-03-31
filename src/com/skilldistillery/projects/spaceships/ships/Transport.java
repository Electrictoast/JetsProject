package com.skilldistillery.projects.spaceships.ships;

public class Transport extends Ship implements Hold {

	public Transport() {
	}

	public Transport(String type, double speed, int range, double price) {
		super(type, speed, range, price);
	}

	@Override
	public void load() {
		System.out.println(this.getType()+" Loading passengers.");
		System.out.println("All aboard!");
	}

	@Override
	public String toString() {
		return "Transport [name=" + name + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

}
