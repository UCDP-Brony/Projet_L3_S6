package Core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducruyy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Player[] t = new Player[2];
        //RealLifePlayer p1 = new RealLifePlayer();
        PlayerIAEasy p1 = new PlayerIAEasy();
        PlayerIAEasy p2 = new PlayerIAEasy();
        //RealLifePlayer p2 = new RealLifePlayer();
        t[0] = p1;
        t[1] = p2;
        Game g = new WaffleGame(6,6,t);
        g.play();
    }
    
}
