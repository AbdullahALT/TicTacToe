/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Player;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import models.Position;

/**
 *
 * @author abaaltamimi
 */
public class Board {
    
    private Cell[][] cells;
    private int maxRow;
    private int maxColum;

    public Board(int maxRow, int maxColumn) {
        this.maxColum = maxColumn;
	this.maxRow = maxRow;
	cells = new Cell[maxRow][maxColumn];
    }
    
    public void initCell(int row, int column, JButton button){
        cells[row][column] = new Cell(button);
    }
    
    public void acquire(int row, int column, Player owner){
        cells[row][column].setOwner(owner);
    }

    public Cell[][] getCells() {
        return cells;
    }
    
    public Cell getCellOf(JButton button){
        for(Cell cellRow[] : cells){
            for(Cell cell : cellRow){
                if(cell.getButton() == button){
                    return cell;
                }
            }
        }
        return null;
    }
    
    public Cell getCellOf(Position position){
        return cells[position.getRow()][position.getColumn()];
    }
    
    public List<Position> getEmptyPosition() {
	
	List<Position> positions = new ArrayList<>();
	
	for(int row = 0; row < maxRow; row++){
	    for(int colum = 0; colum < maxColum; colum++){
		if(cells[row][colum].getOwner() == null)
		    positions.add(new Position(row, colum));
    	    }	
	}
	
	return positions;
    }
    
    public void acquire(Class<?> Class, Cell cell, Player currentPlayer){
        if(cell.setOwnerIfEmpty(currentPlayer))
            cell.getButton().setIcon(new ImageIcon(Class.getResource(currentPlayer.getSign().getPath())));
    }
    
    public Player checkWin(){        
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
    
    private boolean checkLine(Cell... cells){
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
    
    public boolean isTie(){
	return getEmptyPosition().size() == 0;
    }
    
    public boolean isFirstTurn(){
	return getEmptyPosition().size() == 9;
    }
}
