package com.whitehatgamming.dalibor;

import java.io.IOException;
import java.util.List;

import com.whitehatgaming.UserInput;
import com.whitehatgaming.UserInputFile;
import com.whitehatgamming.dalibor.check.CheckEngine;
import com.whitehatgamming.dalibor.domain.ChessField;
import com.whitehatgamming.dalibor.validation.ValidationEngine;

public class Main {

	public static void main(String[] args) throws IOException {
		Game game = new Game("Magnus Carlsen","Sergey Karjakin");
		game.print();
		//sample-moves-invalid.txt, checkmate.txt
		String fileName = "/Users/daliborninkovic/Downloads/ProgTest/data/checkmate.txt";

		try {
			UserInput uf = new UserInputFile(fileName);			
			int[] nextMove = null;
			do {
				nextMove = uf.nextMove();
				
				if(nextMove!=null){
					nextMove(game, ChessField.convertToMove(nextMove[0],nextMove[1]),ChessField.convertToMove(nextMove[2],nextMove[3]));
				}								
				
			} while (nextMove!=null);												
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	/**
	 * Main method for chess logic
	 *
	 * @param game the game
	 * @param currentFiled the current filed
	 * @param nextFiled the next filed
	 */
	private static void nextMove(Game game, ChessField currentFiled, ChessField nextFiled) {
			//Validate move
			List<ChessField> attackedFields = ValidationEngine.validate(game, currentFiled, nextFiled);
			if(attackedFields.contains(nextFiled)){
				//mark attacked fields
				boolean isCheck = CheckEngine.markAttackedFields(game, currentFiled, nextFiled,attackedFields);
				if(isCheck){
					System.out.println("It's check!!!");
				}
				game.nextMove(currentFiled, nextFiled, isCheck);
				game.print();
			}else{
				System.err.println("Not a valid move!");
			}

		
	}

}
