package com.skilldistillery.projects.spaceships.ships;

public abstract class Ship {
	String name;
	double speed;
	int range;
	double price;
	
	public void fly() {
		System.out.println(this.getType()+" :Engines to max (Spaceship noises)");
	}
	public Ship() {
		
	}
	public Ship(String type, double speed, int range, double price) {
		this.name=type;
		this.speed=speed;
		this.range=range;
		this.price=price;
	}
	@Override
 	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + range;
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ship))
			return false;
		Ship other = (Ship) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (range != other.range)
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ship [name=" + name + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}
	public String getType() {
		return name;
	}
	public void setType(String type) {
		this.name = type;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
