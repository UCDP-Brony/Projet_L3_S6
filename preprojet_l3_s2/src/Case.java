/*
 * Case, une case de la grille
 */

/**
 *
 * @author Seawolf
 */
public class Case {
    State state;
    
    public Case(State s){
        this.state = s;
    }
    
    public State getState(){
            return this.state;
    }
    
    public void setState(State s){
        this.state = s;
    }
}

