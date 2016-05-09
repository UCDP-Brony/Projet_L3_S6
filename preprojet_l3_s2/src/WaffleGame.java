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
    
    public WaffleGame(int x, int y, Player[] p){
        this.grid = new Grid(x,y);
        this.players = p;
    }
    
    @Override
    public void cancel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Coordonate c = players[idNextPlayer].play();
        System.out.println("Player "+(idNextPlayer+1)+" chosed "+c.getX()+", "+c.getY()+".");        
        this.eatWaffle(c);
        return this.winCheck();
    }
    
    private void eatWaffle(Coordonate c){
        for(int i = c.getX(); i < grid.getWidth(); i++){
            for(int j = c.getY(); j < grid.getHeight(); j++){
                grid.setStateAtCase(new Coordonate(i,j),State.EATEN);
            }                
        }
    }
    
    private boolean winCheck(){
        return(grid.getStateAtCase(new Coordonate(0,1)) == State.EATEN && grid.getStateAtCase(new Coordonate(1,0)) == State.EATEN); // TODO
    }
    
}