/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import models.Player;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import models.Observer;
import models.Position;
import models.Sign;

/**
 *
 * @author abaaltamimi
 */
public class CustomButton extends JButton implements Observer {

    private int column;
    private int row;
    private onUpdateListener onUpdateListener;
    
    public interface onUpdateListener {
	void onUpdate(JButton button, Sign sign);
    }
    

    @Override
    public void setIcon(Icon defaultIcon) {
        
        try{
            ImageIcon icon = (ImageIcon) defaultIcon;
            Image img = icon.getImage() ;  
            Image newimg = img.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
            icon = new ImageIcon( newimg );

            super.setIcon(icon); //To change body of generated methods, choose Tools | Templates.
            
        } catch (ClassCastException | NullPointerException e){
            super.setIcon(defaultIcon);
        }
    }

    @Override
    public void update(Position position, Sign sign) {
	if(row == position.getRow() && column == position.getColumn())
	    onUpdateListener.onUpdate(this, sign);
    }
    
    public void setOnPositionUpdateListener(int row, int column, onUpdateListener onUpdateListener){
	this.row = row;
	this.column = column;
	this.onUpdateListener = onUpdateListener;
    } 
    
    public Position getPosition(){
	return new Position(row, column);
    }
}
