/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author abaaltamimi
 */
public enum Player {
    Human("/resources/o.png", "X Turn"), 
    Computer("/resources/x.png", "O Turn");

    String path;
    String label;
    
    Player(String path, String label) {
        this.path = path;
        this.label = label;
    }

    public String getPath() {
        return path;
    }
    
    public Player opposite(){
        if(this == Human)
            return Computer;
        return Human;
    }
}
