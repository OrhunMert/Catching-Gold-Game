/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author abdus
 */
public class SquareButtons extends JButton{ // JButton or another things can use who have border
    private int rowNum,colNum;
    private Icon icon;
	SquareButtons(int row,int col, Icon icon){
		super();
                this.icon = icon;
                this.setIcon(this.icon);
		this.rowNum=row;
		this.colNum=col;
                //this.setEnabled(false);// unable to click able
	}
        SquareButtons(int row,int col){
		super();
		this.rowNum=row;
		this.colNum=col;
                //this.setEnabled(false);// unable to click able
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getColNum() {
		return colNum;
	}
	public void setColNum(int colNum) {
		this.colNum = colNum;
	}   
        public Icon geticon(){
            return icon;
        }
       public void seticon(Icon icon){
           this.icon=icon;
             
       }
}
