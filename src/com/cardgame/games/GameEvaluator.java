package com.cardgame.games;

import java.util.List;

import com.cardgame.model.Player;
import com.cardgame.model.PlayingCard;

public interface GameEvaluator {
	
	 Player evaluateWinner(List<Player> players);
}

