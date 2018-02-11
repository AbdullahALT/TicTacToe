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
 * Ensures there is only two instances of object Sign 
 * @author abaaltamimi
 */
public class SignManager {
    
    private Sign signX;
    private Sign signO;

    public SignManager(String pathX, String pathO) {
	signX = new Sign(pathX, Sign.Type.X);
	signO = new Sign(pathO, Sign.Type.O);
    }

    public Sign getSignX() {
	return signX;
    }

    public Sign getSignO() {
	return signO;
    }

}
