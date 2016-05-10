package Core;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheDoctor
 */
class RealLifePlayer implements Player{

    @Override
    public Coordonate play(Grid grid) {        
        Scanner sc = new Scanner(System.in);
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        while(x >= grid.getWidth() || y >= grid.getHeight() || grid.getStateAtCase(new Coordonate(x,y)) == State.EATEN){
            System.out.println("\nEntrez une abscisse : \n");
            while(!sc.hasNextInt()) {
                sc.next();
            }
            x = sc.nextInt();
            System.out.println("\nEntrez une ordonnée : \n");
            while(!sc.hasNextInt()) {
                sc.next();
            }
            y = sc.nextInt();
        }
        return new Coordonate(x,y);
    }
    
}
