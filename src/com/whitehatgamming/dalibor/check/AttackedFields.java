package com.whitehatgamming.dalibor.check;

import java.util.List;

import com.whitehatgamming.dalibor.domain.ChessField;

public class AttackedFields {
	//Initialized with constructor;
	boolean[][]check = new boolean[8][8];
	
	public void markAttackedFields(List<ChessField> fields) {
		for (ChessField field : fields){
			check[field.getColumn()][field.getRow()]=true;
		}
	}

	public boolean contains(ChessField kingField) {
		return check[kingField.getColumn()][kingField.getRow()];
	}


}
