/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import models.Board;
import ai.MinmaxAlgorithm;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import models.Player;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import models.Position;
import models.Sign;
import util.PlayerManager;
import util.SignManager;

/**
 *
 * @author abaaltamimi
 */
public class Main extends javax.swing.JFrame {

    private State state;
    private  Board board;
    private boolean gameOver;
    PlayerManager playerManager;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
	
	humanSignChoice.add("Play as X");
	humanSignChoice.add("Play as O");
	
	playerManager = new PlayerManager(new SignManager("/resources/x.png", "/resources/o.png"));
        setGame();
	
	
	humanSignChoice.addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		changeSign();
	    }
	});
    }
    
    public void setGame(){
	board = new Board(3, 3);
	cell_00.setIcon(null);
	cell_01.setIcon(null);
	cell_02.setIcon(null);
	cell_10.setIcon(null);
	cell_11.setIcon(null);
	cell_12.setIcon(null);
	cell_20.setIcon(null);
	cell_21.setIcon(null);
	cell_22.setIcon(null);
	
        board.initCell(0, 0, cell_00);
        board.initCell(0, 1, cell_01);
        board.initCell(0, 2, cell_02);
        board.initCell(1, 0, cell_10);
        board.initCell(1, 1, cell_11);
        board.initCell(1, 2, cell_12);
        board.initCell(2, 0, cell_20);
        board.initCell(2, 1, cell_21);
        board.initCell(2, 2, cell_22);
	        
	state = new State(playerManager);
	gameOver = false;
	
	if(state.isComputerPlaying())
	    delayPlay();
	
        turnLabel.setText(state.getCurrentPlayer().getSign().getType() + " Turn");
	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cell_00 = new ui.CustomButton();
        cell_01 = new ui.CustomButton();
        cell_02 = new ui.CustomButton();
        cell_10 = new ui.CustomButton();
        cell_11 = new ui.CustomButton();
        cell_12 = new ui.CustomButton();
        cell_20 = new ui.CustomButton();
        cell_21 = new ui.CustomButton();
        cell_22 = new ui.CustomButton();
        jPanel3 = new javax.swing.JPanel();
        turnLabel = new javax.swing.JLabel();
        humanSignChoice = new java.awt.Choice();
        resetButton = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        cell_00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_00);

        cell_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_01);

        cell_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_02);

        cell_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_10);

        cell_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_11);

        cell_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_12);

        cell_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_20);

        cell_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_21);

        cell_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquire(evt);
            }
        });
        jPanel1.add(cell_22);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 410, 270));

        jPanel3.setLayout(new java.awt.BorderLayout());

        turnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turnLabel.setText("Turn Indicator");
        jPanel3.add(turnLabel, java.awt.BorderLayout.CENTER);

        humanSignChoice.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                changeSign(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        humanSignChoice.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                humanSignChoicePropertyChange(evt);
            }
        });
        jPanel3.add(humanSignChoice, java.awt.BorderLayout.PAGE_START);

        resetButton.setLabel("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel3.add(resetButton, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acquire(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acquire
        // TODO add your handling code here:
	if(gameOver || !state.isHumanPlaying())
	    return;
	System.out.println("Game isn't Over");
        CustomButton button = (CustomButton) evt.getSource();
        
	board.acquire(getClass(), board.getCellOf(button), state.getCurrentPlayer());
	
	System.out.println("end of acquire");
	setGameState();
	
	delayPlay();
	System.out.println("End delay player()");
    }//GEN-LAST:event_acquire

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
	setGame();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void changeSign(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_changeSign
        // TODO add your handling code here:
	
	
    }//GEN-LAST:event_changeSign

    private void humanSignChoicePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_humanSignChoicePropertyChange
        // TODO add your handling code here:
	changeSign();
    }//GEN-LAST:event_humanSignChoicePropertyChange
  
    
    private void changeSign(){
	playerManager.switchSign();
	setGame();
    }
    
    public void playComputer(){
	System.out.println("entered playComputer");
	if(gameOver)
	    return;
	
	state.getCurrentPlayer().setAiAlgorithm(new MinmaxAlgorithm(board, playerManager.getComputer(), playerManager.getHuman()));
	
	System.out.println("bofore ai move");
	Position move = state.getCurrentPlayer().getAiMove();
	
	board.acquire(getClass(), board.getCells()[move.getRow()][move.getColumn()], state.getCurrentPlayer());
	System.out.println("bofore set game state");
	setGameState();
    }
    
    public void delayPlay(){
	final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	
	executorService.schedule(new Runnable() {
	    @Override
	    public void run() {
		playComputer();
	    }
	}, 1, TimeUnit.SECONDS);
    }
    
    public void setGameState(){	
	if(board.checkWin() == null && !board.isTie()){
	    state.nextPlayer();
	    turnLabel.setText(state.getCurrentPlayer().getSign().getType() + " Turn"); 
	    return;
	}
	
	System.out.print("Game is over");
	
	gameOver = true;
	
	if(board.checkWin() != null)
            turnLabel.setText("The player: " + board.checkWin().getSign().getType() + " has won.");
        
	if(board.isTie())
	    turnLabel.setText("It's a tie!!");          
	
	
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.CustomButton cell_00;
    private ui.CustomButton cell_01;
    private ui.CustomButton cell_02;
    private ui.CustomButton cell_10;
    private ui.CustomButton cell_11;
    private ui.CustomButton cell_12;
    private ui.CustomButton cell_20;
    private ui.CustomButton cell_21;
    private ui.CustomButton cell_22;
    private java.awt.Choice humanSignChoice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Button resetButton;
    private javax.swing.JLabel turnLabel;
    // End of variables declaration//GEN-END:variables
}
