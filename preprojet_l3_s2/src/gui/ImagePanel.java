package gui;

import Core.Grid;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage avail,eaten,poison;
    private int x,y;
    Grid grille;

    public ImagePanel() {
       try {                
          avail = ImageIO.read(new File("../img/available.png"));
          eaten = ImageIO.read(new File("../img/eaten.png"));
          poison = ImageIO.read(new File("../img/poison.png"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw images
        
        g.drawImage(avail, 0, 0, null); // see javadoc for more info on the parameters            
    }

}