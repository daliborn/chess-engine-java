package com.whitehatgamming.dalibor.validation;

import java.util.ArrayList;
import java.util.List;

import com.whitehatgamming.dalibor.Game;
import com.whitehatgamming.dalibor.domain.ChessField;
import com.whitehatgamming.dalibor.domain.Color;
import com.whitehatgamming.dalibor.domain.Player;

public class QueenAllowedMove implements AllowedFieldMove {
	private Game game;
	private ChessField currentField;
	private ChessField nextField;
	private int currentRow;
	private int currentColumn;
	private int nextColumn;
	private Player player;

	public QueenAllowedMove(Game game, ChessField currentField, ChessField nextField) {
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
		// TODO update proper logic, currently use from pawn
		List<ChessField> list = generateListOfPossibleMoves();
		list.add(nextField);
		return list;
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

}
