package com.cardgame.games;

import java.util.List;

import com.cardgame.model.IPlayer;
import com.cardgame.model.PlayingCard;

public interface GameEvaluator {
	
	 IPlayer evaluateWinner(List<IPlayer> players);
}

