/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ai.AIAlgorithm;
import ui.State;

/**
 *
 * @author abaaltamimi
 */
public abstract class Player {
//    Human("/resources/o.png", "X Turn"), 
//    Computer("/resources/x.png", "O Turn");

    private Sign sign;
    private AIAlgorithm algorithm;
    
    Player() {
    }
    
    Player(Sign sign) {
        this.sign = sign;
    }

    public Sign getSign() {
        return sign;
    }
    
    public void setAiAlgorithm(AIAlgorithm algorithm){
	this.algorithm = algorithm;
    }
    
    public abstract void nextPlayer(State state);
    
    public Position getAiMove(){
	return algorithm.move();
    }

    public void setSign(Sign sign) {
	this.sign = sign;
    }
    
    
}
