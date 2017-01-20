package com.whitehatgamming.dalibor;

import java.util.ArrayList;
import java.util.TreeMap;

import com.whitehatgamming.dalibor.domain.ChessField;
import com.whitehatgamming.dalibor.domain.Color;
import com.whitehatgamming.dalibor.domain.Figure;
import com.whitehatgamming.dalibor.domain.FigureType;
import com.whitehatgamming.dalibor.domain.Player;



public class Game {
	private TreeMap<ChessField, Figure> board;
	private ArrayList<String> history;
	private Player player1;
	private Player player2;

	public Game(String player1Name, String player2Name) {
		this.board = new TreeMap<>();
		this.history = new ArrayList<>();
		//Players can be updated to be initialed from some more complicated component
		player1 = new Player(player1Name, Color.WHITE, ChessField.E1, true);
		player2 = new Player(player2Name, Color.BLACK, ChessField.E8, false);

		
		//White first row
		board.put(ChessField.A1, new Figure(FigureType.Rook,Color.WHITE, player1));
		board.put(ChessField.B1, new Figure(FigureType.Knight,Color.WHITE, player1));
		board.put(ChessField.C1, new Figure(FigureType.Bishop,Color.WHITE, player1));
		board.put(ChessField.D1, new Figure(FigureType.Queen,Color.WHITE, player1));
		board.put(ChessField.E1, new Figure(FigureType.King,Color.WHITE, player1));
		board.put(ChessField.F1, new Figure(FigureType.Bishop,Color.WHITE, player1));
		board.put(ChessField.G1, new Figure(FigureType.Knight,Color.WHITE, player1));
		board.put(ChessField.H1, new Figure(FigureType.Rook,Color.WHITE, player1));		
		
		//White second row
		board.put(ChessField.A2, new Figure(FigureType.Pawn,Color.WHITE, player1));
		board.put(ChessField.B2, new Figure(FigureType.Pawn,Color.WHITE, player1));
		board.put(ChessField.C2, new Figure(FigureType.Pawn,Color.WHITE, player1));
		board.put(ChessField.D2, new Figure(FigureType.Pawn,Color.WHITE, player1));
		board.put(ChessField.E2, new Figure(FigureType.Pawn,Color.WHITE, player1));
		board.put(ChessField.F2, new Figure(FigureType.Pawn,Color.WHITE, player1));
		board.put(ChessField.G2, new Figure(FigureType.Pawn,Color.WHITE, player1));
		board.put(ChessField.H2, new Figure(FigureType.Pawn,Color.WHITE, player1));		
		
		
		
		//Black first row
		board.put(ChessField.A8, new Figure(FigureType.Rook,Color.BLACK, player2));
		board.put(ChessField.B8, new Figure(FigureType.Knight,Color.BLACK, player2));
		board.put(ChessField.C8, new Figure(FigureType.Bishop,Color.BLACK, player2));
		board.put(ChessField.D8, new Figure(FigureType.Queen,Color.BLACK, player2));
		board.put(ChessField.E8, new Figure(FigureType.King,Color.BLACK, player2));
		board.put(ChessField.F8, new Figure(FigureType.Bishop,Color.BLACK, player2));
		board.put(ChessField.G8, new Figure(FigureType.Knight,Color.BLACK, player2));
		board.put(ChessField.H8, new Figure(FigureType.Rook,Color.BLACK, player2));		
		
		//Black second row
		board.put(ChessField.A7, new Figure(FigureType.Pawn,Color.BLACK, player2));
		board.put(ChessField.B7, new Figure(FigureType.Pawn,Color.BLACK, player2));
		board.put(ChessField.C7, new Figure(FigureType.Pawn,Color.BLACK, player2));
		board.put(ChessField.D7, new Figure(FigureType.Pawn,Color.BLACK, player2));
		board.put(ChessField.E7, new Figure(FigureType.Pawn,Color.BLACK, player2));
		board.put(ChessField.F7, new Figure(FigureType.Pawn,Color.BLACK, player2));
		board.put(ChessField.G7, new Figure(FigureType.Pawn,Color.BLACK, player2));
		board.put(ChessField.H7, new Figure(FigureType.Pawn,Color.BLACK, player2));	
		
		//Default Fields
		for(ChessField field : ChessField.values()){
			if(! board.containsKey(field)){
				board.put(field, new Figure(FigureType.None, field.getColor(), null));
			}
		}
		
	}
	
	public void print(){
		for(ChessField chessFiled : board.keySet()){			
			Figure figure = board.get(chessFiled);
			if(chessFiled.getRow().equals(0)){
				System.out.println(" | " + figure.toString() + " |");
			}else{
				System.out.print(" | " + figure.toString());
			}
		}
	}

	public void nextMove(ChessField currentFiled, ChessField nextFiled, boolean isCheck) {
		System.out.println("_______________________________");
		
		Figure figure = board.get(currentFiled);
		board.put(currentFiled, new Figure(FigureType.None, currentFiled.getColor(), null));
		System.out.println(figure.toString() + " move from " + currentFiled.name() + " to " + nextFiled.toString());
		System.out.println("   0   1   2   3   4   5   6   7  ");
		history.add(figure.toString() + " move from " + currentFiled.name() + " to " + nextFiled.toString());
		
		board.put(nextFiled, figure);
		
		updatePlayerOnTurn();
	}
	
	private void updatePlayerOnTurn() {

		if(player1.getOnTurn()){
			player1.setOnTurn(false);
			player2.setOnTurn(true);
		}else if(player2.getOnTurn()){
			player1.setOnTurn(true);
			player2.setOnTurn(false);
		}
		
	}

	public Figure getFigure(ChessField currentFiled) {
		return board.get(currentFiled);
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	
	public Player getPlayerOnTurn() {
		if(player1.getOnTurn()){
			return player1;
		}else if(player2.getOnTurn()){
			return player2;
		}else{
			System.err.println("No players on turn");
		}
		return null;
	}

	public ArrayList<String> getHistory() {
		return history;
	}

	public Player getWaitingPlayer() {
		if(! player1.getOnTurn()){
			return player1;
		}else if(! player2.getOnTurn()){
			return player2;
		}else{
			System.err.println("No players on turn");
		}
		return null;
	}
		
}
