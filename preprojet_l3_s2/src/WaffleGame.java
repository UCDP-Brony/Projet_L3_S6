
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheDoctor
 */
public class WaffleGame implements Game{

    private Grid grid;
    private Player[] players;
    private Stack<String> cancelList;
    private Stack<String> redoList;
    
    public WaffleGame(int x, int y, Player[] p){
        this.grid = new Grid(x,y);
        this.players = p;
    }
    
    @Override
    public void cancel() {
        String temp = this.cancelList.pop();
        this.grid.load(this.cancelList.peek());
        this.redoList.add(temp);
    }

    @Override
    public void redo() {
        String temp = this.redoList.pop();
        this.grid.load(this.redoList.peek());
        this.cancelList.add(temp);
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void play() {
        boolean finished = false;
        int idNextPlayer = 1;
        while(!finished){            
            idNextPlayer = (idNextPlayer+1)%2;
            finished = this.playATurn(idNextPlayer);
        }
    }
    
    private boolean playATurn(int idNextPlayer){
        System.out.println("Player "+(idNextPlayer+1)+" is playing.");
        Coordonate c = this.players[idNextPlayer].play();
        System.out.println("Player "+(idNextPlayer+1)+" chosed "+c.getX()+", "+c.getY()+".");        
        this.eatWaffle(c);
        this.cancelList.add(this.grid.toString());
        return this.winCheck();
    }
    
    private void eatWaffle(Coordonate c){
        for(int i = c.getX(); i < this.grid.getWidth(); i++){
            for(int j = c.getY(); j < this.grid.getHeight(); j++){
                this.grid.setStateAtCase(new Coordonate(i,j),State.EATEN);
            }                
        }
    }
    
    private boolean winCheck(){
        return(this.grid.getStateAtCase(new Coordonate(0,1)) == State.EATEN && this.grid.getStateAtCase(new Coordonate(1,0)) == State.EATEN); // TODO
    }
    
}
