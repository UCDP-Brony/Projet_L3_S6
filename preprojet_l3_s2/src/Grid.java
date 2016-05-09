/*
 * La grille des joueurs
 */

/**
 *
 * @author Seawolf
 */
public class Grid {
    Case[][] grid;
    final int width;
    final int height;
    
    public Grid(){
        this(6,4);
    }
    
    public Grid(int x, int y){
        this.grid = new Case[x][y];
        this.width = x;
        this.height = y;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    
    
}
