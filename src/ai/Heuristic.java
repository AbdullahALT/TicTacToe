/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import models.Cell;
import models.Player;

/**
 *
 * @author abaaltamimi
 */
public class Heuristic implements IHeuristic{
    
    /**
     * The heuristic evaluation function for the current board
     *
     * @Return +100, +10, +1 for EACH 3-, 2-, 1-in-a-line for computer. -100,
     * -10, -1 for EACH 3-, 2-, 1-in-a-line for opponent. 0 otherwise
     */
    public int evaluate(Cell[][] cells, Player player) {
	int score = 0;
	// Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
	score += evaluateLine(cells[0][0], cells[0][1], cells[0][2], player); // row 0
	score += evaluateLine(cells[1][0], cells[1][1], cells[1][2], player); // row 1
	score += evaluateLine(cells[2][0], cells[2][1], cells[2][2], player); // row 2
	score += evaluateLine(cells[0][0], cells[1][0], cells[2][0], player); // col 0
	score += evaluateLine(cells[0][1], cells[1][1], cells[2][1], player); // col 0
	score += evaluateLine(cells[0][2], cells[1][2], cells[2][2], player); // col 0
	
	score += evaluateLine(cells[0][0], cells[1][1], cells[2][2], player); // diagonal
	score += evaluateLine(cells[0][2], cells[1][1], cells[2][0], player); // alternate diagonal
	return score;
    }
    
    /**
     * The heuristic evaluation function for the given line of 3 cells
     *
     * @Return +100, +10, +1 for 3-, 2-, 1-in-a-line for computer. -100, -10, -1
     * for 3-, 2-, 1-in-a-line for opponent. 0 otherwise
     */
    private int evaluateLine(Cell first, Cell second, Cell third, Player player){
	int score = 0;
	if (player.equals(first.getOwner())) { // if player own this cell
	    score = 1;
	} else if (first.getOwner() != null) { // if opponent own this cell
	    score = -1;
	}
	
	if (player.equals(second.getOwner())) {
	    if (score == 1) {   // if first is owned by the player
		score = 10;
	    } else if (score == -1) {  // if first is owned by the opponent
		return 0;
	    } else {  // first is not owed by anyone
		score = 1;
	    }
	} else if (second.getOwner() != null) {
	    if (score == -1) { // if first is owned by the opponent
		score = -10;
	    } else if (score == 1) { // if first is owned by the opponent
		return 0;
	    } else {  // first is not owed by anyone
		score = -1;
	    }
	}
	
	if (player.equals(third.getOwner())) {
	    if (score > 0) {  // first and/or second is owned by the player
		score *= 10;
	    } else if (score < 0) {  // first and/or second is owned by opponent
		return 0;
	    } else {  // first and second are empty
		score = 1;
	    }
	} else if (third.getOwner() != null) {
	    if (score < 0) {  // first and/or second is owned by opponent
		score *= 10;
	    } else if (score > 1) {  // first and/or second is owned by player
		return 0;
	    } else {  // first and second are empty
		score = -1;
	    }
	}
	
	return score;
    }
}
