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
public class GamerC extends Gamer {

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

    public int openSecretGolds(int SecretGoldsNum, Square[][] b, GameBoard gb) {
        int openGoldsNum = 0;
        SquareButtons[][] board;
        board = gb.getboard();
        if (SecretGoldsNum != 0) {//Burdaki kosulu main metodun'da yapabiliriz.Ama ben burda yaptim.Degistirilebilir.
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    if (openGoldsNum != 2) {
                        if (b[i][j].ishaveSecretGold()) {
                            b[i][j].sethaveSecretGold(false);
                            b[i][j].setHaveGold(true);
                            //Buraya da gizli altın yerine normal altın resmi gelmeli.
                            board[i][j].setIcon(gb.getgold());
                            openGoldsNum++;

                            //Bu if koşulu ile eger gizli altin sayisi 1 kalirsa bulduktan sonra bütun donguyu onu aramak ile ugrasmasin direk bulunca ciksin diye.
                            if (openGoldsNum == 1 && openGoldsNum == SecretGoldsNum) {
                                SecretGoldsNum--;
                                return 0;
                            }
                            SecretGoldsNum--;//Burda bence else koymaya gerek yok.Return il zaten girerse cikar.
                        }
                    } else {
                        return SecretGoldsNum;
                    }
                }
            }
            // return SecretGoldsNum;//Eger if içerisine if tanımalamaz isek olamali.Yani dongu bitti bulamadi gibi.
        }
        return SecretGoldsNum;

    }

    private int findCost(int stepsNum, int GoldValue) {
        /*
        Bu metot ile beraber kaç tur sonunda hedefteki altina ulasabilir diye hesap yapıyorum.
        Sonra bunu maliyetini hesaplamak icin 3'un kac katı ya da katları mı gibi sorarak hesap yaptım.
         */
        int resultcost, result, takeMod;
        result = stepsNum / 3;
        if (stepsNum < 3) {
            resultcost = GoldValue - 1 * this.endOfTourGold;//Burdaki 5 degeri options'ta alinan degere gore degisir.
        } else {
            takeMod = stepsNum % 3;
            if (takeMod == 0) {
                resultcost = GoldValue - result * this.endOfTourGold;
            } else {
                resultcost = GoldValue - (result + 1) * this.endOfTourGold;
            }
        }
        return resultcost;
    }

    @Override
    List<Integer> findTarget(GameArena arena) {
        Square s[][] = arena.getArena();
        int x1 = 0, y1 = s[0].length;// max distance to C beginning location (0,n)
        int row = s.length;
        int col = s[0].length; // take arena row and col num
        int x2, y2;
        int targetY, targetX;
        targetX = targetY = 0;
        List<Integer> location = this.getCurrentLocation();
        int startXlocation = location.get(0);
        int startYlocation = location.get(1);
        int resultStepsNum, StepsNum1 = x1 + y1, StepsNum2;
        int resultCost = 0, cost1 = this.findCost(StepsNum1, 0), cost2;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (s[i][j].ishaveSecretGold()) {
                    continue;
                } else if (s[i][j].isHaveGold()) {
                    x2 = Math.abs(startXlocation - i);//Burda distance'larin farklarini bulduk.
                    y2 = Math.abs(startYlocation - j);
                    StepsNum2 = x2 + y2;
                    cost2 = this.findCost(StepsNum2, s[i][j].getGoldValue());
                    if (cost2 > cost1) {//Adim sayilarini ve de uzakliklarini bulmus oluyoruz.
                        targetX = i;
                        targetY = j;
                        x1 = x2;
                        y1 = y2;
                        cost1 = cost2;
                        StepsNum1 = x2 + y2;//Bunu yapiyorum cunku StepsNum2 surekli degiscek.
                        resultCost = cost2;
                    }
                }
            }
        }
        resultStepsNum = StepsNum1;
        System.out.println("\nPlayer Target Indexes:");
        System.out.println("Target X Index:" + targetX + " Target Y Index:" + targetY);
        System.out.println("Target's Gold Value:" + s[targetX][targetY].getGoldValue());
        System.out.println("For Player arrives Target's Gold needs number of steps:" + resultStepsNum);
        System.out.println("Player's Cost:" + resultCost);

        List<Integer> tarLocation = new ArrayList<>();
        tarLocation.add(targetX);
        tarLocation.add(targetY);
        targetGoldValue = s[targetX][targetY].getGoldValue();

        //update to gamer Data 
        this.target = tarLocation;
        this.numOfStepToReachTarget = StepsNum1;
        this.numOfTourToReachTarget = this.numOfStepToReachTarget / this.getNumOfStep();
        this.balance = this.balance - this.endOfChooseTarget;

        targetCost = targetGoldValue - ((numOfTourToReachTarget * endOfTourGold) + endOfChooseTarget);
        return target;
    }

    @Override
    List<Integer> move(GameArena a, GameBoard gb, GamerA A, GamerB B, GamerC C, GamerD D) {
        //Bu metotta hareket ederken gittiği yerlerde altın var mı diye sorması lazım!!!
        int targetX = target.get(0);
        int targetY = target.get(1);
        int currentX = C.getCurrentLocation().get(0);
        int currentY = C.getCurrentLocation().get(1);
        int currentXA, currentYA, currentXB, currentYB, currentXD, currentYD;
        int startX = currentX, startY = currentY;
        currentXA = A.getCurrentLocation().get(0);
        currentYA = A.getCurrentLocation().get(1);
        currentXB = B.getCurrentLocation().get(0);
        currentYB = B.getCurrentLocation().get(1);
        currentXD = D.getCurrentLocation().get(0);
        currentYD = D.getCurrentLocation().get(1);
        List<Integer> l = new ArrayList<>();
        Square[][] b = a.getArena();
        //Burası sonradan yaptığım yerler
        SquareButtons[][] board;
        board = gb.getboard();
        int ContVariable = 1;
        if (C.balance > C.endOfTourGold) {
            //Burada ilk konuma başlarken player'in olduğu yer grass icon olacak.
            /*if((currentX!=currentXB || currentY!=currentYB) && (currentX!=currentXA || currentY!=currentYA) && (currentX!=currentXD || currentY!=currentYD))
         {
             ContVariable=1;
             board[currentX][currentY].setIcon(gb.getgrass());
         }*/
            //board[currentX][currentY].setIcon(gb.getgrass());
            // else board[startX][startY].setIcon(gb.getminerC());      
            int count = 0;
            while (count != this.getNumOfStep()) { // every tour will forward 3 step 
                if (currentX != targetX) { // everytime first forward on x
                    if (currentX < targetX) {
                        currentX++;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal altın icon donusturulecek
                            // if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXD && currentY!=currentYA && currentY!=currentYB && currentY!=currentYD)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4) {
                            currentX--;
                        }
                        //Buralara gizli altın var mı diye bakılmalı ve de gizli altın sayısı azaltılıp normal altın sayısı devam etmeli.Altın sayısında değişiklik olmayacak.
                    } else if (currentX > targetX) {
                        currentX--;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal altın icon donusturulecek
                            //if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXD && currentY!=currentYA && currentY!=currentYB && currentY!=currentYD)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4) {
                            currentX++;
                        }
                    }
                } else if (currentY != targetY) { // if currentx = targetx, it will forward on y
                    if (currentY < targetY) {
                        currentY++;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal altın icon donusturulecek 
                            //if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXD && currentY!=currentYA && currentY!=currentYB && currentY!=currentYD)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4) {
                            currentY--;
                        }
                    } else if (currentY > targetY) {
                        currentY--;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal altın icon donusturulecek 
                            // if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXD && currentY!=currentYA && currentY!=currentYB && currentY!=currentYD)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 4) {
                            currentY++;
                        }
                    }
                } //Buraya bence koşul konmalı.
                else {
                    System.out.println("Oyuncu hedefine ulaşmıştır.Şimdiki Konum Bilgileri:" + currentX + " " + currentY);
                    b[targetX][targetY].setHaveGold(false);
                    //Burda altın sayısı oyun alınındaki bir azaltılmalı.
                    a.settotalGold(a.gettotalGold() - 1);
                    a.setnumOfGold(a.getnumOfGold() - 1);
                    //Burada altın iconu yerine player iconu gelecek.Hangi class içinde ise ona göre olacak.
                    if ((currentX != currentXB || currentY != currentYB) && (currentX != currentXA || currentY != currentYA) && (currentX != currentXD || currentY != currentYD)) {
                        ContVariable = 0;
                        board[startX][startY].setIcon(gb.getgrass());
                        board[currentX][currentY].setIcon(gb.getminerC());
                    } else {
                        board[startX][startY].setIcon(gb.getgrass());
                    }

                    b[targetX][targetY].setGoldValue(0);//Burası belki olamayabilir.
                    C.findTarget(a);// eğer bulduysa bu D için hemen yeni bir hedef belirlenmeli.
                    break;//Eşitse direk çıksın daha iyi performans olur.
                }
                count++;
            }
            //Buraya da gelmeli.Çünkü eğer hedefine ulaşamazsa Player'in yeri değişmiş olacak zaten.
            //Buraya Player iconu yerleştirilmeli grass iconu yerine
            if ((currentX != currentXB || currentY != currentYB) && (currentX != currentXA || currentY != currentYA) && (currentX != currentXD || currentY != currentYD)) {
                ContVariable = 0;
                board[startX][startY].setIcon(gb.getgrass());
                board[currentX][currentY].setIcon(gb.getminerC());
            } else {
                board[startX][startY].setIcon(gb.getgrass());
            }
            l.add(currentX);
            l.add(currentY);
            C.setCurrentLocation(l);
            tempPath.add(C.getCurrentLocation());
            C.setPath(tempPath);
            C.balance = C.balance - endOfTourGold;

        } else {
            this.balance = 0;
            System.out.println("not enough balance to continue tour");
            JOptionPane.showMessageDialog(null, "C Oyuncusunun Altınları bitmiştir!!!", "BİTİŞ", JOptionPane.INFORMATION_MESSAGE);
            board[currentX][currentY].setIcon(gb.getgrass());

            // else board[startX][startY].setIcon(gb.getgrass()); 
        }
        //if(ContVariable!=0) board[startX][startY].setIcon(gb.getminerC());

        tb.add(this.getBalance());
        this.setTourBasedBalance(tb);
        return C.getCurrentLocation();
    }

    public GamerC(int balance, int endOfTourGold, int endOfChooseTarget, int m) {
        this.balance = balance;
        this.endOfTourGold = endOfTourGold;
        this.endOfChooseTarget = endOfChooseTarget;
        List<Integer> cLocation = new ArrayList<>();
        cLocation.add(m);
        cLocation.add(0); // this m is same with square[][] row number;
        this.setCurrentLocation(cLocation); // beginning location for A == (m,0)
        this.setNumOfStep(3); // Gamer A can move 3 square in a tour
        this.tempPath = new ArrayList<>();
        tempPath.add(this.getCurrentLocation());
    }

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
