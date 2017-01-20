package com.whitehatgamming.dalibor.domain;

public enum FigureType {
	    None("n"), Pawn("p"), Knight("n"), Bishop("b"), Rook("r"), Queen("q"), King("k");
	
		private String symbol;

		private FigureType(String symbol){
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;			
		}
	
}
