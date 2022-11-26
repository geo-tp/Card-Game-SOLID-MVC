package com.cardgame.model;

public class WinningPlayer implements IPlayer {
	
	IPlayer winner;
	
	public WinningPlayer(IPlayer player) {
		this.winner = player;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "* * * * " + this.winner.getName() + " * * * * * ";
	}

	@Override
	public void addCardToHand(PlayingCard pc) {
		// TODO Auto-generated method stub
		this.winner.addCardToHand(pc);
	}

	@Override
	public PlayingCard getCard(int index) {
		// TODO Auto-generated method stub
		return this.winner.getCard(index);
	}

	@Override
	public PlayingCard removeCard() {
		// TODO Auto-generated method stub
		return this.winner.removeCard();
	}
	
}
