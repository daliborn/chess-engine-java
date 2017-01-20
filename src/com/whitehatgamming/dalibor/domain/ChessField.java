package com.whitehatgamming.dalibor.domain;

public enum ChessField {
	A1(Color.BLACK,0,7),A2(Color.WHITE,0,6),A3(Color.BLACK,0,5),A4(Color.WHITE,0,4),A5(Color.BLACK,0,3),A6(Color.WHITE,0,2),A7(Color.BLACK,0,1),A8(Color.WHITE,0,0),
	B1(Color.WHITE,1,7),B2(Color.BLACK,1,6),B3(Color.WHITE,1,5),B4(Color.BLACK,1,4),B5(Color.WHITE,1,3),B6(Color.BLACK,1,2),B7(Color.WHITE,1,1),B8(Color.BLACK,1,0),
	C1(Color.BLACK,2,7),C2(Color.WHITE,2,6),C3(Color.BLACK,2,5),C4(Color.WHITE,2,4),C5(Color.BLACK,2,3),C6(Color.WHITE,2,2),C7(Color.BLACK,2,1),C8(Color.WHITE,2,0),
	D1(Color.WHITE,3,7),D2(Color.BLACK,3,6),D3(Color.WHITE,3,5),D4(Color.BLACK,3,4),D5(Color.WHITE,3,3),D6(Color.BLACK,3,2),D7(Color.WHITE,3,1),D8(Color.BLACK,3,0),
	E1(Color.BLACK,4,7),E2(Color.WHITE,4,6),E3(Color.BLACK,4,5),E4(Color.WHITE,4,4),E5(Color.BLACK,4,3),E6(Color.WHITE,4,2),E7(Color.BLACK,4,1),E8(Color.WHITE,4,0),
	F1(Color.WHITE,5,7),F2(Color.BLACK,5,6),F3(Color.WHITE,5,5),F4(Color.BLACK,5,4),F5(Color.WHITE,5,3),F6(Color.BLACK,5,2),F7(Color.WHITE,5,1),F8(Color.BLACK,5,0),
	G1(Color.BLACK,6,7),G2(Color.WHITE,6,6),G3(Color.BLACK,6,5),G4(Color.WHITE,6,4),G5(Color.BLACK,6,3),G6(Color.WHITE,6,2),G7(Color.BLACK,6,1),G8(Color.WHITE,6,0),
	H1(Color.WHITE,7,7),H2(Color.BLACK,7,6),H3(Color.WHITE,7,5),H4(Color.BLACK,7,4),H5(Color.WHITE,7,3),H6(Color.BLACK,7,2),H7(Color.WHITE,7,1),H8(Color.BLACK,7,0);
	
	private ChessField(Color color, Integer column, Integer row){
		this.color = color;
		this.column = column;
		this.row = row;
	}
	private Color color;
	private Integer column;
	private Integer row;

	public Integer getColumn() {
		return column;
	}

	public Integer getRow() {
		return row;
	}

	public Color getColor() {
		return color;
	}

	public static ChessField convertToMove(int column, int row) {
		for(ChessField field : ChessField.values()){
			if(field.getColumn()==column&&field.getRow()==row){
				return field;
			}

		}
		//System.err.println("field is not found");
		return null;
	}
}
