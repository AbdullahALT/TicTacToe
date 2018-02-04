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

/**
 *
 * @author abaaltamimi
 */
public class CustomButton extends JButton  {

    int column;
    int row;
    Player owner;

    @Override
    public void setIcon(Icon defaultIcon) {
        
        if(owner != null)
            return;
        
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
}
