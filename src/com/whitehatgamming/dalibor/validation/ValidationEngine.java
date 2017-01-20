package com.whitehatgamming.dalibor.validation;

import java.util.ArrayList;
import java.util.List;

import com.whitehatgamming.dalibor.Game;
import com.whitehatgamming.dalibor.domain.ChessField;

public class ValidationEngine {

	public static List<ChessField> validate(Game game, ChessField currentFiled, ChessField nextFiled) {
		List<ChessField> allowedFields = new ArrayList<>();
		//Empty field rule, figure can't be moved from empty field or can't be moved if it is opponent piece 
		Boolean isEmptyField = EmptyFieldRule.isValid(game, currentFiled,nextFiled);
		if(! isEmptyField){
			return allowedFields;
		}
		
		//line of move rule, for example knight can only move to L shape
		AllowedFieldMove allowedFieldMove = AllowedFieldMoveFactory.makeAllowedFieldMove(game, currentFiled, nextFiled);
		
		//disable validation for non existent figure validators
		if(allowedFieldMove!=null){
			return allowedFieldMove.getListOfAttackedFields();
		}else{
			allowedFields.add(nextFiled);
		}
		return allowedFields;
		
	}

}
