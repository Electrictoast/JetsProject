package com.skilldistillery.projects.spaceships.ships;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandShip {
	public void run(Scanner sc) {
		List<Ship> deck= new ArrayList<>();
		List<String> shipInfo= new ArrayList<>();
		readShipData("ShipData.txt",shipInfo);
		fillDeck(shipInfo,deck);
		System.out.println(deck);
		
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
	public int menu(Scanner sc) {
		System.out.println("What are your orders admiral?");
		System.out.println("1. ");
//		fill out menu
		return sc.nextInt();
	}
}
