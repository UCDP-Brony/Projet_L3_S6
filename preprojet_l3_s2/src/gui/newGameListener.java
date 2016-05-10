/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Alex
 */
public class newGameListener implements MouseListener{
    GUI gameWindow;
    Newgame options;
    
    public newGameListener(GUI gameFrame,Newgame opt){
        this.gameWindow=gameFrame;
        this.options=opt;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        gameWindow.getImagePanel1().setGrid(Integer.parseInt(options.getjTextField1().getText()), Integer.parseInt(options.getjTextField2().getText()));
        gameWindow.setVisible(true);
        options.setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }
    
}
