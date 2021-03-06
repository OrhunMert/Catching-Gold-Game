/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldcatchgame;

import graphics.GameBoard;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abdus
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Options op;

    public Menu() {
        op = new Options(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GamePanel = new javax.swing.JPanel();
        ExitButtonPic = new javax.swing.JLabel();
        PlayButtonPic = new javax.swing.JLabel();
        OptionsButtonPic = new javax.swing.JLabel();
        GameBackgroundGif = new javax.swing.JLabel();
        GameBackgroundPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GamePanel.setPreferredSize(new java.awt.Dimension(1920, 1080));
        GamePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitButtonPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/ExitButtonPic.PNG"))); // NOI18N
        ExitButtonPic.setPreferredSize(new java.awt.Dimension(275, 100));
        ExitButtonPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonPicMouseClicked(evt);
            }
        });
        GamePanel.add(ExitButtonPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, 280, 130));

        PlayButtonPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/PlayButtonPic.PNG"))); // NOI18N
        PlayButtonPic.setPreferredSize(new java.awt.Dimension(275, 100));
        PlayButtonPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayButtonPicMouseClicked(evt);
            }
        });
        GamePanel.add(PlayButtonPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, -1));

        OptionsButtonPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/OptionsButtonPic.PNG"))); // NOI18N
        OptionsButtonPic.setPreferredSize(new java.awt.Dimension(275, 100));
        OptionsButtonPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptionsButtonPicMouseClicked(evt);
            }
        });
        GamePanel.add(OptionsButtonPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, -1, -1));

        GameBackgroundGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/MenuBackground.gif"))); // NOI18N
        GamePanel.add(GameBackgroundGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        GameBackgroundPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/MenuBackgroundPic.jpg"))); // NOI18N
        GamePanel.add(GameBackgroundPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(GamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayButtonPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayButtonPicMouseClicked
       GoldCatchGame play=new GoldCatchGame();
       int boardM, boardN, numOfSquare, goldBalance, numOfStep, perGold, perSecretGold,
            dstA, dstB, dstC, dstD,// dst,ABCD, => Decrease TargetSelection
            detA, detB, detC, detD;// det,ABCD, => Decrease End of Tour
            int squareSize;
            
            boardM = op.getBoardM();
            boardN = op.getBoardN();
            goldBalance = op.getGoldBalance();
            numOfStep = op.getNumOfStep();
            perGold = op.getPerGold();
            perSecretGold = op.getPerSecretGold();
            dstA = op.getDstA();
            dstB = op.getDstB();
            dstC = op.getDstC();
            dstD = op.getDstD();
            detA = op.getDetA();
            detB = op.getDetB();
            detC = op.getDetC();
            detD = op.getDetD();
       
       this.setVisible(false);
        try {
            play.GameRun(boardM,boardN,goldBalance,numOfStep,perGold,perSecretGold,
                    dstA,dstB,dstC,dstD,detA,detB,detC,detD
            );
            
           // play.GameRun();
            
            // TODO add your handling code here:
            /* int boardM, boardN, numOfSquare, goldBalance, numOfStep, perGold, perSecretGold,
            dstA, dstB, dstC, dstD,// dst,ABCD, => Decrease TargetSelection
            detA, detB, detC, detD;// det,ABCD, => Decrease End of Tour
            int squareSize;
            
            boardM = op.getBoardM();
            boardN = op.getBoardN();
            goldBalance = op.getGoldBalance();
            numOfStep = op.getNumOfStep();
            perGold = op.getPerGold();
            perSecretGold = op.getPerSecretGold();
            dstA = op.getDstA();
            dstB = op.getDstB();
            dstC = op.getDstC();
            dstD = op.getDstD();
            detA = op.getDetA();
            detB = op.getDetB();
            detC = op.getDetC();
            detD = op.getDetD();
            GameArena a = new GameArena(boardM, boardN, perGold, perSecretGold);
            a.setupArena();
            Square[][] b = a.getArena();
            graphics.GameBoard gb = new GameBoard(boardM,boardN,a); //make object from class in other package
            gb.run();
            GamerA A = new GamerA(goldBalance, detA, dstA);//balance(toplam alt??n say??s??),endTour(ad??m say??s?? sonu eksilcek alt??n,hedef belirleme maliyeti
            GamerB B = new GamerB(goldBalance,dstB,detB,boardN-1);//Buralar sat??r ve s??tun say??lar?? oldu??u i??in b??yle olacak.0'dan ba??l??yor.
            GamerC C = new GamerC(goldBalance,dstC,detC,boardM-1);
            GamerD D = new GamerD(goldBalance, dstD, detD, A, B, C, boardM-1, boardN-1);
            
            //setup first target
            A.findTarget(a);
            B.findTarget(a);
            //a.setnumOfSecretGold(C.openSecretGolds(a.getnumOfSecretGold(), b,gb));
            //a.settotalGold(a.getnumOfSecretGold()+a.getnumOfGold()); // buralar a????k kal??rsa s??f??r gizli gold ile oyun ba??l??yor
            C.findTarget(a);
            D.findTarget(a);
            int tourNum=1;
            
            while((A.getBalance() > 0 || B.getBalance() >0 || C.getBalance() > 0 || D.getBalance() > 0) && a.gettotalGold()!=0){
            try {
            //Oyun alan??nda alt??n kald?? m?? diye de kontrol yap??lmal??.
            Thread.sleep(2000);
            } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            System.out.println("\n"+tourNum+".tur A oyuncusu hareket ediyor!!!");
            if(A.getBalance() > 0){
            if(A.getCurrentLocation().get(0) == A.getTarget().get(0) && A.getCurrentLocation().get(1) == A.getTarget().get(1)){
            System.out.println("\nPlayer A");
            int balance = A.getBalance();
            balance = balance + A.getTargetGoldValue();
            A.findTarget(a);
            }
            
            A.move(a,gb);
            try {
            //Buraya Thread komuutu gelmeli.
            Thread.sleep(3000);
            } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(B.getBalance() > 0){
            System.out.println("\n"+tourNum+".tur B oyuncusu hareket ediyor!!!");
            if(B.getCurrentLocation().get(0) == B.getTarget().get(0) && B.getCurrentLocation().get(1) == B.getTarget().get(1)){
            System.out.println("\nPlayer B");
            int balance = B.getBalance();
            balance = balance + B.getTargetGoldValue();
            B.findTarget(a);
            }
            
            B.move(a,gb);
            try {
            //Buraya Thread komuutu gelmeli.
            Thread.sleep(3000);
            } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(C.getBalance() > 0){
            System.out.println("\n"+tourNum+".tur C oyuncusu hareket ediyor!!!");
            if(C.getCurrentLocation().get(0) == C.getTarget().get(0) && C.getCurrentLocation().get(1) == C.getTarget().get(1)){
            System.out.println("\nPlayer C");
            int balance = C.getBalance();
            balance = balance + C.getTargetGoldValue();
            C.setBalance(balance);
            C.findTarget(a);
            }
            
            C.move(a,gb);
            a.setnumOfSecretGold(C.openSecretGolds(a.getnumOfSecretGold(), b,gb));//Buras?? burda olmal?? ama tam emin degilim.Em mant??kl??s?? buras??
            a.settotalGold(a.getnumOfSecretGold()+a.getnumOfGold());
            try {
            //Buraya Thread komuutu gelmeli.
            Thread.sleep(3000);
            } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(D.getBalance() > 0){
            System.out.println("\n"+tourNum+".tur D oyuncusu hareket ediyor!!!");
            if(D.getCurrentLocation().get(0) == D.getTarget().get(0) && D.getCurrentLocation().get(1) == D.getTarget().get(1)){
            System.out.println("\nPlayer D");
            int balance = D.getBalance();
            balance = balance + D.getTargetGoldValue();
            D.findTarget(a);
            }
            
            D.move(a,gb);
            try {
            //Buraya Thread komuutu gelmeli.
            Thread.sleep(3000);
            } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            try {
            Thread.sleep(2000);
            } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            tourNum++;
            }
            JOptionPane.showMessageDialog(null,"Oyun Bitmi??tir!!!Oynad??????n??z i??in TE??EKK??RLER!!!","B??T????",JOptionPane.INFORMATION_MESSAGE);
            */
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }//GEN-LAST:event_PlayButtonPicMouseClicked

    private void OptionsButtonPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptionsButtonPicMouseClicked
        // TODO add your handling code here:
        //Open the options menu

        this.setVisible(false);
        op.setVisible(true);
        JOptionPane.showMessageDialog(null, "BoardM * BoardN can be 4000 maks");
    }//GEN-LAST:event_OptionsButtonPicMouseClicked

    private void ExitButtonPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonPicMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_ExitButtonPicMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ExitButtonPic;
    private javax.swing.JLabel GameBackgroundGif;
    private javax.swing.JLabel GameBackgroundPic;
    private javax.swing.JPanel GamePanel;
    private javax.swing.JLabel OptionsButtonPic;
    private javax.swing.JLabel PlayButtonPic;
    // End of variables declaration//GEN-END:variables
}
