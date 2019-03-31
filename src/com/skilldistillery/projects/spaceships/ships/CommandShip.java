package com.skilldistillery.projects.spaceships.ships;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommandShip {
	public void run(Scanner sc) {
		List<Ship> deck = new ArrayList<>();
		List<String> shipInfo = new ArrayList<>();
		readShipData("ShipData.txt", shipInfo);
		fillDeck(shipInfo, deck);
		while (true) {
			int select = menu(sc);
			actionMenu(select, deck, sc);
		}
	}

	public void fillDeck(List<String> shipInfo, List<Ship> deck) {
		String[] temp;
		for (String ship : shipInfo) {
			temp = ship.split(", ");
//			String type, double speed, int range, double price
			if (temp[0].contains("Cargo")) {
				Cargo tempShip = new Cargo(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]),
						Double.parseDouble(temp[3]));
				deck.add(tempShip);
			} else if (temp[0].contains("X")) {
				Fighter tempShip = new Fighter(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]),
						Double.parseDouble(temp[3]));
				deck.add(tempShip);
			} else if (temp[0].contains("Y")) {
				Bomber tempShip = new Bomber(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]),
						Double.parseDouble(temp[3]));
				deck.add(tempShip);
			} else if (temp[0].contains("Transport")) {
				Transport tempShip = new Transport(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]),
						Double.parseDouble(temp[3]));
				deck.add(tempShip);
			}
		}
	}

	public void readShipData(String fileName, List<String> shipInfo) {
//		read ShipData.txt to create objects
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				shipInfo.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + fileName + ": " + e.getMessage());
		}
	}

	public void getBestSpeed(List<Ship> deck) {
//		loop through all ships to find best speed
		Ship temp = null;
		for (Ship ship : deck) {
			if (temp == null) {
				temp = ship;
			} else if (ship.getSpeed() > temp.getSpeed()) {
				temp = ship;
			}
		}
		System.out.println(temp);
	}

	public void getBestRange(List<Ship> deck) {
//		loop through all ships to find best range
		Ship temp = null;
		for (Ship ship : deck) {
			if (temp == null) {
				temp = ship;
			} else if (ship.getRange() > temp.getRange()) {
				temp = ship;
			}
		}
		System.out.println(temp);
	}

	public void flyAll(List<Ship> deck) {
// 		call fly() on all ships
		for (Ship ship : deck) {
			ship.fly();
		}
	}

	public void listAll(List<Ship> deck) {
//		print out list of ships for loop with new lines
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i));
		}
	}

	public void loadAll(List<Ship> deck) {
//		call load() on all cargo ships 
		for (int i = 0; i < deck.size(); i++) {
			if (deck.get(i) instanceof Cargo) {
				((Cargo) deck.get(i)).load();
			} else if (deck.get(i) instanceof Transport) {
				((Transport) deck.get(i)).load();
			}
		}
	}

	public void fireAll(List<Ship> deck) {
//		call fire() on all combat ships
		for (int i = 0; i < deck.size(); i++) {
			if (deck.get(i) instanceof Fighter) {
				((Fighter) deck.get(i)).fire();
			} else if (deck.get(i) instanceof Bomber) {
				((Bomber) deck.get(i)).fire();
			}
		}
	}

	public void addShip(List<Ship> deck, Scanner sc) {
//		add new ship to deck
		String type = "";
		double speed = 0;
		int range = 0;
		double price = 0;
		boolean valid = false;
		do {
			try {
				System.out.println("Please enter the type of ship you would like to add\n(i.e. X-wing, Tie Fighter)");
				type = sc.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error invalid input");
				valid = false;
			}
		} while (!valid);
		do {
			try {
				System.out.println("Please enter the max speed of the new " + type);
				speed = sc.nextDouble();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error invalid input");
				valid = false;
			}
		} while (!valid);
		do {
			try {
				System.out.println("Please enter the max range of the new " + type);
				range = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error invalid input");
				valid = false;
			}
		} while (!valid);
		do {
			try {
				System.out.println("Please enter the purchase price of the new " + type);
				price = sc.nextDouble();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error invalid input");
				valid = false;
			}
		} while (!valid);
		deck.add(new ShipImpl(type, speed, range, price));
	}

	public void pullShip(List<Ship> deck, Scanner sc) {
//		remove ship from deck
		boolean valid = false;
		for (int i = 0; i < deck.size(); i++) {
			System.out.print("Ship # " + (i + 1) + ": ");
			System.out.println(deck.get(i));
		}
		do {
			try {
				System.out.println("Which number ship would you like to decommission?");
				int choice = sc.nextInt();
				valid = true;
				System.out.println("Aye aye!");
				deck.remove(choice);
			} catch (Exception e) {
				System.out.println("invalid entry");
				valid = false;
			}
		} while (!valid);
	}

	public int menu(Scanner sc) {
		Exception OutOfBoundsException = new Exception("Select a number between 1-9");
		boolean valid = false;
		int select = 0;
		System.out.println("What are your orders admiral?");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest");
		System.out.println("4. View ship with longest range");
		System.out.println("5. Load all cargo ships");
		System.out.println("6. Fire all!");
		System.out.println("7. Add ship to fleet");
		System.out.println("8. Decommission ship");
		System.out.println("9. Quit");

		while (!valid) {
			try {
				select = sc.nextInt();
				if (select > 0 && select < 9) {
					valid = true;
					return select;
				} else {
					throw OutOfBoundsException;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number between 1 and 9");
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Please enter a number between 1 and 9");
				sc.nextLine();
			}
		}

		return select;
	}

	public void actionMenu(int select, List<Ship> deck, Scanner sc) {
		sc.nextLine();
		switch (select) {
		case 1:
			listAll(deck);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 2:
			flyAll(deck);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 3:
			getBestSpeed(deck);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 4:
			getBestRange(deck);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 5:
			loadAll(deck);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 6:
			fireAll(deck);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 7:
			addShip(deck, sc);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 8:
			pullShip(deck, sc);
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 9:
			System.out.println("May the force be with you.");
			System.exit(0);
		}
	}
}
