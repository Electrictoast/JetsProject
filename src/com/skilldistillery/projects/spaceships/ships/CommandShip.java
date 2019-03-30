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
	private static final Exception OutOfBoundsException = null;
	public void run(Scanner sc) {
		List<Ship> deck= new ArrayList<>();
		List<String> shipInfo= new ArrayList<>();
		readShipData("ShipData.txt",shipInfo);
		fillDeck(shipInfo,deck);
		System.out.println(deck);
		menu(sc);
		
	}
	public void fillDeck(List<String> shipInfo, List<Ship> deck) {
		String[] temp;
		for (String ship : shipInfo) {
			temp = ship.split(", ");
//			String type, double speed, int range, double price
			if(temp[1].contains("Cargo")) {
				Ship tempShip =new Civilian(temp[0],Double.parseDouble(temp[1]),Integer.parseInt(temp[2]), Double.parseDouble(temp[3]));
				deck.add(tempShip);
			}else {
				Ship tempShip =new Combat(temp[0],Double.parseDouble(temp[1]),Integer.parseInt(temp[2]), Double.parseDouble(temp[3]));
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
			  while ( (line = br.readLine()) != null) {
			    shipInfo.add(line);
			  }
			  br.close();
			}
			catch (FileNotFoundException e) {
			  System.err.println("Invalid filename: " + e.getMessage());
			}
			catch (IOException e) {
			  System.err.println("Problem while reading "+fileName+": "+e.getMessage());
			}
	}

	public void getBestSpeed() {
//		loop through all ships to find best speed
	}
	public void getBestRange() {
//		loop through all ships to find best range
	}
	public void flyAll() {
// 		call fly() on all ships
	}
	public void listAll() {
//		print out list of ships for loop with new lines
	}
	public void loadAll() {
//		call load() on all cargo ships
	}
	public void fireAll() {
//		call fire() on all combat ships
	}
	public void addShip() {
//		add new ship to deck
	}
	public void pullShip() {
//		remove ship from deck
	}
	public int menu(Scanner sc) {
		Exception OutOfBoundsException= new Exception("Select a number between 1-9");
		boolean valid=false;
		int select=0;
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
		
		while(!valid) {
			try {
				select= sc.nextInt();
				if(select>0 && select<9 ) {
					valid=true;
					return select;
				}else {
					throw OutOfBoundsException;
				}
			}catch(InputMismatchException e){
				System.out.println("Please enter a number between 1 and 9");
				sc.nextLine();
			}catch(Exception e) {
				System.out.println("Please enter a number between 1 and 9");
				sc.nextLine();
			}
		}
		
		return select;
	}
	public void actionMenu(int select) {
		switch (select) {
		case 1:
			listAll();
		case 2:
			flyAll();
		case 3:
			getBestSpeed();
		case 4:
			getBestRange();
		case 5:
			loadAll();
		case 6:
			fireAll();
		case 7:
			addShip();
		case 8:
			pullShip();
		case 9:
			System.out.println("May the force be with you.");
			System.exit(0);
		}
	}
}
