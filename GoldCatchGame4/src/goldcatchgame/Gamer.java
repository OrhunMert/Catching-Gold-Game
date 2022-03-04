/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldcatchgame;

import graphics.GameBoard;
import java.util.List;

/**
 *
 * @author abdus
 */
public abstract class Gamer {
    private List<Integer> CurrentLocation; // set current location i as x, j as y
    private List<List<Integer>> path; // set all location so we have the path // set all current Location
    private int numOfStep; // it's mean how much step can a gamer go in a round
    private List<Integer> tourBasedBalance;
    
    abstract List<Integer> findTarget(GameArena arena); // find target for all gamer with their style;
    abstract List<Integer> move(GameArena a,GameBoard gb,GamerA A,GamerB B,GamerC C,GamerD D); // where will be gamer in end of tour;
    

    public List<Integer> getCurrentLocation() {
        return CurrentLocation;
    }

    public void setCurrentLocation(List<Integer> CurrentLocation) {
        this.CurrentLocation = CurrentLocation;
    }

    public List<List<Integer>> getPath() {
        return path;
    }

    public void setPath(List<List<Integer>> path) {
        this.path = path;
    }

    public int getNumOfStep() {
        return numOfStep;
    }

    public void setNumOfStep(int numOfStep) {
        this.numOfStep = numOfStep;
    }

    public List<Integer> getTourBasedBalance() {
        return tourBasedBalance;
    }

    public void setTourBasedBalance(List<Integer> tourBasedBalance) {
        this.tourBasedBalance = tourBasedBalance;
    }
    
    
}
