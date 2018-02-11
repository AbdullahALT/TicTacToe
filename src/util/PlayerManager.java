/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import models.Computer;
import models.Human;
import models.Player;
import models.Sign;

/**
 *
 * @author abaaltamimi
 */
public class PlayerManager {
    private Player human;
    private Player computer;
    private SignManager signManager;

    public PlayerManager(SignManager signManager) {
	this.signManager = signManager;
	this.human = new Human(signManager.getSignX());
	this.computer = new Computer(signManager.getSignO());
    }
    
    public void switchSign(){
	Sign sign = human.getSign();
	human.setSign(computer.getSign());
	computer.setSign(sign);
    }
    
    public Player getPlayerWithSign(Sign.Type type){
	return (human.getSign().getType() == type)? human : computer;
    }

    public Player getHuman() {
	return human;
    }

    public Player getComputer() {
	return computer;
    }
    
    
}
