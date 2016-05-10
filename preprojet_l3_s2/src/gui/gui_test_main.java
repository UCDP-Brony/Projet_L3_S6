/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.SwingUtilities;

/**
 *
 * @author ducruyy
 */
public class gui_test_main implements Runnable{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new gui_test_main());
    }

    @Override
    public void run() {
        // Creation d'une fenetre
        GUI frame = new GUI();
        Newgame newgame = new Newgame();
        
        newgame.setVisible(true);
        newgame.getjButton1().addMouseListener(new newGameListener(frame,newgame));
        
        // Un clic sur le bouton de fermeture clos l'application
        frame.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);

        // On fixe la taille de la fenetre au minimum pour contenir tous les
        // composants
        frame.pack();
        frame.setVisible(false);
    }
    
}
