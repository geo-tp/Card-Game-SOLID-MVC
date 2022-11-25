package com.cardgame.view;
import java.util.Scanner;

import com.cardgame.controller.GameController;

public class CommandLineView implements GameViewable {
	
	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public void setController(GameController gc) {
		this.controller = gc;
	};
	
	public void promptForPlayerName() {
		System.out.println("Enter player name : ");
		String name = keyboard.nextLine();
		if (name.isEmpty()) {
			controller.startGame();
		} else {
			controller.addPlayer(name);
		}
	};
	
	public void promptForFlip() {
		System.out.println("Press enter to reveal cards");
		keyboard.nextLine();
		controller.flipCards();
	};
	
	public void promptForNewGame() {
		System.out.println("Press enter to deal again or q to exit");
		controller.nextAction(keyboard.nextLine());
	};
	
	public void showWinner(String playerName) {
		System.out.println("Winner is " + playerName + "!");
	};
	
	public void showPlayerName(int size, String playerName) {
		System.out.println("Your name " + playerName);

	};
	
	public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
		System.out.println("["+playerIndex+"] [" + playerName + "] [x][x]");

	};
	
	public void showCardForPlayer(int i, String playerName, String rank, String suit) {
		System.out.println("["+i+"] [" + playerName + "][" +rank+ "][" +suit+"]");

	};
}