package com.cardgame.model;

public enum Rank {
	TWO (2),
	THREE (3),
	FOR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	HEIGHT (8),
	NINE (9),
	JACK (10),
	QUEEN (11),
	KING (12),
	ACE (13);
	
	int rank;
	
	private Rank(int value) {
		rank = value;
	}
	
	public int value() {
		return rank;
	}
}
