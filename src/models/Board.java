/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ai.Heuristic;
import ai.IHeuristic;
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
public class Board implements Observable{
    
    private List<Observer> observers;
    private Cell[][] cells;
    private IHeuristic heuristic;

    public Board() {
	this.cells = new Cell[3][3];
	this.observers = new ArrayList<>();
	initCells();
    }
    
    //For testing 
    public Board(Cell[][] cells){
	this.cells = cells;
    }
    
    @Override
    public void register(Observer observer){
	this.observers.add(observer);
    }
    
    @Override
    public void notify(Position position, Sign sign){
	observers.forEach(observer -> observer.update(position, sign));
    }
    
    public final void initCells(){
	for(int row = 0; row < 3; row++)
	    for(int column = 0; column < 3; column++)
		this.cells[row][column] = new Cell();
    }
    
    public void acquire(Position position, Player owner){
        this.cells[position.getRow()][position.getColumn()].setOwnerIfEmpty(owner);
	notify(position, owner.getSign());
    }

//    public Cell[][] getCells() {
//        return cells;
//    }
//    
    public Cell getCellAt(Position position){
        return cells[position.getRow()][position.getColumn()];
    }
    
    public List<Position> getEmptyPosition() {
	
	List<Position> positions = new ArrayList<>();
	
	for(int row = 0; row < 3; row++){
	    for(int colum = 0; colum < 3; colum++){
		if(cells[row][colum].getOwner() == null)
		    positions.add(new Position(row, colum));
    	    }	
	}
	
	return positions;
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
	return getEmptyPosition().isEmpty();
    }
    
    public boolean isFirstTurn(){
	return getEmptyPosition().size() == 9;
    }
    
    public int evaluate(Player player){
	return heuristic.evaluate(cells, player);
    }
    
    public void setHeuristic(IHeuristic heuristic){
	this.heuristic = heuristic;
    }

    @Override
    public String toString() {
	String cell00 = (cells[0][0].getOwner() == null)? " " : cells[0][0].getOwner().getSign().getType().toString();
	String cell01 = (cells[0][1].getOwner() == null)? " " : cells[0][1].getOwner().getSign().getType().toString();
	String cell02 = (cells[0][2].getOwner() == null)? " " : cells[0][2].getOwner().getSign().getType().toString();
	
	String cell10 = (cells[1][0].getOwner() == null)? " " : cells[1][0].getOwner().getSign().getType().toString();
	String cell11 = (cells[1][1].getOwner() == null)? " " : cells[1][1].getOwner().getSign().getType().toString();
	String cell12 = (cells[1][2].getOwner() == null)? " " : cells[1][2].getOwner().getSign().getType().toString();
	
	String cell20 = (cells[2][0].getOwner() == null)? " " : cells[2][0].getOwner().getSign().getType().toString();
	String cell21 = (cells[2][1].getOwner() == null)? " " : cells[2][1].getOwner().getSign().getType().toString();
	String cell22 = (cells[2][2].getOwner() == null)? " " : cells[2][2].getOwner().getSign().getType().toString();
	
	
	
	return    cell00 + " | " + cell01 + " | " + cell02 + "\n"
		+ "---------" + "\n"
		+ cell10 + " | " + cell11 + " | " + cell12 + "\n"
		+ "---------" + "\n"
		+ cell20 + " | " + cell21 + " | " + cell22 + "\n";
    }
    
    
}
