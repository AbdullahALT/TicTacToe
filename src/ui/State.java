/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author abaaltamimi
 */
public class State {
    Player player;
    Board board;

    public State(Board board, Player player) {
        this.player = player;
        this.board = board;
    }
    
    public void acquire(Class<?> c, Cell cell){
        if(cell.setOwner(player)){
            System.out.println(player.path);
            System.out.println(c.getResource(player.path));
            cell.getButton().setIcon(new ImageIcon(c.getResource(player.path)));
            
            switchTurns();
        }
    }

    private void switchTurns() {
        this.player = player.opposite();
    }
    
    public String label(){
        return player.opposite().label;
    }
    
    public Player checkWin(){
        Cell[][] cells = board.getCells();
        
        if(checkLine(cells[0][0], cells[0][1], cells[0][2]))
            return cells[0][0].getOwner();
        
        if(checkLine(cells[1][0], cells[1][1], cells[1][2]))
            return cells[1][0].getOwner();
        
        if(checkLine(cells[2][0], cells[2][1], cells[2][2]))
            return cells[2][0].getOwner();
       
        if(checkLine(cells[0][0], cells[1][0], cells[2][0]))
            return cells[0][0].getOwner();
        
        if(checkLine(cells[0][1], cells[1][1], cells[2][1]))
            return cells[0][1].getOwner();
        
        if(checkLine(cells[0][2], cells[1][2], cells[2][2]))
            return cells[0][2].getOwner();
        
        if(checkLine(cells[0][0], cells[1][1], cells[2][2]))
            return cells[0][0].getOwner();
        
        if(checkLine(cells[0][2], cells[1][1], cells[2][0]))
            return cells[0][2].getOwner();
        
        return null;
    }
    
    public boolean checkLine(Cell... cells){
        Player owner = cells[0].getOwner();
        if(owner == null)
            return false;
        
        boolean flag = true;
        for(Cell cell : cells){
            if(cell.getOwner() == null || cell.getOwner() != owner)
                flag = false;
        }

        return flag;
    }
    
    
}
