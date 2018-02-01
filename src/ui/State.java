/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import models.Player;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import models.Human;
import models.Computer;
import models.Sign;

/**
 *
 * @author abaaltamimi
 */
public class State {
    Player currentPlayer;
    Board board;
    
    Player human;
    Player computer;
    
    public State(Board board, Sign humanSign, Sign computerSign) {
	human = new Human(humanSign);
	computer = new Computer(computerSign);
        this.currentPlayer = (humanSign.getType() == Sign.Type.X)? human : computer;
        this.board = board;
    }

    public void humanTurn(){
	currentPlayer = human;
    }
    
    public void computerTurn(){
	currentPlayer = computer;
    }

    public Player getCurrentPlayer() {
	return currentPlayer;
    }
    
    public void acquire(Class<?> Class, Cell cell){
	board.acquire(Class, cell, currentPlayer);
	currentPlayer.nextPlayer(this);
    }
    
    public boolean isFirstTurn(){
	return board.isFirstTurn();
    }

    public Player getHuman() {
	return human;
    }

    public Player getComputer() {
	return computer;
    }
    
    public Cell[][] getCells(){
	return board.getCells();
    }
    
    public boolean isComputerPlaying(){
	return currentPlayer == computer;
    }
    
    public boolean isHumanPlaying(){
	return currentPlayer == human;
    }
    
    public Player isWin(){
	return board.checkWin();
    }
}
