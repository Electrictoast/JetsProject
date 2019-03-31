package com.skilldistillery.projects.spaceships.ships;

public class Bomber extends Ship implements Weapon {

	public Bomber() {
	}

	public Bomber(String type, double speed, int range, double price) {
		super(type, speed, range, price);
	}

	@Override
	public void fire() {
		System.out.println(this.getType()+" Bombs away!");
		System.out.println("BOOM!\n\tBOOM!\n\t\tBOOM!");
	}

	@Override
	public String toString() {
		return "Bomber [name=" + name + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

}
