package com.whitehatgamming.dalibor.validation;

import com.whitehatgamming.dalibor.Game;
import com.whitehatgamming.dalibor.domain.ChessField;
import com.whitehatgamming.dalibor.domain.FigureType;

public class AllowedFieldMoveFactory {

	public static AllowedFieldMove makeAllowedFieldMove(Game game, ChessField currentFiled, ChessField nextFiled) {
		if (FigureType.Pawn.equals(game.getFigure(currentFiled).getFigureType())){
			return new PawnAllowedFieldMove(game, currentFiled, nextFiled);
		}else if(FigureType.Queen.equals(game.getFigure(currentFiled).getFigureType())){
			return new QueenAllowedMove(game, currentFiled, nextFiled);
		}
		return null;
	}

}
