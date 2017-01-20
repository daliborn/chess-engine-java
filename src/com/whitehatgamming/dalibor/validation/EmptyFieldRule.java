package com.whitehatgamming.dalibor.validation;

import com.whitehatgamming.dalibor.Game;
import com.whitehatgamming.dalibor.domain.ChessField;
import com.whitehatgamming.dalibor.domain.Figure;
import com.whitehatgamming.dalibor.domain.Player;

public class EmptyFieldRule {

	public static Boolean isValid(Game game, ChessField currentFiled, ChessField nextFiled) {
		//Empty field rule, figure can't be moved from empty field 
		Figure figure = game.getFigure(currentFiled);
		if(figure == null){
			System.out.println("Field is emptty! Can't move piece from empty field");
			return false;
		}
		
				
		Boolean player1Status = game.getPlayer1().getOnTurn();
		Boolean player2Status = game.getPlayer2().getOnTurn();
		
		//if both statuses are true or false, exception should be thrown probably, since something is not correct in game
		if(player1Status && player2Status){
			System.err.println("Both players onturn statuses are true");
			return false;
		}else if(! player1Status && ! player2Status){
			System.err.println("Both players onturn statuses are false");
			return false;
		}
		
		Player playerFigure = figure.getPlayer();
		// if players are not same
		if (! game.getPlayerOnTurn().equals(playerFigure)){
			System.err.println("Wrong turn of player!");
			return false;
		}
		
		if(currentFiled.equals(nextFiled)){
			System.err.println("currentFiled and nextFiled are same");
			return false;
		}
		
		return true;
	}

}
