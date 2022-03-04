/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import goldcatchgame.GameArena;
import goldcatchgame.Square;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author abdus
 */
public class GameBoard {
    //private JPanel contentPane;
	SquareButtons [][] board; // Kare'nin kenarı (e*e boyutunda olacak) buraya gelecek
        JFrame frame;
        Icon minerA = new ImageIcon("./src/pictures/minerA.JPEG");
        Icon minerB = new ImageIcon("./src/pictures/minerB.JPEG");
        Icon minerC = new ImageIcon("./src/pictures/minerC.JPEG");
        Icon minerD = new ImageIcon("./src/pictures/minerD.JPEG");
        Icon grass = new ImageIcon("./src/pictures/grass2.jpeg");
        Icon gold = new ImageIcon("./src/pictures/gold.JPEG");
        Icon secretGold = new ImageIcon("./src/pictures/secretGold.JPEG");
	public GameBoard() {
		board=new SquareButtons[5][5];
		frame=new JFrame("GameBoard");
		frame.setSize(1000,800); // M * N  buraya gelecek, 
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(5,5));//board boyutu ile aynı olmalı.Grid--->Hucre 
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				SquareButtons b=new SquareButtons(i,j);
				frame.add(b);
				board[i][j]=b;
			}
		}
		
	}
        
        public GameBoard(int row, int col, int edge) {
		board=new SquareButtons[edge][edge];
		frame=new JFrame("GameBoard");
		frame.setSize(row,col); // M * N  buraya gelecek, veya bunu daha güzelleştirmek için
                                        //boyutlardaki saçmalamayı engellemek için, panel ekleyip paneli değiştirelim
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(edge,edge));//board boyutu ile aynı olmalı.Grid--->Hucre 
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				SquareButtons b=new SquareButtons(i,j);
				frame.add(b);
				board[i][j]=b;
			}
		}
		
	}
        public GameBoard(int row, int col, GameArena g) {
        Square[][] s = g.getArena();
        /*Icon minerA = new ImageIcon("./src/pictures/minerA.JPEG");
        Icon minerB = new ImageIcon("./src/pictures/minerB.JPEG");
        Icon minerC = new ImageIcon("./src/pictures/minerC.JPEG");
        Icon minerD = new ImageIcon("./src/pictures/minerD.JPEG");
        Icon grass = new ImageIcon("./src/pictures/grass2.jpeg");
        Icon gold = new ImageIcon("./src/pictures/gold.JPEG");
        Icon secretGold = new ImageIcon("./src/pictures/secretGold.JPEG");
        */
        board = new SquareButtons[g.getRow()][g.getCol()];
        frame = new JFrame("GameBoard");
        frame.setSize(row, col); // M * N  buraya gelecek, veya bunu daha güzelleştirmek için
        //boyutlardaki saçmalamayı engellemek için, panel ekleyip paneli değiştirelim
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(g.getRow(), g.getCol()));//board boyutu ile aynı olmalı.Grid--->Hucre 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                SquareButtons b = new SquareButtons(i, j);
                frame.add(b);
                board[i][j] = b;
            }
        }
       
        
       for(int i = 0 ; i<s.length;i++){
            for(int j=0; j<s[0].length;j++){
                if (s[i][j].ishaveSecretGold()) {
                    board[i][j].setIcon(secretGold);
                } else if (s[i][j].isHaveGold()) {
                    board[i][j].setIcon(gold);
                } else {
                    board[i][j].setIcon(grass);
                }
               
            }
        }
        board[0][0].setIcon(minerA);
        board[0][g.getCol()-1].setIcon(minerB);
        board[g.getRow()-1][0].setIcon(minerC);
        board[g.getRow()-1][g.getCol()-1].setIcon(minerD);
    }
    public GameBoard(int i, int i0, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public void run(){
            frame.setVisible(true);// ekte olması işimizi kolaylaştırır
        }
    public SquareButtons [][] getboard(){
        return board;
    }
    public void setboard(SquareButtons [][] board){
        this.board=board;
    }
     public Icon getminerA(){
            return minerA;
        }
       public void setminerA(Icon minerA){
           this.minerA=minerA;
             
       }
        public Icon getminerB(){
            return minerB;
        }
       public void setminerB(Icon minerB){
           this.minerB=minerB;
             
       }
        public Icon getminerC(){
            return minerC;
        }
       public void setminerC(Icon minerC){
           this.minerC=minerC;
             
       }
        public Icon getminerD(){
            return minerD;
        }
       public void setminerD(Icon minerD){
           this.minerD=minerD;
             
       }
        public Icon getgrass(){
            return grass;
        }
       public void setgrass(Icon grass){
           this.grass=grass;
             
       }
        public Icon getgold(){
            return gold;
        }
       public void setgold(Icon gold){
           this.gold=gold;
             
       }
        public Icon getsecretGold(){
            return secretGold;
        }
       public void setsecretGold(Icon secretGold){
           this.secretGold=secretGold;
             
       }
}
