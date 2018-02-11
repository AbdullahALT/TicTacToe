/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import models.Board;
import models.Cell;
import models.Player;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import models.Human;
import models.Computer;
import models.Sign;
import util.PlayerManager;

/**
 *
 * @author abaaltamimi
 */
public class State {
    private Player currentPlayer;    
    private Player computer;
    private Player human;
    
    public State(PlayerManager playerManager) {
	this.computer = playerManager.getComputer();
	this.human = playerManager.getHuman();
        this.currentPlayer = playerManager.getPlayerWithSign(Sign.Type.X);
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
    
    public void nextPlayer(){
	currentPlayer.nextPlayer(this);
    }
    
    public boolean isComputerPlaying(){
	return currentPlayer == computer;
    }
    
    public boolean isHumanPlaying(){
	return currentPlayer == human;
    }
}
