package com.whitehatgamming.dalibor.validation;

import java.util.List;

import com.whitehatgamming.dalibor.domain.ChessField;

public interface AllowedFieldMove {
	
	/**
	 * Gets the list of attacked fields.Only pawn has a different logic for fields which attacks and moves
	 *
	 * @return the list of attacked fields
	 */
	List<ChessField> getListOfAttackedFields();
}
