/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;

/**
 *
 * @author Seawolf
 */
public class PlayerIAHard implements Player{
    
    @Override
    public Coordinate play(Grid grid) {
        int[][] tab = new int[grid.getWidth()][grid.getHeight()];
        ArrayList<Coordinate> list = new ArrayList<Coordinate>();
        for(int i=0; i<grid.getWidth(); i++) {
            for(int j=0; j<grid.getHeight(); j++)
            {
                //TODO
            }
        }
        return new Coordinate(0,0);
    }
    
    
    private int winChances(Coordinate c, Grid grid, int profondeur)
    {
        if (isWinningMove(c,grid))
        {
            return 1;
        }
        if (isLoosingMove(c))
        {
            return -1;   
        }
        if (profondeur == 0)
        {
            return 0;
        }
        else
        {
            //TODO : copie grille
            return 0;
        }
    }
    
    
    
     //retourne faux si on envoie 0,0 0,1 ou 1,0
    private boolean isLoosingMove(Coordinate c)
    {
        return((c.getX() == 0 && (c.getY()== 0 || c.getY() == 1)) || (c.getX() == 1 && c.getY() == 0));
    }
    
    private boolean isWinningMove(Coordinate c, Grid grid)
    {
        return(((c.getX() == 1 && c.getY() == 0) && (grid.getStateAtCase(new Coordinate(0,1)) == State.EATEN)) ||
                ((c.getX() == 0 && c.getY() == 1) && (grid.getStateAtCase(new Coordinate(1,0)) == State.EATEN)));
    }
    
    
    
    
}
