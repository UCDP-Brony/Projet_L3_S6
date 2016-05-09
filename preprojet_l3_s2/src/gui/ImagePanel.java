package gui;

import Core.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage avail, eaten, poison;
    private int x, y;
    Grid grille;

    public ImagePanel() {
        try {
            avail = ImageIO.read(new File("../img/available.png"));
            eaten = ImageIO.read(new File("../img/eaten.png"));
            poison = ImageIO.read(new File("../img/poison.png"));
        } catch (IOException ex) {
            // handle exception...
        }
        
        grille = new Grid(2,2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw images
        for (int i = 0; i < grille.getWidth(); i++) {
            for (int j = 0; j < grille.getHeight(); j++) {
                if (grille.getStateAtCase(new Coordonate(i, j)) == State.WAFFLE) {
                    g.drawImage(avail, i * 100, j * 100, null);
                }
                if (grille.getStateAtCase(new Coordonate(i, j)) == State.EATEN) {
                    g.drawImage(eaten, i * 100, j * 100, null);
                }
                if (grille.getStateAtCase(new Coordonate(i, j)) == State.POISON) {
                    g.drawImage(poison, i * 100, j * 100, null);
                }
            }
        }
    }
}
