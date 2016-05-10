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
 * @author ducruyy
 */
public class ImagePanelListener implements MouseListener {

    ImagePanel panel;

    public ImagePanelListener(ImagePanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("listen imagepanel en " + e.getX() + "," + e.getY());
        int x = e.getX()/100;
        int y = e.getY()/100;
        
        System.out.println("case " + x + "," + y);

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
