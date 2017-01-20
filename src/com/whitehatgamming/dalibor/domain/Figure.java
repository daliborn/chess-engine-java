package com.whitehatgamming.dalibor.domain;

public class Figure {

	private FigureType figureType;
	private Color color;
	private Player player;
	
	public Figure(FigureType figureType, Color color, Player player) {
		super();
		this.figureType = figureType;
		this.color = color;
		this.player = player;
	}
	public FigureType getFigureType() {
		return figureType;
	}
	public void setFigureType(FigureType figureType) {
		this.figureType = figureType;
	}
	public Color getColor() {
		if(figureType.equals(FigureType.None)){
			return null;
		}
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Override
	public String toString() {
		if(FigureType.None.equals(figureType)){
			return  " ";
		}
		if(Color.WHITE.equals(color)){
			return figureType.getSymbol().toUpperCase();
		}else{
			return figureType.getSymbol();
		}
		
	}
	public boolean isOponent(Player player2) {
		if(player==null){
			return false;
		}
		return ! player.equals(player2);
	}
}
