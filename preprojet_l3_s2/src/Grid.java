/*
 * La grille des joueurs
 */

/**
 *
 * @author Seawolf
 */
public class Grid {
    Case[][] grid;
    
    public Grid(){
        this(6,4);
    }
    
    public Grid(int x, int y){
        this.grid = new Case[x][y];
    }
    
}
