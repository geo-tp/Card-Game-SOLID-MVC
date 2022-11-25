package com.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.cardgame.games.GameEvaluator;
import com.cardgame.model.Deck;
import com.cardgame.model.Player;
import com.cardgame.model.PlayingCard;
import com.cardgame.view.CommandLineView;
import com.cardgame.view.GameViewable;

public class GameController {
	
	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed, Aborted;
	}
	
	Deck deck;
	List<Player> players;
	Player winner;
	GameViewable view;
	GameEvaluator evaluator;
	
	
	GameState gameState;
	
	public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
		super();
		this.deck = deck;
		this.view = view;
		this.evaluator = evaluator;
		this.players = new ArrayList<Player>();
		this.gameState = GameState.AddingPlayers;
		view.setController(this);
	}
	
	public void run() {
		
		while (this.gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}
		
		switch(this.gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		case Aborted:
			this.exitGame();
			break;
		}
		
		
	}
	
	public void nextAction(String nextLine) {
		if ("q".equals(nextLine)) {
			this.exitGame();
		}
		
		else {
			this.startGame();
		}
	}
	
	public void exitGame() {
		this.gameState = GameState.Aborted;
		System.exit(0);
	}
	
	public void addPlayer(String playerName) {
		if (this.gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(this.players.size(), playerName);
		}
	}
	
	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle();
			
			int playerIndex = 1;
			for (Player player : this.players) {
				player.addCardToHand(this.deck.getCard());
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			
			gameState = GameState.CardsDealt;
		}
		this.run();
	}
	
	public void flipCards() {
		int playerIndex = 1;
		for(Player player : this.players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
		}
		
		this.winner = evaluator.evaluateWinner(this.players);
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}
	
	void displayWinner() {
		view.showWinner(this.winner.getName());
	}
	
	void rebuildDeck() {
		for (Player player : this.players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
}
