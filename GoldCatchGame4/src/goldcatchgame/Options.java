/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldcatchgame;


import javax.swing.JOptionPane;

/**
 *
 * @author abdus
 */
public class Options extends javax.swing.JFrame {

    /**
     * Creates new form Options
     */
    public Options() {
        initComponents();
        setDefault();
        setAllData();
        getAllData();
    }
    Menu menu;

    public Options(Menu menu) {
        this.menu = menu;
        initComponents();
        setDefault();
        setAllData();
        getAllData();
        
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //Data variables : 
    int boardM, boardN, numOfSquare, goldBalance, numOfStep, perGold, perSecretGold,
            dstA, dstB, dstC, dstD,// dst,ABCD, => Decrease TargetSelection
            detA, detB, detC, detD;// det,ABCD, => Decrease End of Tour
    int squareSize;

    private void setDefault() {
        boardM = 20;
        boardN = 10;
        numOfSquare = boardM*boardN;
        squareSize = (int) Math.sqrt(( 1368 *768 )/numOfSquare);
        goldBalance = 200;
        numOfStep = 3;
        perGold = 20;
        perSecretGold = 10;
        detA = 5;
        detB = 5;
        detC = 5;
        detD = 5;
        dstA = 5;
        dstB = 10;
        dstC = 15;
        dstD = 20;
    }

    private void getAllData() {
        boardM = Integer.parseInt(mInput.getText());
        boardN = Integer.parseInt(nInput.getText());
        numOfSquare = boardM * boardN;
        squareSize = boardM*boardN;
        
        //numOfSquare = Integer.parseInt(nsInput.getText()); Görselde herzaman kenarının karesi olduğu için iptal edildi
        
        /*double squareEdge = Math.sqrt((boardM * boardN) / numOfSquare);
        squareEdge = Math.floor(squareEdge * 100) / 100;
        eInput.setText(Double.toString(squareEdge));
        squareSize = Double.parseDouble(eInput.getText());*/ // Matematik mantığından dolayı iptal edildi
        
        perGold = Integer.parseInt(percentG.getText());
        perSecretGold = Integer.parseInt(percentSG.getText());
        goldBalance = Integer.parseInt(sgbInput.getText());
        numOfStep = Integer.parseInt(nsrInput.getText());

        dstA = Integer.parseInt(AdstInput.getText());
        dstB = Integer.parseInt(BdstInput.getText());
        dstC = Integer.parseInt(CdstInput.getText());
        dstD = Integer.parseInt(DdstInput.getText());

        detA = Integer.parseInt(AdetInput.getText());
        detB = Integer.parseInt(BdetInput.getText());
        detC = Integer.parseInt(CdetInput.getText());
        detD = Integer.parseInt(DdetInput.getText());
    }

    private void setAllData() {
        mInput.setText(Integer.toString(boardM));
        nInput.setText(Integer.toString(boardN));
        eInput.setText(Integer.toString((int)Math.sqrt(boardM*boardN)));
        nsInput.setText(Integer.toString(boardM*boardN));
        percentG.setText(Integer.toString(perGold));
        percentSG.setText(Integer.toString(perSecretGold));
        sgbInput.setText(Integer.toString(goldBalance));
        nsrInput.setText(Integer.toString(numOfStep));

        AdstInput.setText(Integer.toString(dstA));
        BdstInput.setText(Integer.toString(dstB));
        CdstInput.setText(Integer.toString(dstC));
        DdstInput.setText(Integer.toString(dstD));

        AdetInput.setText(Integer.toString(detA));
        BdetInput.setText(Integer.toString(detB));
        CdetInput.setText(Integer.toString(detC));
        DdetInput.setText(Integer.toString(detD));
    }

    private boolean checkData() {
        if (isInteger(mInput.getText()) == false) {
            return false;
        }
        if (isInteger(nInput.getText()) == false) {
            return false;
        }
        if (isDouble(eInput.getText()) == false) {
            return false;
        }
        if (isInteger(nsInput.getText()) == false) {
            return false;
        }
        if (isInteger(percentG.getText()) == false) {
            return false;
        }
        if (isInteger(percentG.getText()) == false) {
            return false;
        }
        if (isInteger(sgbInput.getText()) == false) {
            return false;
        }
        if (isInteger(nsrInput.getText()) == false) {
            return false;
        }
        if (isInteger(AdstInput.getText()) == false) {
            return false;
        }
        if (isInteger(BdstInput.getText()) == false) {
            return false;
        }
        if (isInteger(CdstInput.getText()) == false) {
            return false;
        }
        if (isInteger(DdstInput.getText()) == false) {
            return false;
        }
        if (isInteger(AdetInput.getText()) == false) {
            return false;
        }
        if (isInteger(BdetInput.getText()) == false) {
            return false;
        }
        if (isInteger(CdetInput.getText()) == false) {
            return false;
        }
        if (isInteger(DdetInput.getText()) == false) {
            return false;
        }
        return true;
    }


    public int getBoardM() {
        return boardM;
    }

    public void setBoardM(int boardM) {
        this.boardM = boardM;
    }

    public int getBoardN() {
        return boardN;
    }

    public void setBoardN(int boardN) {
        this.boardN = boardN;
    }

    public int getNumOfSquare() {
        return numOfSquare;
    }

    public void setNumOfSquare(int numOfSquare) {
        this.numOfSquare = numOfSquare;
    }

    public int getGoldBalance() {
        return goldBalance;
    }

    public void setGoldBalance(int goldBalance) {
        this.goldBalance = goldBalance;
    }

    public int getNumOfStep() {
        return numOfStep;
    }

    public void setNumOfStep(int numOfStep) {
        this.numOfStep = numOfStep;
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

    public int getDstA() {
        return dstA;
    }

    public void setDstA(int dstA) {
        this.dstA = dstA;
    }

    public int getDstB() {
        return dstB;
    }

    public void setDstB(int dstB) {
        this.dstB = dstB;
    }

    public int getDstC() {
        return dstC;
    }

    public void setDstC(int dstC) {
        this.dstC = dstC;
    }

    public int getDstD() {
        return dstD;
    }

    public void setDstD(int dstD) {
        this.dstD = dstD;
    }

    public int getDetA() {
        return detA;
    }

    public void setDetA(int detA) {
        this.detA = detA;
    }

    public int getDetB() {
        return detB;
    }

    public void setDetB(int detB) {
        this.detB = detB;
    }

    public int getDetC() {
        return detC;
    }

    public void setDetC(int detC) {
        this.detC = detC;
    }

    public int getDetD() {
        return detD;
    }

    public void setDetD(int detD) {
        this.detD = detD;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OptionsPanel = new javax.swing.JPanel();
        GameBoardSize = new javax.swing.JLabel();
        xLabel = new javax.swing.JLabel();
        mInput = new javax.swing.JTextField();
        nInput = new javax.swing.JTextField();
        SquareSize = new javax.swing.JLabel();
        eInput = new javax.swing.JTextField();
        NumberOfSquare = new javax.swing.JLabel();
        nsInput = new javax.swing.JTextField();
        AmountOfGold = new javax.swing.JLabel();
        perSymbol0 = new javax.swing.JLabel();
        percentG = new javax.swing.JTextField();
        AmountOfSecretGold = new javax.swing.JLabel();
        perSymbol1 = new javax.swing.JLabel();
        percentSG = new javax.swing.JTextField();
        StartingGoldBalance = new javax.swing.JLabel();
        sgbInput = new javax.swing.JTextField();
        NumberOfStep = new javax.swing.JLabel();
        nsrInput = new javax.swing.JTextField();
        GamerD = new javax.swing.JLabel();
        GamerC = new javax.swing.JLabel();
        GamerB = new javax.swing.JLabel();
        GamerA = new javax.swing.JLabel();
        DecraseSelectionTarget = new javax.swing.JLabel();
        AdstInput = new javax.swing.JTextField();
        BdstInput = new javax.swing.JTextField();
        CdstInput = new javax.swing.JTextField();
        DdstInput = new javax.swing.JTextField();
        DecraseEndOfTour = new javax.swing.JLabel();
        AdetInput = new javax.swing.JTextField();
        BdetInput = new javax.swing.JTextField();
        CdetInput = new javax.swing.JTextField();
        DdetInput = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        BackgroundGif = new javax.swing.JLabel();
        SaveButton = new javax.swing.JLabel();
        CancelButtonPic = new javax.swing.JLabel();
        OptionsViewPic = new javax.swing.JLabel();
        OptionsBacgroundPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OptionsPanel.setPreferredSize(new java.awt.Dimension(1135, 944));
        OptionsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GameBoardSize.setBackground(new java.awt.Color(255, 255, 255));
        GameBoardSize.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        GameBoardSize.setForeground(new java.awt.Color(255, 69, 0));
        GameBoardSize.setText("GameBoard Size (m*n) :");
        OptionsPanel.add(GameBoardSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 230, -1));

        xLabel.setBackground(new java.awt.Color(255, 255, 255));
        xLabel.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        xLabel.setForeground(new java.awt.Color(255, 69, 0));
        xLabel.setText(" *");
        OptionsPanel.add(xLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 30, 20));

        mInput.setBackground(new java.awt.Color(255, 223, 0));
        mInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mInput.setForeground(new java.awt.Color(0, 0, 0));
        mInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mInput.setText("m");
        mInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(mInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 60, -1));

        nInput.setBackground(new java.awt.Color(255, 223, 0));
        nInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nInput.setForeground(new java.awt.Color(0, 0, 0));
        nInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nInput.setText("n");
        nInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nInputActionPerformed(evt);
            }
        });
        OptionsPanel.add(nInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 60, -1));

        SquareSize.setBackground(new java.awt.Color(255, 255, 255));
        SquareSize.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        SquareSize.setForeground(new java.awt.Color(255, 69, 0));
        SquareSize.setText("Square Size (e*e) (non-editable):");
        OptionsPanel.add(SquareSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        eInput.setEditable(false);
        eInput.setBackground(new java.awt.Color(255, 223, 0));
        eInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        eInput.setForeground(new java.awt.Color(0, 0, 0));
        eInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eInput.setText("e");
        eInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(eInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 60, -1));

        NumberOfSquare.setBackground(new java.awt.Color(255, 255, 255));
        NumberOfSquare.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        NumberOfSquare.setForeground(new java.awt.Color(255, 69, 0));
        NumberOfSquare.setText("Number of Square (non-editable):");
        OptionsPanel.add(NumberOfSquare, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));

        nsInput.setBackground(new java.awt.Color(255, 223, 0));
        nsInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nsInput.setForeground(new java.awt.Color(0, 0, 0));
        nsInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nsInput.setText("ns");
        nsInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nsInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nsInputMouseClicked(evt);
            }
        });
        nsInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nsInputKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nsInputKeyReleased(evt);
            }
        });
        OptionsPanel.add(nsInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 60, -1));

        AmountOfGold.setBackground(new java.awt.Color(255, 255, 255));
        AmountOfGold.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        AmountOfGold.setForeground(new java.awt.Color(255, 69, 0));
        AmountOfGold.setText("Amount of Gold (%g) : ");
        OptionsPanel.add(AmountOfGold, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        perSymbol0.setBackground(new java.awt.Color(255, 255, 255));
        perSymbol0.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        perSymbol0.setForeground(new java.awt.Color(255, 69, 0));
        perSymbol0.setText("%");
        OptionsPanel.add(perSymbol0, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        percentG.setBackground(new java.awt.Color(255, 223, 0));
        percentG.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        percentG.setForeground(new java.awt.Color(0, 0, 0));
        percentG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentG.setText("g");
        percentG.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(percentG, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 60, -1));

        AmountOfSecretGold.setBackground(new java.awt.Color(255, 255, 255));
        AmountOfSecretGold.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        AmountOfSecretGold.setForeground(new java.awt.Color(255, 69, 0));
        AmountOfSecretGold.setText("Amount of Secret Gold (%g) : ");
        OptionsPanel.add(AmountOfSecretGold, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 280, 30));

        perSymbol1.setBackground(new java.awt.Color(255, 255, 255));
        perSymbol1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        perSymbol1.setForeground(new java.awt.Color(255, 69, 0));
        perSymbol1.setText("%");
        OptionsPanel.add(perSymbol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, -1, -1));

        percentSG.setBackground(new java.awt.Color(255, 223, 0));
        percentSG.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        percentSG.setForeground(new java.awt.Color(0, 0, 0));
        percentSG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentSG.setText("sg");
        percentSG.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        percentSG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentSGActionPerformed(evt);
            }
        });
        OptionsPanel.add(percentSG, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 60, 30));

        StartingGoldBalance.setBackground(new java.awt.Color(255, 255, 255));
        StartingGoldBalance.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        StartingGoldBalance.setForeground(new java.awt.Color(255, 69, 0));
        StartingGoldBalance.setText("Starting Gold Balance : ");
        OptionsPanel.add(StartingGoldBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        sgbInput.setBackground(new java.awt.Color(255, 223, 0));
        sgbInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sgbInput.setForeground(new java.awt.Color(0, 0, 0));
        sgbInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sgbInput.setText("sgb");
        sgbInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(sgbInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 60, -1));

        NumberOfStep.setBackground(new java.awt.Color(255, 255, 255));
        NumberOfStep.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        NumberOfStep.setForeground(new java.awt.Color(255, 69, 0));
        NumberOfStep.setText("Number Of Step in A Round : ");
        OptionsPanel.add(NumberOfStep, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 280, -1));

        nsrInput.setBackground(new java.awt.Color(255, 223, 0));
        nsrInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nsrInput.setForeground(new java.awt.Color(0, 0, 0));
        nsrInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nsrInput.setText("nsR");
        nsrInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(nsrInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 60, -1));

        GamerD.setBackground(new java.awt.Color(255, 255, 255));
        GamerD.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        GamerD.setForeground(new java.awt.Color(255, 99, 71));
        GamerD.setText("Gamer D");
        OptionsPanel.add(GamerD, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, -1, 30));

        GamerC.setBackground(new java.awt.Color(255, 255, 255));
        GamerC.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        GamerC.setForeground(new java.awt.Color(255, 99, 71));
        GamerC.setText("Gamer C");
        OptionsPanel.add(GamerC, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, -1, 30));

        GamerB.setBackground(new java.awt.Color(255, 255, 255));
        GamerB.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        GamerB.setForeground(new java.awt.Color(255, 99, 71));
        GamerB.setText("Gamer B");
        OptionsPanel.add(GamerB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, 30));

        GamerA.setBackground(new java.awt.Color(255, 255, 255));
        GamerA.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        GamerA.setForeground(new java.awt.Color(255, 99, 71));
        GamerA.setText("Gamer A");
        OptionsPanel.add(GamerA, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        DecraseSelectionTarget.setBackground(new java.awt.Color(255, 255, 255));
        DecraseSelectionTarget.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        DecraseSelectionTarget.setForeground(new java.awt.Color(255, 69, 0));
        DecraseSelectionTarget.setText("Decrease Amount of Target Selection ->");
        OptionsPanel.add(DecraseSelectionTarget, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, -1, -1));

        AdstInput.setBackground(new java.awt.Color(255, 223, 0));
        AdstInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AdstInput.setForeground(new java.awt.Color(0, 0, 0));
        AdstInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AdstInput.setText("Amount of A");
        AdstInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(AdstInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 110, -1));

        BdstInput.setBackground(new java.awt.Color(255, 223, 0));
        BdstInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BdstInput.setForeground(new java.awt.Color(0, 0, 0));
        BdstInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BdstInput.setText("Amount of B");
        BdstInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(BdstInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 110, -1));

        CdstInput.setBackground(new java.awt.Color(255, 223, 0));
        CdstInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CdstInput.setForeground(new java.awt.Color(0, 0, 0));
        CdstInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CdstInput.setText("Amount of C");
        CdstInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(CdstInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, 110, -1));

        DdstInput.setBackground(new java.awt.Color(255, 223, 0));
        DdstInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DdstInput.setForeground(new java.awt.Color(0, 0, 0));
        DdstInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DdstInput.setText("Amount of D");
        DdstInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(DdstInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 110, -1));

        DecraseEndOfTour.setBackground(new java.awt.Color(255, 255, 255));
        DecraseEndOfTour.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        DecraseEndOfTour.setForeground(new java.awt.Color(255, 69, 0));
        DecraseEndOfTour.setText("Decrease Amount of End of Tour        ->");
        OptionsPanel.add(DecraseEndOfTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, -1, -1));

        AdetInput.setBackground(new java.awt.Color(255, 223, 0));
        AdetInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AdetInput.setForeground(new java.awt.Color(0, 0, 0));
        AdetInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AdetInput.setText("Amount of A");
        AdetInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(AdetInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 110, -1));

        BdetInput.setBackground(new java.awt.Color(255, 223, 0));
        BdetInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BdetInput.setForeground(new java.awt.Color(0, 0, 0));
        BdetInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BdetInput.setText("Amount of B");
        BdetInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(BdetInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 590, 110, -1));

        CdetInput.setBackground(new java.awt.Color(255, 223, 0));
        CdetInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CdetInput.setForeground(new java.awt.Color(0, 0, 0));
        CdetInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CdetInput.setText("Amount of C");
        CdetInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(CdetInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 110, -1));

        DdetInput.setBackground(new java.awt.Color(255, 223, 0));
        DdetInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DdetInput.setForeground(new java.awt.Color(0, 0, 0));
        DdetInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DdetInput.setText("Amount of D");
        DdetInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OptionsPanel.add(DdetInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 110, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator1.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 10, 70));

        jSeparator2.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator2.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 10, 70));

        jSeparator3.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator3.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 10, 70));

        jSeparator4.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator4.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 10, 70));

        jSeparator5.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator5.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 590, 10, 70));

        jSeparator6.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator6.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator6.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 10, 70));

        jSeparator7.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator7.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, 10, 70));

        jSeparator8.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator8.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator8.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator8.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 10, 70));

        jSeparator9.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator9.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator9.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator9.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 10, 110));

        jSeparator10.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator10.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator10.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator10.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 10, 110));

        jSeparator11.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator11.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator11.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator11.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 10, 110));

        jSeparator12.setBackground(new java.awt.Color(255, 91, 71));
        jSeparator12.setForeground(new java.awt.Color(255, 91, 71));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator12.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        jSeparator12.setPreferredSize(new java.awt.Dimension(50, 50));
        OptionsPanel.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 10, 110));

        BackgroundGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/SettingsBackground.gif"))); // NOI18N
        OptionsPanel.add(BackgroundGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 700, 400));

        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Save-as-icon.png"))); // NOI18N
        SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButtonMouseClicked(evt);
            }
        });
        OptionsPanel.add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 710, 70, 70));

        CancelButtonPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/cancel.png"))); // NOI18N
        CancelButtonPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonPicMouseClicked(evt);
            }
        });
        OptionsPanel.add(CancelButtonPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 710, 70, 70));

        OptionsViewPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Settings-icon.png"))); // NOI18N
        OptionsPanel.add(OptionsViewPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 710, 60, -1));

        OptionsBacgroundPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/OptionsBackgroundPic.PNG"))); // NOI18N
        OptionsPanel.add(OptionsBacgroundPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(OptionsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonPicMouseClicked
        // TODO add your handling code here:
        //set Default settings
        JOptionPane.showMessageDialog(null, "Canceled, return to default settings");
        setDefault();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_CancelButtonPicMouseClicked

    private void nInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nInputActionPerformed

    private void percentSGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentSGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_percentSGActionPerformed

    private void SaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseClicked
        // TODO add your handling code here:
        // Check the data if there is correct data save it, or ask to refill or show a pop up message and set default settings
        if (checkData()) {
            getAllData();
            setAllData();
            JOptionPane.showMessageDialog(null, "Succesfully Saved");
            this.setVisible(false);
            menu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Entered values ​​are incorrect,\n "
                    + "Please Enter correct values ");
        }

    }//GEN-LAST:event_SaveButtonMouseClicked

    private void nsInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nsInputKeyReleased
    }//GEN-LAST:event_nsInputKeyReleased

    private void nsInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nsInputKeyPressed
    }//GEN-LAST:event_nsInputKeyPressed

    private void nsInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nsInputMouseClicked
    }//GEN-LAST:event_nsInputMouseClicked

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
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdetInput;
    private javax.swing.JTextField AdstInput;
    private javax.swing.JLabel AmountOfGold;
    private javax.swing.JLabel AmountOfSecretGold;
    private javax.swing.JLabel BackgroundGif;
    private javax.swing.JTextField BdetInput;
    private javax.swing.JTextField BdstInput;
    private javax.swing.JLabel CancelButtonPic;
    private javax.swing.JTextField CdetInput;
    private javax.swing.JTextField CdstInput;
    private javax.swing.JTextField DdetInput;
    private javax.swing.JTextField DdstInput;
    private javax.swing.JLabel DecraseEndOfTour;
    private javax.swing.JLabel DecraseSelectionTarget;
    private javax.swing.JLabel GameBoardSize;
    private javax.swing.JLabel GamerA;
    private javax.swing.JLabel GamerB;
    private javax.swing.JLabel GamerC;
    private javax.swing.JLabel GamerD;
    private javax.swing.JLabel NumberOfSquare;
    private javax.swing.JLabel NumberOfStep;
    private javax.swing.JLabel OptionsBacgroundPic;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.JLabel OptionsViewPic;
    private javax.swing.JLabel SaveButton;
    private javax.swing.JLabel SquareSize;
    private javax.swing.JLabel StartingGoldBalance;
    private javax.swing.JTextField eInput;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField mInput;
    private javax.swing.JTextField nInput;
    private javax.swing.JTextField nsInput;
    private javax.swing.JTextField nsrInput;
    private javax.swing.JLabel perSymbol0;
    private javax.swing.JLabel perSymbol1;
    private javax.swing.JTextField percentG;
    private javax.swing.JTextField percentSG;
    private javax.swing.JTextField sgbInput;
    private javax.swing.JLabel xLabel;
    // End of variables declaration//GEN-END:variables
}
