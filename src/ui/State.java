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
    private PlayerManager playerManager;
    
    public State(PlayerManager playerManager) {
	this.playerManager = playerManager;
        this.currentPlayer = playerManager.getPlayerWithSign(Sign.Type.X);
    }

    public void humanTurn(){
	currentPlayer = playerManager.getHuman();
    }
    
    public void computerTurn(){
	currentPlayer = playerManager.getComputer();
    }

    public Player getCurrentPlayer() {
	return currentPlayer;
    }
    
    public void nextPlayer(){
	currentPlayer.nextPlayer(this);
    }
    
    public boolean isComputerPlaying(){
	return currentPlayer == playerManager.getComputer();
    }
    
    public boolean isHumanPlaying(){
	return currentPlayer == playerManager.getHuman();
    }
}
