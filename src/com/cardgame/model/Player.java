package com.cardgame.model;

public class Player implements IPlayer {

	private String name;
	private Hand hand;
	
	public Player(String name) {
		super();
		this.name = name;
		this.hand = new Hand();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addCardToHand(PlayingCard pc) {
		this.hand.addCard(pc);
	}
	
	public PlayingCard getCard(int index) {
		return hand.getCard(index);
	}
	
	public PlayingCard removeCard() {
		return hand.removeCard();
	}
}

