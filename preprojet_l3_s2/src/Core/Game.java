package Core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheDoctor
 */
public interface Game {
    public void cancel();
    public void redo();
    public void save();
    public void load();
    public void play();
}
