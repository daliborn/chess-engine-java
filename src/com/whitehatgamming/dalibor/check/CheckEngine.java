package com.whitehatgamming.dalibor.check;

import java.util.List;

import com.whitehatgamming.dalibor.Game;
import com.whitehatgamming.dalibor.domain.ChessField;
import com.whitehatgamming.dalibor.domain.Player;

/**
 * Maintain two 2d arrays of attacked fields 
 */
public class CheckEngine {


	public static boolean markAttackedFields(Game game, ChessField currentFiled, ChessField nextFiled, List<ChessField> attackedFields) {
		Player player1 = game.getPlayerOnTurn();
		Player player2 = game.getWaitingPlayer();
		
		player2.addAttackedFields(attackedFields);
		
		ChessField kingField = player2.getKingPosition();
		AttackedFields fields = player2.getAttackedFields();
		return fields.contains(kingField);
	}

}
