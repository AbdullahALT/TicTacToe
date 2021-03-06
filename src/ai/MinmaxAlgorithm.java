/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.Player;
import models.Position;
import models.Board;
import models.Cell;
import models.Computer;
import models.Human;
import models.Sign;
import ui.State;
import util.PlayerManager;

/**
 *
 * @author abaaltamimi
 */
public class MinmaxAlgorithm implements AIAlgorithm {

    private Board board;
    private Player me;
    private Player enemy;

    public MinmaxAlgorithm(Board board, Player me, Player enemy) {
	this.board = board;
	this.me = me;
	this.enemy = enemy;
    }

    @Override
    public Position move() {
	if (board.isFirstTurn()) {
	    Random rand = new Random();
	    return new Position(rand.nextInt(3), rand.nextInt(3));
	}
	
	int[] result = minmax(100, me, Integer.MIN_VALUE, Integer.MAX_VALUE); // depth, max turn
	System.out.println("Best: {" + result[1] + ", " + result[2] + "}");
	return new Position(result[1], result[2]);   // row, col
    }

    /**
     * Recursive minimax at level of depth for either maximizing or minimizing
     * The minmax will simulate a game between 'human' and 'computer'
     * player. Return int[3] of {score, row, col}
     */
    private int[] minmax(int depth, Player player, int alpha, int beta) {
	// Generate possible next moves in a List of int[2] of {row, col}.
	System.out.println("Depth: " + depth);
	System.out.println(board);
	List<Position> nextMoves = generateMoves();
	// Computer is maximizing; while Human is minimizing
	int score;
	int bestRow = -1;
	int bestCol = -1;

	if (nextMoves.isEmpty() || depth == 0) {
	    // Gameover or depth reached, evaluate score
	    score = board.evaluate(me);
	    return new int[] {score, bestRow, bestCol};
	} else {
	    for (Position position : nextMoves) {
		// Try this move for the current "player"
		board.getCellAt(position).setOwner(player);
		if (player.equals(me)) {  // Me (computer) is maximizing player
		    score = minmax(depth - 1, enemy, alpha, beta)[0];
		    if (score > alpha) {
			alpha = score;
			bestRow = position.getRow();
			bestCol = position.getColumn();
		    }
		} else {  // Opponent is minimizing player
		    score = minmax(depth - 1, me, alpha, beta)[0];
		    if (score < beta) {
			beta = score;
			bestRow = position.getRow();
			bestCol = position.getColumn();
		    }
		}
		// Undo move
		board.getCellAt(position).setOwner(null);
		// cut-off
		if (alpha >= beta) break;
	    }
	}
	return new int[]{(player.equals(me)? alpha : beta), bestRow, bestCol};
    }
    
    private List<Position> generateMoves(){
	if(board.checkWin() != null)
	    return new ArrayList<>();
	//if game is over by one of the players wining, return an empty list
	return board.getEmptyPosition();
    }
}
