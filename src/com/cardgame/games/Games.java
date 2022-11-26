package com.cardgame.games;

import com.cardgame.controller.GameController;
import com.cardgame.model.Deck;
import com.cardgame.model.DeckFactory;
import com.cardgame.model.DeckFactory.DeckType;
import com.cardgame.view.CommandLineView;
import com.cardgame.view.GameViewable;
import com.cardgame.view.GameViewables;
import com.cardgame.view.SwingView;

public class Games {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingView swingView = new SwingView();
		swingView.createAndShowGUI();
		GameViewable cliView = new CommandLineView();
		GameViewables viewables = new GameViewables();
		viewables.addViewable(cliView);
		viewables.addViewable(swingView);

		GameController gc = new GameController(DeckFactory.createDeck(DeckType.Normal), viewables, new HighCardGameEvaluator());
		gc.run();
	}
}
