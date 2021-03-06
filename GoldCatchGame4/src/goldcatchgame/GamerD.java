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
public class GamerD extends Gamer {

    private List<Integer> target;
    private int balance; // gold number 
    private int endOfTourGold; // how much gold will decrease end of tour 
    private int endOfChooseTarget; // how much gold wil decrease after choose a target
    private GamerA A;
    private GamerB B;
    private GamerC C; // to Check Other Gamer Status we need them
    private int numOfStepToReachTarget; // how much step gamer can reach to target;
    private int numOfTourToReachTarget; // how much tour gamer can reach to tager
    private int targetGoldValue;
    private int targetCost;
    private List<List<Integer>> tempPath;
    private List<Integer> tb = new ArrayList<>();

    private boolean otherGamerTargetCheck() {
        int xTA, yTA, xTB, yTB, xTC, yTC;
        xTA = A.getTarget().get(0);
        yTA = A.getTarget().get(1);
        xTB = B.getTarget().get(0);
        yTB = B.getTarget().get(1);
        xTC = C.getTarget().get(0);
        yTC = C.getTarget().get(1);

        int xD, yD;
        xD = this.getCurrentLocation().get(0);
        yD = this.getCurrentLocation().get(1);
        int DtargetToAStep = Math.abs(xD - xTA) + Math.abs(yD - yTA);
        int DtargetToBStep = Math.abs(xD - xTB) + Math.abs(yD - yTB);
        int DtargetToCStep = Math.abs(xD - xTC) + Math.abs(yD - yTC);

        int AtargetStep = A.getNumOfStepToReachTarget();
        int BtargetStep = B.getNumOfStepToReachTarget();
        int CtargetStep = C.getNumOfStepToReachTarget();
        int Dcost;

        if (AtargetStep > DtargetToAStep) {
            int goldValue = A.getTargetGoldValue();
            int Acost = A.getTargetCost();
            Dcost = goldValue - ((DtargetToAStep * endOfTourGold) + endOfChooseTarget);
            if (Dcost > Acost) {
                targetGoldValue = goldValue;
                targetCost = Dcost;
                this.target = A.getTarget();
                this.numOfStepToReachTarget = DtargetToAStep;
                this.numOfTourToReachTarget = DtargetToAStep / this.getNumOfStep();
                return true;
            }
        } else if (BtargetStep > DtargetToBStep) {
            int goldValue = B.getTargetGoldValue();
            int Bcost = B.getTargetCost();
            Dcost = goldValue - ((DtargetToBStep * endOfTourGold) + endOfChooseTarget);
            if (Dcost > Bcost) {
                targetGoldValue = goldValue;
                targetCost = Dcost;
                this.target = B.getTarget();
                this.numOfStepToReachTarget = DtargetToBStep;
                this.numOfTourToReachTarget = DtargetToBStep / this.getNumOfStep();
                return true;
            }
        } else if (CtargetStep > DtargetToCStep) {
            int goldValue = C.getTargetGoldValue();
            int Ccost = C.getTargetCost();
            Dcost = goldValue - ((DtargetToCStep * endOfTourGold) + endOfChooseTarget);
            if (Dcost > Ccost) {
                targetGoldValue = goldValue;
                targetCost = Dcost;
                this.target = C.getTarget();
                this.numOfStepToReachTarget = DtargetToCStep;
                this.numOfTourToReachTarget = DtargetToCStep / this.getNumOfStep();
                return true;

            }
        }
        return false;
    }

    private int findCost(int stepsNum, int GoldValue) {
        /*
        Bu metot ile beraber ka?? tur sonunda hedefteki altina ulasabilir diye hesap yap??yorum.
        Sonra bunu maliyetini hesaplamak icin 3'un kac kat?? ya da katlar?? m?? gibi sorarak hesap yapt??m.
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
        int x1 = 0, y1 = 0;// max distance to B beginning location (0,0)
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
        if (this.otherGamerTargetCheck()) {

        } else {
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
        }
        return target;
    }

    @Override
    List<Integer> move(GameArena a, GameBoard gb, GamerA A, GamerB B, GamerC C, GamerD D) {
        //Bu metotta hareket ederken gitti??i yerlerde alt??n var m?? diye sormas?? laz??m!!!
        int targetX = target.get(0);
        int targetY = target.get(1);
        int currentX = D.getCurrentLocation().get(0);
        int currentY = D.getCurrentLocation().get(1);
        int currentXA, currentYA, currentXC, currentYC, currentXB, currentYB;
        int startX = currentX, startY = currentY;
        currentXA = A.getCurrentLocation().get(0);
        currentYA = A.getCurrentLocation().get(1);
        currentXC = C.getCurrentLocation().get(0);
        currentYC = C.getCurrentLocation().get(1);
        currentXB = B.getCurrentLocation().get(0);
        currentYB = B.getCurrentLocation().get(1);
        List<Integer> l = new ArrayList<>();
        Square[][] b = a.getArena();
        //Buras?? sonradan yapt??????m yerler
        SquareButtons[][] board;
        board = gb.getboard();
        int ContVariable = 1;
        if (D.balance > D.endOfTourGold) {
            //Burada ilk konuma ba??larken player'in oldu??u yer grass icon olacak.

            /*if((currentX!=currentXB || currentY!=currentYB) && (currentX!=currentXC || currentY!=currentYC) && (currentX!=currentXA || currentY!=currentYA))
           {
               ContVariable=1;
               board[currentX][currentY].setIcon(gb.getgrass());
           }*/
            //board[currentX][currentY].setIcon(gb.getgrass());
            //else board[startX][startY].setIcon(gb.getminerD());      
            int count = 0;
            while (count != D.getNumOfStep()) { // every tour will forward 3 step 
                if (currentX != targetX) { // everytime first forward on x
                    if (currentX < targetX) {
                        currentX++;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal alt??n icon donusturulecek
                            //if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXC && currentY!=currentYA && currentY!=currentYB && currentY!=currentYC)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3) {
                            currentX--;
                        }
                        //Buralara gizli alt??n var m?? diye bak??lmal?? ve de gizli alt??n say??s?? azalt??l??p normal alt??n say??s?? devam etmeli.Alt??n say??s??nda de??i??iklik olmayacak.
                    } else if (currentX > targetX) {
                        currentX--;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal alt??n icon donusturulecek
                            //if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXC && currentY!=currentYA && currentY!=currentYB && currentY!=currentYC)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3) {
                            currentX++;
                        }
                    }
                } else if (currentY != targetY) { // if currentx = targetx, it will forward on y
                    if (currentY < targetY) {
                        currentY++;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal alt??n icon donusturulecek 
                            // if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXC && currentY!=currentYA && currentY!=currentYB && currentY!=currentYC)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3) {
                            currentY--;
                        }
                    } else if (currentY > targetY) {
                        currentY--;
                        if (b[currentX][currentY].ishaveSecretGold()) {
                            b[currentX][currentY].sethaveSecretGold(false);
                            b[targetX][targetY].setHaveGold(true);
                            //Burada normal alt??n icon donusturulecek 
                            //if(currentX!=currentXA && currentX!=currentXB && currentX!=currentXC && currentY!=currentYA && currentY!=currentYB && currentY!=currentYC)
                            board[currentX][currentY].setIcon(gb.getgold());
                            a.setnumOfGold(a.getnumOfGold() + 1);
                            a.setnumOfSecretGold(a.getnumOfSecretGold() - 1);
                        }
                        if (b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 1
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 2
                                || b[currentX][currentY].isSomeOne(currentX, currentY, A, B, C, D) == 3) {
                            currentY++;
                        }
                    }
                } //Buraya bence ko??ul konmal??.
                else {
                    System.out.println("Oyuncu hedefine ula??m????t??r.??imdiki Konum Bilgileri:" + currentX + " " + currentY);
                    b[targetX][targetY].setHaveGold(false);
                    //Burda alt??n say??s?? oyun al??n??ndaki bir azalt??lmal??.
                    a.settotalGold(a.gettotalGold() - 1);
                    a.setnumOfGold(a.getnumOfGold() - 1);
                    //Burada alt??n iconu yerine player iconu gelecek.Hangi class i??inde ise ona g??re olacak.
                    if ((currentX != currentXB || currentY != currentYB) && (currentX != currentXC || currentY != currentYC) && (currentX != currentXA || currentY != currentYA)) {
                        ContVariable = 0;
                        board[startX][startY].setIcon(gb.getgrass());
                        board[currentX][currentY].setIcon(gb.getminerD());
                    } else {
                        board[startX][startY].setIcon(gb.getgrass());
                    }
                    b[targetX][targetY].setGoldValue(0);//Buras?? belki olamayabilir.
                    D.findTarget(a);// e??er bulduysa bu D i??in hemen yeni bir hedef belirlenmeli.
                    break;//E??itse direk ????ks??n daha iyi performans olur.
                }
                count++;
            }
            //Buraya da gelmeli.????nk?? e??er hedefine ula??amazsa Player'in yeri de??i??mi?? olacak zaten.
            //Buraya Player iconu yerle??tirilmeli grass iconu yerine
            if ((currentX != currentXB || currentY != currentYB) && (currentX != currentXC || currentY != currentYC) && (currentX != currentXA || currentY != currentYA)) {
                ContVariable = 0;
                board[startX][startY].setIcon(gb.getgrass());
                board[currentX][currentY].setIcon(gb.getminerD());
            } else {
                board[startX][startY].setIcon(gb.getgrass());
            }
            l.add(currentX);
            l.add(currentY);
            D.setCurrentLocation(l);
            tempPath.add(D.getCurrentLocation());
            D.setPath(tempPath);
            D.balance = D.balance - endOfTourGold;

        } else {
            this.balance = 0;
            System.out.println("not enough balance to continue tour");
            JOptionPane.showMessageDialog(null, "D Oyuncusunun Alt??nlar?? bitmi??tir!!!", "B??T????", JOptionPane.INFORMATION_MESSAGE);
            board[currentX][currentY].setIcon(gb.getgrass());

            // else board[startX][startY].setIcon(gb.getgrass());
        }
        //if(ContVariable!=0) board[startX][startY].setIcon(gb.getminerD());

        tb.add(this.getBalance());
        this.setTourBasedBalance(tb);
        return this.getCurrentLocation();
    }

    private void setupGamer(GamerA A, GamerB B, GamerC C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public GamerD(int balance, int endOfTourGold, int endOfChooseTarget, GamerA A, GamerB B, GamerC C, int m, int n) {
        this.balance = balance;
        this.endOfTourGold = endOfTourGold;
        this.endOfChooseTarget = endOfChooseTarget;
        setupGamer(A, B, C);
        List<Integer> cLocation = new ArrayList<>();
        cLocation.add(m);
        cLocation.add(n); // this n is same with square[][] col num ;
        this.setCurrentLocation(cLocation); // beginning location for A == (m,n)
        this.setNumOfStep(3); // Gamer A can move 3 square in a tour
        tempPath = new ArrayList<>();
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
