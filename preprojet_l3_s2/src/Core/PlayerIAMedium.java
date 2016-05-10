/*
 * IA difficulté moyenne, joue les coups gagnants quand disponibles et évite les coups perdants si possible
 */
package Core;

import java.util.Random;

/**
 *
 * @author Seawolf
 */
public class PlayerIAMedium implements Player{

    @Override
    public Coordinate play(Grid grid) {
        Random r = new Random();
        int compteur = 0;
        if ((grid.getStateAtCase(new Coordinate(0,1)) == State.EATEN) && grid.getStateAtCase(new Coordinate(1,0)) == State.EATEN)
        {
            //game over, the IA accepts its faith and commit honorable sudoku
            return(new Coordinate(0,0));
        }
        if ((grid.getStateAtCase(new Coordinate(0,1)) == State.EATEN))
        {
            //The IA wins
            return(new Coordinate(1,0));
        }
        if (grid.getStateAtCase(new Coordinate(1,0)) == State.EATEN)
        {
            //the IA wins
            return(new Coordinate(0,1));
        }
        
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        while( (compteur<25 || isLoosingMove(new Coordinate(x,y))) || x > grid.getWidth() || y > grid.getHeight() || grid.getStateAtCase(new Coordinate(x,y)) == State.EATEN){
            x = r.nextInt(grid.getWidth());
            y = r.nextInt(grid.getHeight());
            compteur++;
        }
        Coordinate c = new Coordinate( x,y);
        return c;
    }
    
    //retourne faux si on envoie 0,0 0,1 ou 1,0
    private boolean isLoosingMove(Coordinate c)
    {
        return((c.getX() == 0 && (c.getY()== 0 || c.getY() == 1)) || (c.getX() == 1 && c.getY() == 0));
    }
    
}
