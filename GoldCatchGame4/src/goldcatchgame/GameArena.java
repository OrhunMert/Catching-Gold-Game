/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldcatchgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author abdus
 */
public class GameArena {

    private Square arena[][];
    private double sideLength;
    private int perGold, perSecretGold, row, col;
    private int totalGold,numOfSecretGold,numOfGold;
    Random rand = new Random();

    GameArena(int row, int col, int perGold, int perSecretGold) { // dışarıda kare sayısı ve kenar uzunluğunu hesapla
        arena = new Square[row][col];
        this.perGold = perGold;
        this.perSecretGold = perSecretGold;
        this.row = row;
        this.col = col;
        //setupArena();
    }

    public void setupArena() {
        int totalGold = ((row * col) * perGold) / 100;
        int numOfSecretGold = ((totalGold * perSecretGold) / 100);
        int numOfGold = totalGold - numOfSecretGold;
        this.settotalGold(totalGold);
        this.setnumOfGold(numOfGold);
        this.setnumOfSecretGold(numOfSecretGold);
        int goldCount = 0, secretGoldCount = 0;
        int randCol, randRow;
        List<Integer> location = new ArrayList<Integer>();
        int value[] = new int[4];
        value[0] = 5;value[1]=10;value[2]=15;value[3]=20;
        int choose;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                location.add(i);
                location.add(j);
                arena[i][j] = new Square(location,0);
            }
        }
        while((goldCount+secretGoldCount) != totalGold){
            choose = rand.nextInt(4);
            randRow = rand.nextInt(row);
            randCol = rand.nextInt(col);
            location.add(randRow);
            location.add(randCol);
            if(randRow == 0 && randCol==0 || randRow ==0 && randCol ==col-1 || randRow ==row-1 && randCol ==0 || randRow ==row-1 && randCol ==col-1){
                //ALL beginning location don't have gold or secret gold
            }
            else{
                if (goldCount != numOfGold && !arena[randRow][randCol].isHaveGold()) {
                    arena[randRow][randCol] = new Square(true, false, location,value[choose]);
                    goldCount++;
                } else if (secretGoldCount != numOfSecretGold && !arena[randRow][randCol].ishaveSecretGold()) { // secret gold define error ?? 
                    arena[randRow][randCol] = new Square(true, true, location,value[choose]);
                    secretGoldCount++;
                }
            }
            
        }

    }

    public Square[][] getArena() {
        return arena;
    }

    public void setArena(Square[][] arena) {
        this.arena = arena;
    }

    public int getPerGold() {
        return perGold;
    }

    public void setPerGold(int perGold) {
        this.perGold = perGold;
    }

    public int getPerSecretGold() {
        return perSecretGold;
    }

    public void setPerSecretGold(int perSecretGold) {
        this.perSecretGold = perSecretGold;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    //
    public int gettotalGold() {
        return totalGold;
    }

    public void settotalGold(int totalGold) {
        this.totalGold = totalGold;
    }
    public int getnumOfSecretGold() {
        return numOfSecretGold;
    }

    public void setnumOfSecretGold(int numOfSecretGold) {
        this.numOfSecretGold = numOfSecretGold;
    }
    public int getnumOfGold() {
        return numOfGold;
    }

    public void setnumOfGold(int numOfGold) {
        this.numOfGold = numOfGold;
    }
}
