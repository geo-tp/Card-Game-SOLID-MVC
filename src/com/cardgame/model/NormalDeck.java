package com.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class NormalDeck extends Deck {
		
	public NormalDeck() {
		this.cards = new ArrayList<PlayingCard>();
		for (Rank rank : Rank.values()) {
			for (Suit suit: Suit.values()) {
				System.out.println("Creating card ["+rank+"]["+suit+"]");
				this.cards.add(new PlayingCard(rank, suit));
			}
		}
		shuffle();
	}
}