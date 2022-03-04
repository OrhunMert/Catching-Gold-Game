/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldcatchgame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdus
 */
public class Square {
    private boolean haveGold; // have gold ? yes : no
    private boolean haveSecretGold; // secret gold ? yes : no 
    private List<Integer> location; // take location i as x, j as y
    private int goldValue;
    
    public int isSomeOne(int i,int j,GamerA A,GamerB B,GamerC C,GamerD D){
        if(i == A.getCurrentLocation().get(0) && j == A.getCurrentLocation().get(1)) return 1;
        if(i == B.getCurrentLocation().get(0) && j == B.getCurrentLocation().get(1)) return 2;
        if(i == C.getCurrentLocation().get(0) && j == C.getCurrentLocation().get(1)) return 3;
        if(i == D.getCurrentLocation().get(0) && j == D.getCurrentLocation().get(1)) return 4;
        return 0;
    }
    
    Square(List<Integer> location, int goldValue){
        location = new ArrayList<>();
        this.haveGold = false;
        this.haveSecretGold = false;
        this.location = location;   
        this.goldValue = goldValue;
    }

    public Square(boolean haveGold, boolean haveSecretGold, List<Integer> location,int goldValue) {
        location = new ArrayList<>();
        this.haveGold = haveGold;
        this.haveSecretGold = haveSecretGold;
        this.location = location;
        this.goldValue = goldValue;
    }

    public boolean isHaveGold() {
        return haveGold;
    }

    public void setHaveGold(boolean haveGold) {
        this.haveGold = haveGold;
    }

    public boolean ishaveSecretGold() {
        return haveSecretGold;
    }

    public void sethaveSecretGold(boolean haveSecretGold) {
        this.haveSecretGold = haveSecretGold;
    }

    public List<Integer> getLocation() {
        return location;
    }

    public void setLocation(List<Integer> location) {
        this.location = location;
    }

    public int getGoldValue() {
        return goldValue;
    }

    public void setGoldValue(int goldValue) {
        this.goldValue = goldValue;
    }
    
    
}
