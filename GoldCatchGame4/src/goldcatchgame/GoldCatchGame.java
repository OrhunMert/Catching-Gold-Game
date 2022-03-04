/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldcatchgame;

import graphics.GameBoard;
import graphics.SquareButtons;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author abdus
 */
public class GoldCatchGame {

    /**
     * @param args the command line arguments
     */
    /* public void GameRun() throws InterruptedException{//Bu metoda değer girdileri almamız lazım.
        
        
        GameArena a = new GameArena(20, 10, 15, 10);
        a.setupArena();
        Square[][] b = a.getArena();
        
        graphics.GameBoard gb = new GameBoard(1000,750,a); //make object from class in other package
        gb.run();
        //buradaki dikdörtgenin boyutu arttıp küçüldükçe frame'i değiştirdiğimiz için çok küçükte ve büyükte boyutlar saçmalıyor
        //row ve col'ları -1 yapmayı unutma.
        GamerA A = new GamerA(200, 5, 5);//balance(toplam altın sayısı),endTour(adım sayısı sonu eksilcek altın,hedef belirleme maliyeti
        GamerB B = new GamerB(200,5,10,9);//Buralar satır ve sütun sayıları olduğu için böyle olacak.0'dan başlıyor.
        GamerC C = new GamerC(200,5,15,19);
        GamerD D = new GamerD(200, 5, 20, A, B, C, 19, 9);
        //setup first target
        A.findTarget(a);
        B.findTarget(a);
        //a.setnumOfSecretGold(C.openSecretGolds(a.getnumOfSecretGold(), b,gb));
        //a.settotalGold(a.getnumOfSecretGold()+a.getnumOfGold()); // buralar açık kalırsa sıfır gizli gold ile oyun başlıyor
        C.findTarget(a);
        D.findTarget(a);
        int tourNum=1;
        JOptionPane.showMessageDialog(null,"OYUN BAŞLIYOR...İYİ EĞLENCELER!!!","BAŞLANGIÇ",JOptionPane.INFORMATION_MESSAGE);
        while((A.getBalance() > 0 || B.getBalance() >0 || C.getBalance() > 0 || D.getBalance() > 0) && a.gettotalGold()!=0){
            //Oyun alanında altın kaldı mı diye de kontrol yapılmalı.    
            System.out.println("\n"+tourNum+".tur A oyuncusu hareket ediyor!!!");
                if(A.getBalance() > 0){
                if(A.getCurrentLocation().get(0) == A.getTarget().get(0) && A.getCurrentLocation().get(1) == A.getTarget().get(1)){
                    System.out.println("\nPlayer A");
                    int balance = A.getBalance();
                    balance = balance + A.getTargetGoldValue();
                    A.findTarget(a);
                }
               if(b[A.getTarget().get(0)][A.getTarget().get(1)].isHaveGold()){
                   A.move(a,gb);
               }
               else{
                 //JOptionPane.showMessageDialog(null,"A Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                 A.findTarget(a);
                 A.move(a, gb);
               }
                //Buraya Thread komuutu gelmeli.
                Thread.sleep(500);
            }
            if(B.getBalance() > 0){
                System.out.println("\n"+tourNum+".tur B oyuncusu hareket ediyor!!!");
                if(B.getCurrentLocation().get(0) == B.getTarget().get(0) && B.getCurrentLocation().get(1) == B.getTarget().get(1)){
                    System.out.println("\nPlayer B");
                    int balance = B.getBalance();
                    balance = balance + B.getTargetGoldValue();
                    B.findTarget(a);
                }
                
               if(b[B.getTarget().get(0)][B.getTarget().get(1)].isHaveGold()){
                   B.move(a,gb);
               }
               else{
                 //JOptionPane.showMessageDialog(null,"B Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                 B.findTarget(a);
                 B.move(a, gb);
               }
                //Buraya Thread komuutu gelmeli.
                Thread.sleep(500);
            }
            if(C.getBalance() > 0){ 
                System.out.println("\n"+tourNum+".tur C oyuncusu hareket ediyor!!!");
                if(C.getCurrentLocation().get(0) == C.getTarget().get(0) && C.getCurrentLocation().get(1) == C.getTarget().get(1)){
                    System.out.println("\nPlayer C");
                    int balance = C.getBalance();
                    balance = balance + C.getTargetGoldValue();
                    C.setBalance(balance);
                    a.setnumOfSecretGold(C.openSecretGolds(a.getnumOfSecretGold(), b,gb));
                    a.settotalGold(a.getnumOfSecretGold()+a.getnumOfGold());
                    C.findTarget(a);
                }
               
                if(b[C.getTarget().get(0)][C.getTarget().get(1)].isHaveGold()){
                    C.move(a,gb);
                } 
                else{
                   // JOptionPane.showMessageDialog(null,"C Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                    C.findTarget(a);
                    C.move(a,gb);
                }
                //Buraya Thread komuutu gelmeli. 
                
                Thread.sleep(500);
            }
            if(D.getBalance() > 0){ 
                System.out.println("\n"+tourNum+".tur D oyuncusu hareket ediyor!!!");
                if(D.getCurrentLocation().get(0) == D.getTarget().get(0) && D.getCurrentLocation().get(1) == D.getTarget().get(1)){
                    System.out.println("\nPlayer D");
                    int balance = D.getBalance();
                    balance = balance + D.getTargetGoldValue();
                    D.findTarget(a);
                }
               
               if(b[D.getTarget().get(0)][D.getTarget().get(1)].isHaveGold()){
                   D.move(a,gb);
               }
               else{
                 //JOptionPane.showMessageDialog(null,"D Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                 D.findTarget(a);
                 D.move(a, gb);
               }
                //Buraya Thread komuutu gelmeli.
            }
            JOptionPane.showMessageDialog(null,""+tourNum+".TUR BİTMİŞTİR!!!","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            tourNum++;
        }
        JOptionPane.showMessageDialog(null,"Oyun Bitmiştir!!!Oynadığınız için TEŞEKKÜRLER!!!","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
         /*for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (b[i][j].ishaveSecretGold()) {
                    System.out.print(b[i][j].getGoldValue()+"*");
                  
                } else if (b[i][j].isHaveGold()) {
                    System.out.print(b[i][j].getGoldValue());
                    
                } else {
                    System.out.print(b[i][j].getGoldValue());
                }
                System.out.print("\t");
            }
            System.out.println("\n");
        }  
        System.out.println("A path : ");
        for(int i =0 ; i<A.getPath().size();i++){
            System.out.println("X : "+A.getPath().get(i).get(0)+" Y : "+A.getPath().get(i).get(1));
        }
        System.out.println("B path : ");
        for(int i =0 ; i<B.getPath().size();i++){
            System.out.println("X : "+B.getPath().get(i).get(0)+" Y : "+B.getPath().get(i).get(1));
        }
        System.out.println("C path : ");
        for(int i =0 ; i<C.getPath().size();i++){
            System.out.println("X : "+C.getPath().get(i).get(0)+" Y : "+C.getPath().get(i).get(1));
        }
        System.out.println("D path : ");
        for(int i =0 ; i<D.getPath().size();i++){
            System.out.println("X : "+D.getPath().get(i).get(0)+" Y : "+D.getPath().get(i).get(1));
        }
        System.out.println("\n");
        System.out.println("Players Balances:");
        System.out.println("A:"+A.getBalance());
        System.out.println("B:"+B.getBalance());
        System.out.println("C:"+C.getBalance());
        System.out.println("D:"+D.getBalance());
        System.out.println("Kalan Altın Sayıları:");
        System.out.println("Toplam Altın:"+a.gettotalGold());
        System.out.println("Gizli Altın:"+a.getnumOfSecretGold());
        System.out.println("Normal Altın:"+a.getnumOfGold());
    }*/
   public void GameRun(int boardM, int boardN, int goldBalance, int numOfStep, int perGold, int perSecretGold,
            int dstA, int dstB, int dstC, int dstD, int detA, int detB, int detC, int detD
    ) throws InterruptedException {//Bu metoda değer girdileri almamız lazım.

        GameArena a = new GameArena(boardM, boardN, perGold, perSecretGold);
        a.setupArena();
        Square[][] b = a.getArena();

        graphics.GameBoard gb = new GameBoard( 1368 , 768 , a); //make object from class in other package
        gb.run();
        SquareButtons[][] board;
        board = gb.getboard();
        //buradaki dikdörtgenin boyutu arttıp küçüldükçe frame'i değiştirdiğimiz için çok küçükte ve büyükte boyutlar saçmalıyor
        //row ve col'ları -1 yapmayı unutma.
        GamerA A = new GamerA(goldBalance, detA, dstA);//balance(toplam altın sayısı),endTour(adım sayısı sonu eksilcek altın,hedef belirleme maliyeti
        GamerB B = new GamerB(goldBalance, detB, dstB, boardN - 1);//Buralar satır ve sütun sayıları olduğu için böyle olacak.0'dan başlıyor.
        GamerC C = new GamerC(goldBalance, detC, dstC, boardM - 1);
        GamerD D = new GamerD(goldBalance, detD, dstD, A, B, C, boardM - 1, boardN - 1);
        A.setNumOfStep(numOfStep);
        B.setNumOfStep(numOfStep);
        C.setNumOfStep(numOfStep);
        D.setNumOfStep(numOfStep);

        //setup first target
        A.findTarget(a);
        B.findTarget(a);
        //a.setnumOfSecretGold(C.openSecretGolds(a.getnumOfSecretGold(), b,gb));
        //a.settotalGold(a.getnumOfSecretGold()+a.getnumOfGold()); // buralar açık kalırsa sıfır gizli gold ile oyun başlıyor
        C.findTarget(a);
        D.findTarget(a);
        int tourNum = 1;
        int ControlFinishVariableA=1,ControlFinishVariableB=1,ControlFinishVariableC=1,ControlFinishVariableD=1;
        JOptionPane.showMessageDialog(null, "OYUN BAŞLIYOR...İYİ EĞLENCELER!!!", "BAŞLANGIÇ", JOptionPane.INFORMATION_MESSAGE);
        while ((A.getBalance() > 0 || B.getBalance() > 0 || C.getBalance() > 0 || D.getBalance() > 0) && a.gettotalGold() != 0) {
            //Oyun alanında altın kaldı mı diye de kontrol yapılmalı.    

            System.out.println("\n" + tourNum + ".tur A oyuncusu hareket ediyor!!!");
            if (A.getBalance() > 0) {
                if (A.getCurrentLocation().get(0) == A.getTarget().get(0) && A.getCurrentLocation().get(1) == A.getTarget().get(1)) {
                    System.out.println("\nPlayer A");
                    int balance = A.getBalance();
                    balance = balance + A.getTargetGoldValue();
                    A.findTarget(a);
                }
                if (b[A.getTarget().get(0)][A.getTarget().get(1)].isHaveGold()) {
                    A.move(a, gb, A, B, C, D);
                } else {
                    //JOptionPane.showMessageDialog(null,"A Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                    A.findTarget(a);
                    A.move(a, gb, A, B, C, D);
                }
                //Buraya Thread komuutu gelmeli.
                Thread.sleep(500);//3000
            } else {
                if(ControlFinishVariableA==1) JOptionPane.showMessageDialog(null, "A OYUNCUSUNUN ALTINI BİTMİŞTİR!!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                board[A.getCurrentLocation().get(0)][A.getCurrentLocation().get(1)].setIcon(gb.getgrass());
                ControlFinishVariableA=0;
            }

            if (B.getBalance() > 0) {
                System.out.println("\n" + tourNum + ".tur B oyuncusu hareket ediyor!!!");
                if (B.getCurrentLocation().get(0) == B.getTarget().get(0) && B.getCurrentLocation().get(1) == B.getTarget().get(1)) {
                    System.out.println("\nPlayer B");
                    int balance = B.getBalance();
                    balance = balance + B.getTargetGoldValue();
                    B.findTarget(a);
                }

                if (b[B.getTarget().get(0)][B.getTarget().get(1)].isHaveGold()) {
                    B.move(a, gb, A, B, C, D);
                } else {
                    //JOptionPane.showMessageDialog(null,"B Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                    B.findTarget(a);
                    B.move(a, gb, A, B, C, D);
                }
                //Buraya Thread komuutu gelmeli.
                Thread.sleep(500);//3000
            } else {
                if(ControlFinishVariableB==1) JOptionPane.showMessageDialog(null, "B OYUNCUSUNUN ALTINI BİTMİŞTİR!!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                board[B.getCurrentLocation().get(0)][B.getCurrentLocation().get(1)].setIcon(gb.getgrass());
                ControlFinishVariableB=0;
            }

            if (C.getBalance() > 0) {
                System.out.println("\n" + tourNum + ".tur C oyuncusu hareket ediyor!!!");
                if (C.getCurrentLocation().get(0) == C.getTarget().get(0) && C.getCurrentLocation().get(1) == C.getTarget().get(1)) {
                    System.out.println("\nPlayer C");
                    int balance = C.getBalance();
                    balance = balance + C.getTargetGoldValue();
                    C.setBalance(balance);
                    C.findTarget(a);
                }

                if (b[C.getTarget().get(0)][C.getTarget().get(1)].isHaveGold()) {
                    C.move(a, gb, A, B, C, D);
                    int differance = a.getnumOfSecretGold();
                    a.setnumOfSecretGold(C.openSecretGolds(a.getnumOfSecretGold(), b, gb));
                    differance = differance - a.getnumOfSecretGold();
                    a.settotalGold(a.getnumOfSecretGold() + a.getnumOfGold() + differance);
                } else {
                    // JOptionPane.showMessageDialog(null,"C Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                    C.findTarget(a);
                    C.move(a, gb, A, B, C, D);
                    int differance = a.getnumOfSecretGold();
                    a.setnumOfSecretGold(C.openSecretGolds(a.getnumOfSecretGold(), b, gb));
                    differance = differance - a.getnumOfSecretGold();
                    a.settotalGold(a.getnumOfSecretGold() + a.getnumOfGold() + differance);
                }
                //Buraya Thread komuutu gelmeli. 

                Thread.sleep(500);//3000
            } else {
                if(ControlFinishVariableC==1) JOptionPane.showMessageDialog(null, "C OYUNCUSUNUN ALTINI BİTMİŞTİR!!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                board[C.getCurrentLocation().get(0)][C.getCurrentLocation().get(1)].setIcon(gb.getgrass());
                ControlFinishVariableC=0;
            }

            if (D.getBalance() > 0) {
                System.out.println("\n" + tourNum + ".tur D oyuncusu hareket ediyor!!!");
                if (D.getCurrentLocation().get(0) == D.getTarget().get(0) && D.getCurrentLocation().get(1) == D.getTarget().get(1)) {
                    System.out.println("\nPlayer D");
                    int balance = D.getBalance();
                    balance = balance + D.getTargetGoldValue();
                    D.findTarget(a);
                }

                if (b[D.getTarget().get(0)][D.getTarget().get(1)].isHaveGold()) {
                    D.move(a, gb, A, B, C, D);
                } else {
                    // JOptionPane.showMessageDialog(null,"D Oyunusunun hedefdeki altını alınmıştır.Yeni bir hedef belirleniyor...","BİTİŞ",JOptionPane.INFORMATION_MESSAGE);
                    D.findTarget(a);
                    D.move(a, gb, A, B, C, D);
                }
                //Buraya Thread komuutu gelmeli.
            } else {
                if(ControlFinishVariableD==1) JOptionPane.showMessageDialog(null, "D OYUNCUSUNUN ALTINI BİTMİŞTİR!!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                board[D.getCurrentLocation().get(0)][D.getCurrentLocation().get(1)].setIcon(gb.getgrass());
                ControlFinishVariableD=0;
            }

            JOptionPane.showMessageDialog(null, "" + tourNum + ".TUR BİTMİŞTİR!!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            tourNum++;
           if((A.getBalance() < 0 && B.getBalance() < 0 && C.getBalance() < 0) || (A.getBalance() < 0 && B.getBalance() < 0 && D.getBalance() < 0) ||
                    (A.getBalance() < 0 && C.getBalance() < 0 && D.getBalance() < 0) || (B.getBalance() < 0 && C.getBalance() < 0 && D.getBalance() < 0)){
                break;
            }
           if((A.getBalance() == 0 && B.getBalance() == 0 && C.getBalance() == 0) || (A.getBalance() == 0 && B.getBalance() == 0 && D.getBalance() == 0) ||
                    (A.getBalance() == 0 && C.getBalance() == 0 && D.getBalance() == 0) || (B.getBalance() == 0 && C.getBalance() == 0 && D.getBalance() == 0)){
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Oyun Bitmiştir!!!Oynadığınız için TEŞEKKÜRLER!!!", "BİTİŞ", JOptionPane.INFORMATION_MESSAGE);

        String result1 = ((A.getBalance() > B.getBalance()) && (A.getBalance() > C.getBalance()) && (A.getBalance() > D.getBalance())) ? "wİNNER A\n" : "Loser A\n";
        String result2 = ((B.getBalance() > A.getBalance()) && (B.getBalance() > C.getBalance()) && (B.getBalance() > D.getBalance())) ? "wİNNER C\n" : "LoserB\n";
        String result3 = ((C.getBalance() > A.getBalance()) && (C.getBalance() > B.getBalance()) && (B.getBalance() > D.getBalance())) ? "wİNNER C\n" : "LoserB\n";
        String result4 = ((D.getBalance() > A.getBalance()) && (D.getBalance() > B.getBalance()) && (D.getBalance() > C.getBalance())) ? "wİNNER C\n" : "LoserB\n";
        JOptionPane.showMessageDialog(null, "BİTİŞ Bütçeleri :\n" + "A : " + A.getBalance() + "\n" + "B : " + B.getBalance()
                + "\n" + "C : " + C.getBalance() + "\n" + "D : " + D.getBalance() + "\n"
                + result1 + result2 + result3 + result4);

        for (int i = 0; i < boardM; i++) {
            for (int j = 0; j < boardN; j++) {
                if (b[i][j].ishaveSecretGold()) {
                    System.out.print(b[i][j].getGoldValue() + "*");

                } else if (b[i][j].isHaveGold()) {
                    System.out.print(b[i][j].getGoldValue());

                } else {
                    System.out.print(b[i][j].getGoldValue());
                }
                System.out.print("\t");
            }
            System.out.println("\n");
        }

        System.out.println("\n");
        System.out.println("Players Balances:");
        System.out.println("A:" + A.getBalance());
        System.out.println("B:" + B.getBalance());
        System.out.println("C:" + C.getBalance());
        System.out.println("D:" + D.getBalance());
        System.out.println("Kalan Altın Sayıları:");
        System.out.println("Toplam Altın:" + a.gettotalGold());
        System.out.println("Gizli Altın:" + a.getnumOfSecretGold());
        System.out.println("Normal Altın:" + a.getnumOfGold());
        writeToFile(A,B,C,D);
    }

    public void writeToFile(GamerA A, GamerB B, GamerC C, GamerD D) {
        File f = new File("./result.txt");
        FileWriter writer;
        BufferedWriter bufferedWriter;
        try {
            writer = new FileWriter(f, false);
            bufferedWriter = new BufferedWriter(writer);
            

            bufferedWriter.write("All Path : ");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            System.out.println("A path : ");
            bufferedWriter.write("A Path : ");
            bufferedWriter.newLine();
            for (int i = 0; i < A.getPath().size(); i++) {
                System.out.println("X : " + A.getPath().get(i).get(0) + " Y : " + A.getPath().get(i).get(1));
                bufferedWriter.write("X" + i + " : " + A.getPath().get(i).get(0) + "---" + "Y" + i + " : " + A.getPath().get(i).get(1));
                bufferedWriter.newLine();
            }
            System.out.println("B path : ");
            bufferedWriter.write("B Path : ");
            bufferedWriter.newLine();
            for (int i = 0; i < B.getPath().size(); i++) {
                System.out.println("X : " + B.getPath().get(i).get(0) + " Y : " + B.getPath().get(i).get(1));
                bufferedWriter.write("X" + i + " : " + B.getPath().get(i).get(0) + "---" + "Y" + i + " : " + B.getPath().get(i).get(1));
                bufferedWriter.newLine();
            }
            System.out.println("C path : ");
            bufferedWriter.write("C Path : ");
            bufferedWriter.newLine();
            for (int i = 0; i < C.getPath().size(); i++) {
                System.out.println("X : " + C.getPath().get(i).get(0) + " Y : " + C.getPath().get(i).get(1));
                bufferedWriter.write("X" + i + " : " + C.getPath().get(i).get(0) + "---" + "Y" + i + " : " + C.getPath().get(i).get(1));
                bufferedWriter.newLine();
            }
            System.out.println("D path : ");
            bufferedWriter.write("D Path : ");
            bufferedWriter.newLine();
            for (int i = 0; i < D.getPath().size(); i++) {
                System.out.println("X : " + D.getPath().get(i).get(0) + " Y : " + D.getPath().get(i).get(1));
                bufferedWriter.write("X" + i + " : " + D.getPath().get(i).get(0) + "---" + "Y" + i + " : " + D.getPath().get(i).get(1));
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Gold balance per tour");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            System.out.println("Gold Balance per tour : \n");
            bufferedWriter.write("A gold balance per tour : \n");
            System.out.println("A gold balance per tour : \n");
            for (int i = 0; i < A.getTourBasedBalance().size(); i++) {
                bufferedWriter.write("tour" + i + " Balance : " + A.getTourBasedBalance().get(i));
                bufferedWriter.newLine();
                System.out.println("tour" + i + " Balance : " + A.getTourBasedBalance().get(i) + "\n");
            }
            bufferedWriter.write("B gold balance per tour : \n");
            System.out.println("B gold balance per tour : \n");
            for (int i = 0; i < B.getTourBasedBalance().size(); i++) {
                bufferedWriter.write("tour" + i + " Balance : " + B.getTourBasedBalance().get(i));
                bufferedWriter.newLine();
                System.out.println("tour" + i + " Balance : " + B.getTourBasedBalance().get(i) + "\n");
            }
            bufferedWriter.write("C gold balance per tour : \n");
            System.out.println("C gold balance per tour : \n");
            for (int i = 0; i < C.getTourBasedBalance().size(); i++) {
                bufferedWriter.write("tour" + i + " Balance : " + C.getTourBasedBalance().get(i));
                bufferedWriter.newLine();
                System.out.println("tour" + i + " Balance : " + C.getTourBasedBalance().get(i) + "\n");
            }
            bufferedWriter.write("D gold balance per tour : \n");
            System.out.println("D gold balance per tour : \n");
            for (int i = 0; i < D.getTourBasedBalance().size(); i++) {
                bufferedWriter.write("tour" + i + " Balance : " + D.getTourBasedBalance().get(i));
                bufferedWriter.newLine();
                System.out.println("tour" + i + " Balance : " + D.getTourBasedBalance().get(i) + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //We will run project under there 
        System.out.println("Run place");

        //Direk burayı yorum satırından kaldır.
        Menu menu = new Menu();
        menu.setVisible(true);

    }
}
