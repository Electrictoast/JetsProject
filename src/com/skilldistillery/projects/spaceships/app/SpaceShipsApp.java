package com.skilldistillery.projects.spaceships.app;

import java.util.Scanner;

import com.skilldistillery.projects.spaceships.ships.CommandShip;

public class SpaceShipsApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CommandShip command=new CommandShip();
		command.run(sc);
	}

}
