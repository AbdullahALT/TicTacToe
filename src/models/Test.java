/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ai.Heuristic;
import ai.MinmaxAlgorithm;
import util.PlayerManager;
import util.SignManager;

/**
 *
 * @author abaaltamimi
 */
public class Test {
    
    public static void main(String args[]){
	
	Cell[][] cells = new Cell[3][3];
	initCells(cells);
	
	PlayerManager playerManager = new PlayerManager(new SignManager(null, null));
	
	cells[0][2].setOwner(playerManager.getComputer());
	cells[0][0].setOwner(playerManager.getHuman());
	cells[2][2].setOwner(playerManager.getComputer());
//	cells[1][2].setOwner(playerManager.getComputer());
//	cells[1][2].setOwner(playerManager.getHuman());
	
	Board board = new Board(cells);
	board.setHeuristic(new Heuristic());
	
	
	int score = board.evaluate(playerManager.getComputer());
	
	System.out.println(board);
	System.out.println(score);
	
	playerManager.getComputer().setAiAlgorithm(new MinmaxAlgorithm(board, playerManager.getComputer(), playerManager.getHuman()));
	playerManager.getHuman().setAiAlgorithm(new MinmaxAlgorithm(board, playerManager.getHuman(), playerManager.getComputer()));
	
	Position move = playerManager.getComputer().getAiMove();
    }
    
    public static void initCells(Cell[][] cells){
	for(int row = 0; row < 3; row++)
	    for(int column = 0; column < 3; column++)
		cells[row][column] = new Cell();
    }
    
}
