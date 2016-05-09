package Core;

import java.util.Scanner;

/*
 * La grille des joueurs
 */
/**
 *
 * @author Seawolf
 */
public class Grid {

    private Case[][] grid;
    private int width;
    private int height;

    public Grid() {
        this(6, 4);
    }

    public Grid(int x, int y) {
        this.grid = new Case[x][y];
        this.width = x;
        this.height = y;
        fillGrid();
    }

    private void fillGrid() {
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                setStateAtCase(new Coordonate(i, j), State.WAFFLE);
            }
        }
        setStateAtCase(new Coordonate(0, 0), State.POISON);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public State getStateAtCase(Coordonate c) {
        return grid[c.getX()][c.getY()].getState();
    }

    public void setStateAtCase(Coordonate c, State s) {
        grid[c.getX()][c.getY()].setState(s);
    }

    @Override
    public String toString() {
        String resultat = getWidth() + " " + getHeight();
        for (int i = 0; i < getHeight(); i++) {
            resultat += " ";
            for (int j = 0; j < getWidth(); j++) {
                switch (grid[i][j].getState()) {
                    case WAFFLE:
                        resultat += "0";
                        break;
                    case EATEN:
                        resultat += "1";
                        break;
                    case POISON:
                        resultat += "X";
                        break;
                    default:
                        resultat += "?";
                }
            }
        }
        return resultat;
    }

    void load(String textGrid) {
        Scanner s = new Scanner(textGrid);
        setWidth(s.nextInt());
        setHeight(s.nextInt());
        this.grid = new Case[getWidth()][getHeight()];
        for (int i = 0; i < getHeight(); i++) {
            String ligne;
            ligne = s.next();
            for (int j = 0; j < getWidth(); j++) {
                switch (ligne.charAt(j)) {
                    case '0':
                        grid[i][j].setState(State.WAFFLE);
                        break;
                    case '1':
                        grid[i][j].setState(State.EATEN);
                        break;
                    case 'X':
                        grid[i][j].setState(State.POISON);
                        break;
                    default:
                        grid[i][j].setState(State.WAFFLE);
                }
            }
        }
    }
    
    public void afficher() {
        String resultat= "";
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                switch (grid[i][j].getState()) {
                    case WAFFLE:
                        resultat += "0";
                        break;
                    case EATEN:
                        resultat += "1";
                        break;
                    case POISON:
                        resultat += "X";
                        break;
                    default:
                        resultat += "?";
                }
            }
            
            resultat += "\n";
        }
        System.out.println(resultat);
    }
    

}
