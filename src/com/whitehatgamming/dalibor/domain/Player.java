package com.whitehatgamming.dalibor.domain;

import java.util.List;

import com.whitehatgamming.dalibor.check.AttackedFields;

public class Player {

	private String name;
	private Color color; 
	private Boolean onTurn;
	private AttackedFields attackedFields; 
	private ChessField kingPosition;

	public Player(String name, Color color, ChessField kingPosition, boolean onTurn) {
		this.name = name;
		this.color = color;
		this.onTurn = onTurn;
		this.kingPosition= kingPosition;
		this.attackedFields = new AttackedFields();
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public Boolean getOnTurn() {
		return onTurn;
	}

	public void setOnTurn(Boolean onTurn) {
		this.onTurn = onTurn;
	}
	
	public void addAttackedFields(List<ChessField> fields){
		this.attackedFields.markAttackedFields(fields);
	}
	
	public AttackedFields getAttackedFields() {
		return this.attackedFields;
	}
	
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", onTurn=" + onTurn + "]";
	}

	public ChessField getKingPosition() {
		return kingPosition;
	}

}
