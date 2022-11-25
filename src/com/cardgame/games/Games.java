package com.cardgame.games;

import com.cardgame.controller.GameController;
import com.cardgame.model.Deck;
import com.cardgame.view.CommandLineView;
import com.cardgame.view.SwingView;

public class Games {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingView sv = new SwingView();
		sv.createAndShowGUI();
		GameController gc = new GameController(new Deck(), sv, new HighCardGameEvaluator());
		gc.run();
	}

}
