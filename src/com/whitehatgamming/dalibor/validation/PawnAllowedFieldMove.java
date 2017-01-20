package com.whitehatgamming.dalibor.validation;

import java.util.ArrayList;
import java.util.List;

import com.whitehatgamming.dalibor.Game;
import com.whitehatgamming.dalibor.domain.ChessField;
import com.whitehatgamming.dalibor.domain.Color;
import com.whitehatgamming.dalibor.domain.Figure;
import com.whitehatgamming.dalibor.domain.FigureType;
import com.whitehatgamming.dalibor.domain.Player;

/**
 * Pawns have the most complex rules of movement: A pawn moves straight forward
 * one square, if that square is vacant. If it has not yet moved, a pawn also
 * has the option of moving two squares straight forward, provided both squares
 * are vacant. Pawns cannot move backwards. Pawns are the only pieces that
 * capture differently from how they move. A pawn can capture an enemy piece on
 * either of the two squares diagonally in front of the pawn (but cannot move to
 * those squares if they are vacant).
 * source: wikipedia
 */
public class PawnAllowedFieldMove implements AllowedFieldMove {
	private Game game;
	private ChessField currentField;
	private ChessField nextField;
	private int currentRow;
	private int currentColumn;
	private int nextColumn;
	private Player player;

	public PawnAllowedFieldMove(Game game, ChessField currentField, ChessField nextField) {
		super();
		this.game = game;
		this.currentField = currentField;
		this.nextField = nextField;
		this.currentRow = currentField.getRow();	
		this.currentColumn = currentField.getColumn();
		this.nextColumn = nextField.getColumn();
		this.player = game.getPlayerOnTurn();
	}

	@Override
	public List<ChessField> getListOfAttackedFields() {
		List<ChessField> listOfAllowedMoves = generateListOfPossibleMoves();
		isNextFieldVacant(listOfAllowedMoves, 1);
		
		//pawn can move to next two fields
		if(currentRow == 1 || currentRow == 6){
			isNextFieldVacant(listOfAllowedMoves,2);
		}
		
		//pawn can take opponent figure
		if(nextColumn!=currentColumn){
			Figure frontFigure = game.getFigure(nextField);
			if(! frontFigure.isOponent(player)){
				System.out.println("Can't eat your own figure");
				listOfAllowedMoves.remove(nextField);
			}
		}
		
		return listOfAllowedMoves;
	}


	private List<ChessField> generateListOfPossibleMoves() {
		List<ChessField> allowedMoves = new ArrayList<>();
		if(Color.WHITE.equals(player.getColor())){
			if(currentColumn!=7){
				allowedMoves.add(ChessField.convertToMove(currentColumn+1, currentRow - 1));
			}
			allowedMoves.add(ChessField.convertToMove(currentColumn, currentRow - 1));
			if(currentColumn!=0){
				allowedMoves.add(ChessField.convertToMove(currentColumn-1, currentRow - 1));
			}
			if(currentRow == 6){
				allowedMoves.add(ChessField.convertToMove(currentColumn, currentRow-2));
			}
		}else{
			if(currentColumn!=7){
				allowedMoves.add(ChessField.convertToMove(currentColumn+1, currentRow + 1));
			}
			allowedMoves.add(ChessField.convertToMove(currentColumn, currentRow+1));
			if(currentColumn!=0){
				allowedMoves.add(ChessField.convertToMove(currentColumn-1, currentRow + 1));
			}
			if(currentRow == 1){
				allowedMoves.add(ChessField.convertToMove(currentColumn, currentRow+2));
			}
		}
		
		return allowedMoves;
	}


	private void isNextFieldVacant(List<ChessField> listOfAllowedMoves, int nextRow) {
		int index = 0;
		if(Color.WHITE.equals(player.getColor())){
			index = currentField.getRow()-nextRow;
		}else{
			index = currentField.getRow()+nextRow;
		}
		
		ChessField frontField = ChessField.convertToMove(currentField.getColumn(), index);
		Figure frontFigure = game.getFigure(frontField);
		if(FigureType.None.equals(frontFigure.getFigureType())){
			return;
		}else{
			System.out.println("frontField is removed from list of allowed moves");
			listOfAllowedMoves.remove(frontField);
		}

		
	}

}
