/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JButton;

/**
 *
 * @author abaaltamimi
 */
public class Cell {
    Player owner;
    JButton button;

    public Cell(JButton button) {
        this.button = button;
        this.owner = null;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean setOwner(Player owner) {
        if(this.owner != null)
            return false;
        
        this.owner = owner;
        return true;
    }

    public JButton getButton() {
        return button;
    }
    
    
    
    
}
