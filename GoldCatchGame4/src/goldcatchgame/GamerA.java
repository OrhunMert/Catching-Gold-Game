/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldcatchgame;

import graphics.GameBoard;
import graphics.SquareButtons;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author abdus
 */
public class GamerA extends Gamer {

    private List<Integer> target;
    private int balance; // gold number 
    private int endOfTourGold; // how much gold will decrease end of tour 
    private int endOfChooseTarget; // how much gold wil decrease after choose a target
    private int numOfStepToReachTarget; // how much step gamer can reach to target;
    private int numOfTourToReachTarget; // how much tour gamer can reach to tager;
    private int targetGoldValue;
    private int targetCost;
    private List<List<Integer>> tempPath;
    private List<Integer> tb = new ArrayList<>();

    @Override
    List<Integer> findTarget(GameArena arena) { // Gamer A will find shortest gold path every time
        Square s[][] = arena.getArena();
        int x1 = s.length, y1 = s[0].length; // max distance to A beginning location (m,n)
        int row = s.length;
        int col = s[0].length; // take arena row and col num
        int x2, y2;
        int targetY, targetX;
        targetX = targetY = 0;
        List<Integer> location = this.getCurrentLocation();
        int startXlocation = location.get(0);
        int startYlocation = location.get(1);
        int stepsNum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (s[i][j].ishaveSecretGold()) {
                    continue;
                } else if (s[i][j].isHaveGold()) {
                    x2 = Math.abs(startXlocation - i);//Burda distance'larin farklarini bulduk.
                    y2 = Math.abs(startYlocation - j);
                    if (x2 + y2 < x1 + y1) {//Adim sayilarini ve de uzakliklarini bulmus oluyoruz.
                        targetX = i;
                        targetY = j;
                        x1 = x2;
                        y1 = y2;
                        stepsNum =x2+y2;
                    }
                }
            }
        }

        System.out.println("\nPlayer Target Indexes:");
        System.out.println("Target X Index:" + targetX + " Target Y Index:" + targetY);
        System.out.println("Target's Gold Value:" + s[targetX][targetY].getGoldValue());
        System.out.println("For Player arrives Target's Gold needs number of steps:" + stepsNum);

        List<Integer> tarLocation = new ArrayList<>();
        tarLocation.add(targetX);
        tarLocation.add(targetY);
        targetGoldValue = s[targetX][targetY].getGoldValue();

        //update to gamer Data 
        this.target = tarLocation;
        this.numOfStepToReachTarget = stepsNum;
        this.numOfTourToReachTarget = this.numOfStepToReachTarget / this.getNumOfStep();
        this.balance = this.balance - this.endOfChooseTarget;

        targetCost = targetGoldValue - ((numOfTourToReachTarget * endOfTourGold) + endOfChooseTarget);
        return target;
    }

    @Override
    List<Integer> move(GameArena a,GameBoard gb,GamerA A,GamerB B,GamerC C,GamerD D) {
       //Bu metotta hareket ederken gittiği yerlerde altın var mı diye sorması lazım!!!
       int targetX = target.get(0);
       int targetY = target.get(1);
       int currentX = A.getCurrentLocation().get(0);
       int currentY = A.getCurrentLocation().get(1);
       int currentXB,currentYB,currentXC,currentYC,currentXD,currentYD;
       int startX=currentX,startY=currentY;
       currentXB=B.getCurrentLocation().get(0);
       currentYB=B.getCurrentLocation().get(1);
       currentXC=C.getCurrentLocation().get(0);
       currentYC=C.getCurrentLocation().get(1);
       currentXD=D.getCurrentLocation().get(0);
       currentYD=D.getCurrentLocation().get(1);
       List<Integer> l = new ArrayList<>();
       Square[][] b = a.getArena();
       //Burası sonradan yaptığım yerler
       SquareButtons [][] board;
       board=gb.getboard();
       int ContVariable=1;
       if (A.balance > A.endOfTourGold) {
           //Burada ilk konuma başlarken player'in olduğu yer grass icon olacak.
           //Buraya da gelebilir. 
       /*if((currentX!=currentXB || currentY!=currentYB) && (currentX!=currentXC || currentY!=currentYC) && (currentX!=currentXD || currentY!=currentYD))
       {
           ContVariable=1;
           board[currentX][currentY].setIcon(gb.getgrass());
       }*/
      // board[currentX][currentY].setIcon(gb.getgrass());
        //else board[startX][startY].setIcon(gb.getminerA());    
        int count = 0;
            while (count != A.getNumOfStep()) { // every tour will forward 3 step 
                if (currentX != targetX) { // everytime first forward on x
                    if (currentX < targetX) {
                        currentX++;
                       if( b[currentX][currentY].ishaveSecretGold()){
                           b[currentX][currentY].sethaveSecretGold(false);
                           b[targetX][targetY].setHaveGold(true);
                           //Burada normal altın icon donusturulecek
                           board[currentX][currentY].setIcon(gb.getgold());
                           a.setnumOfGold(a.getnumOfGold()+1);
                           a.setnumOfSecretGold(a.getnumOfSecretGold()-1);
                       }
                       if(b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2 ||
                           b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3 ||
                               b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4 ) currentX--;
                        //Buralara gizli altın var mı diye bakılmalı ve de gizli altın sayısı azaltılıp normal altın sayısı devam etmeli.Altın sayısında değişiklik olmayacak.
                    } else if (currentX > targetX) {
                        currentX--;
                        if( b[currentX][currentY].ishaveSecretGold()){
                           b[currentX][currentY].sethaveSecretGold(false);
                           b[targetX][targetY].setHaveGold(true);
                           //Burada normal altın icon donusturulecek
                           board[currentX][currentY].setIcon(gb.getgold());
                           a.setnumOfGold(a.getnumOfGold()+1);
                           a.setnumOfSecretGold(a.getnumOfSecretGold()-1);
                       }
                        if(b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2 ||
                           b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3 ||
                               b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4 ) currentX++;
                    }
                } else if (currentY != targetY) { // if currentx = targetx, it will forward on y
                    if (currentY < targetY) {
                        currentY++;
                        if( b[currentX][currentY].ishaveSecretGold()){
                           b[currentX][currentY].sethaveSecretGold(false);
                           b[targetX][targetY].setHaveGold(true);
                           //Burada normal altın icon donusturulecek                        
                           board[currentX][currentY].setIcon(gb.getgold());   
                           a.setnumOfGold(a.getnumOfGold()+1);
                           a.setnumOfSecretGold(a.getnumOfSecretGold()-1);
                       }
                        if(b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2 ||
                           b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3 ||
                               b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4 ) currentY--;
                    } else if (currentY > targetY) {
                        currentY--;
                        if( b[currentX][currentY].ishaveSecretGold()){
                           b[currentX][currentY].sethaveSecretGold(false);
                           b[targetX][targetY].setHaveGold(true);
                           //Burada normal altın icon donusturulecek                           
                           board[currentX][currentY].setIcon(gb.getgold());
                           a.setnumOfGold(a.getnumOfGold()+1);
                           a.setnumOfSecretGold(a.getnumOfSecretGold()-1);
                       }
                        if(b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2 ||
                           b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3 ||
                               b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4 ) currentY++;
                    }
                }
               //Hedef bulunmuş ise
                else{
                    System.out.println("Oyuncu hedefine ulaşmıştır.Şimdiki Konum Bilgileri:"+currentX+" "+currentY);
                    b[targetX][targetY].setHaveGold(false);
                    //Burda altın sayısı oyun alınındaki bir azaltılmalı.
                    a.settotalGold(a.gettotalGold()-1);
                    a.setnumOfGold(a.getnumOfGold()-1);
                    //Burada altın iconu yerine player iconu gelecek.Hangi class içinde ise ona göre olacak.
                    //Buraya belki koşul gelebilir ona bakıcam!!!
                    if((currentX!=currentXB || currentY!=currentYB) && (currentX!=currentXC || currentY!=currentYC) && (currentX!=currentXD || currentY!=currentYD)){
                      board[startX][startY].setIcon(gb.getgrass());
                      board[targetX][targetY].setIcon(gb.getminerA());
                    }
                    //Burda koşul olamayabilir belki
                    else board[startX][startY].setIcon(gb.getgrass());
                    b[targetX][targetY].setGoldValue(0);//Burası belki olamayabilir.
                    A.findTarget(a);// eğer bulduysa bu D için hemen yeni bir hedef belirlenmeli.
                    break;//Eşitse direk çıksın daha iyi performans olur.
                }
                count++;
            }
            //Burası bulamazsa diye oluşturulan yer.
            //Buraya Player iconu yerleştirilmeli grass iconu yerine
            if((currentX!=currentXB || currentY!=currentYB) && (currentX!=currentXC || currentY!=currentYC) && (currentX!=currentXD || currentY!=currentYD))
            {
                ContVariable=0;
                //Burası sonradan koydum starX'li hali.
                board[startX][startY].setIcon(gb.getgrass());
                board[currentX][currentY].setIcon(gb.getminerA());
            }
            else board[startX][startY].setIcon(gb.getgrass());//Ortadan kaldırmış olacak
            
            l.add(currentX);
            l.add(currentY);
            A.setCurrentLocation(l);
            tempPath.add(A.getCurrentLocation());
            A.setPath(tempPath);
            A.balance = A.balance - endOfTourGold;
            
        }
        else{
            A.balance=0;
            System.out.println("not enough balance to continue tour");
            JOptionPane.showMessageDialog(null,"A Oyuncusunun Altınları bitmiştir!!!","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
            board[currentX][currentY].setIcon(gb.getgrass());    
        }
       //if(ContVariable!=0) board[startX][startY].setIcon(gb.getminerA());//Eğerki gideceği yerde gamer varsa bekle ilk yerde kal sonra 6 adım veya 5 adım da direk hedefine git.
       
        tb.add(this.getBalance());
        this.setTourBasedBalance(tb);
        return A.getCurrentLocation();
    }

    public GamerA(int balance, int endOfTourGold, int endOfChooseTarget) {
        this.balance = balance;
        this.endOfTourGold = endOfTourGold;
        this.endOfChooseTarget = endOfChooseTarget;
        List<Integer> cLocation = new ArrayList<>();
        cLocation.add(0);
        cLocation.add(0);
        this.setCurrentLocation(cLocation); // beginning location for A == (0,0)
        this.setNumOfStep(3); // Gamer A can move 3 square in a tour
        tempPath = new ArrayList<>();
        tempPath.add(this.getCurrentLocation());
    } // set currentLocation and path when gamer defined
    // and set numberOfStep before define all gamer class

    public List<Integer> getTarget() {
        return target;
    }

    public void setTarget(List<Integer> target) {
        this.target = target;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getNumOfStepToReachTarget() {
        return numOfStepToReachTarget;
    }

    public void setNumOfStepToReachTarget(int numOfStepToReachTarget) {
        this.numOfStepToReachTarget = numOfStepToReachTarget;
    }

    public int getNumOfTourToReachTarget() {
        return numOfTourToReachTarget;
    }

    public void setNumOfTourToReachTarget(int numOfTourToReachTarget) {
        this.numOfTourToReachTarget = numOfTourToReachTarget;
    }

    public int getTargetGoldValue() {
        return targetGoldValue;
    }

    public void setTargetGoldValue(int targetGoldValue) {
        this.targetGoldValue = targetGoldValue;
    }

    public int getTargetCost() {
        return targetCost;
    }

    public void setTargetCost(int targetCost) {
        this.targetCost = targetCost;
    }

    public int getEndOfTourGold() {
        return endOfTourGold;
    }

    public void setEndOfTourGold(int endOfTourGold) {
        this.endOfTourGold = endOfTourGold;
    }

    public int getEndOfChooseTarget() {
        return endOfChooseTarget;
    }

    public void setEndOfChooseTarget(int endOfChooseTarget) {
        this.endOfChooseTarget = endOfChooseTarget;
    }
    
    
}
