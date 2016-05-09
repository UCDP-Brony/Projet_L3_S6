package Core;

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
    
    public State getStateAtCase(Coordonate c){
        return grid[c.getX()][c.getY()].getState();
    }
    
    public void setStateAtCase(Coordonate c, State s){
        grid[c.getX()][c.getY()].setState(s);
    }
    
    @Override
    public String toString(){
        return("0");
    }
    void load(String textGrid){
        
    }
    
}
