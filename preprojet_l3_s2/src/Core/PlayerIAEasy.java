/*
 * Joue des coups au hasard
 */
package Core;

import java.util.Random;

/**
 *
 * @author Seawolf
 */
public class PlayerIAEasy implements Player{

    @Override
    public Coordinate play(Grid grid) {
        Random r = new Random();
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        while(x > grid.getWidth() || y > grid.getHeight() || grid.getStateAtCase(new Coordinate(x,y)) == State.EATEN){
            x = r.nextInt(grid.getWidth());
            y = r.nextInt(grid.getHeight());
        }
        Coordinate c = new Coordinate( x,y);
        return c;
    }
    
}
