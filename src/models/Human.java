/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ui.State;

/**
 *
 * @author abaaltamimi
 */
public class Human extends Player {

    public Human(Sign sign) {
	super(sign);
    }
    
    @Override
    public void nextPlayer(State state) {
	state.computerTurn();
    }
    
}
