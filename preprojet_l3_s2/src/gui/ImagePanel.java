package gui;

import Core.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ImagePanel extends JComponent {

    private BufferedImage avail, eaten, poison;
    Grid grille;

    public ImagePanel() {
        try {
            
            avail = ImageIO.read(new File("./src/img/available.png"));
            eaten = ImageIO.read(new File("./src/img/eaten.png"));
            poison = ImageIO.read(new File("./src/img/poison.png"));

            System.out.println("pouet");

        } catch (IOException ex) {
            //handle exception...
            System.out.println(ex);
        }

            this.grille = new Grid(2,2);
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println(this);
        System.out.println(this.getWidth() + " / " + this.getHeight());
        Graphics2D drawer = (Graphics2D) g;
        drawer.setPaint(Color.red);
        drawer.fillRect(0, 0, this.getWidth(), this.getHeight());

        //draw images
        this.setSize(grille.getWidth() * 100, grille.getHeight() * 100);
        for (int i = 0; i < grille.getWidth(); i++) {
            for (int j = 0; j < grille.getHeight(); j++) {
                super.paintComponent(g);
                if (grille.getStateAtCase(new Coordonate(i, j)) == State.WAFFLE) {
                    g.drawImage(avail, i*100, j*100, 100, 100, null);
                }
                if (grille.getStateAtCase(new Coordonate(i, j)) == State.EATEN) {
                    g.drawImage(eaten, i*100, j*100, 100, 100, null);
                }
                if (grille.getStateAtCase(new Coordonate(i, j)) == State.POISON) {
                    g.drawImage(poison, i*100, j*100, 100, 100, null);
                }
            }
        }

    }
    
    public void setGrid(int x, int y){
        Grid grill=new Grid(x,y);
        this.grille=grill;
        this.repaint();
    }
}
