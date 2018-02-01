/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

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
    
    
    public static class Position {
	int row;
	int column;

	public Position(int row, int column) {
	    this.row = row;
	    this.column = column;
	}

	public int getRow() {
	    return row;
	}

	public int getColumn() {
	    return column;
	}
	
    }
}
