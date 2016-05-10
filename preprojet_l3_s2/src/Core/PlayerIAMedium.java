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
    public Coordonate play(Grid grid) {
        Random r = new Random();
        int compteur = 0;
        if ((grid.getStateAtCase(new Coordonate(0,1)) == State.EATEN) && grid.getStateAtCase(new Coordonate(1,0)) == State.EATEN)
        {
            //game over, the IA accepts its faith and commit honorable sudoku
            return(new Coordonate(0,0));
        }
        if ((grid.getStateAtCase(new Coordonate(0,1)) == State.EATEN))
        {
            //The IA wins
            return(new Coordonate(1,0));
        }
        if (grid.getStateAtCase(new Coordonate(1,0)) == State.EATEN)
        {
            //the IA wins
            return(new Coordonate(0,1));
        }
        
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        while(x > grid.getWidth() || y > grid.getHeight() || grid.getStateAtCase(new Coordonate(x,y)) == State.EATEN){
            x = r.nextInt(grid.getWidth());
            y = r.nextInt(grid.getHeight());
        }
        Coordonate c = new Coordonate( x,y);
        return c;
    }
    
    
    private boolean isLoosingMove(Coordonate c)
    {
        return((c.getX() == 0 && (c.getY()== 0 || c.getY() == 1)) || (c.getX() == 1 && c.getY() == 0));
    }
    
}
