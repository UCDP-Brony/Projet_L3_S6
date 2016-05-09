package Core;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private RealLifePlayer[] players;
    private Stack<String> cancelList;
    private Stack<String> redoList;
    
    public WaffleGame(int x, int y, RealLifePlayer[] p){
        this.grid = new Grid(x,y);
        this.players = p;
        this.cancelList = new Stack<>();
        this.redoList = new Stack<>();
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
    public void save(String filePath) {
        String toSave = "";
        toSave += this.cancelList.size()+"\n";
        toSave += this.redoList.size()+"\n";
        for(int i = 0; i < this.cancelList.size(); i++){
            toSave += this.cancelList.get(i)+"\n";
        }
        for(int i = 0; i < this.redoList.size(); i++){
            toSave += this.redoList.get(i)+"\n";
        }
        toSave += this.grid.toString();
        
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"))) {
            writer.write(toSave);
        } catch (IOException ex) {
            Logger.getLogger(WaffleGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void load(String filePath) {
        Scanner sc = new Scanner(filePath);
        this.cancelList.clear();
        this.redoList.clear();
        int clSize = Integer.parseInt(sc.nextLine());
        int rdSize = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < clSize; i++){
            this.cancelList.add(sc.nextLine());
        }
        for (int i = 0; i < rdSize; i++){
            this.redoList.add(sc.nextLine());
        }
        this.grid.load(sc.nextLine());
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
        Coordonate c = this.players[idNextPlayer].play(this.grid);
        System.out.println("Player "+(idNextPlayer+1)+" chosed "+c.getX()+", "+c.getY()+".");        
        this.eatWaffle(c);
        this.cancelList.add(this.grid.toString());
        this.redoList.clear();
        this.grid.afficher();
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
