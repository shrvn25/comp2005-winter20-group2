

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseDisplayGUI extends JFrame implements ActionListener{
    //Instance Variables
    private Container mainPane;
    private JButton startButton;
    private JPanel buttonPanel, informationPanel, playerPanel, boardPanel, difficultyPanel;
    private JLabel infoMessage, difficulty, board, humanPlayerLabel, player1Label, player2Label, player3Label, player4Label;
    private JRadioButton simpleRadioButton, complexRadioButton, easyRadioButton, hardRadioButton;
    private ButtonGroup boardTypes, difficultyRadioButtons;
    private JComboBox<String> playerList2ComboBox, playerList3ComboBox, playerList4ComboBox;
    private GameSettings gameSettings;


    //Constructor
    public ChooseDisplayGUI(){

        gameSettings = new GameSettings();
        
        getContentPane().setBackground(Color.WHITE);
        mainPane = getContentPane();
        mainPane.setPreferredSize(new Dimension(800,800));
        mainPane.setLayout(new GridLayout(5,1));
        
        

        //Board Style
        simpleRadioButton = new JRadioButton("Simple");
        complexRadioButton = new JRadioButton("Complex");


        //Making the board panel
        boardPanel= new JPanel();
        boardPanel.setBackground(Color.WHITE);
        board= new JLabel("Please Choose a board type: ");
        boardTypes= new ButtonGroup();
        
       
        boardPanel.add(board);
        boardPanel.add(simpleRadioButton);
        boardPanel.add(complexRadioButton);
        boardTypes.add(simpleRadioButton);
        boardTypes.add(complexRadioButton);
        mainPane.add(boardPanel);

        //Making the player panel
        

        playerPanel= new JPanel(new GridLayout(6,2));
        playerPanel.setBackground(Color.WHITE);
        playerList2ComboBox = new JComboBox<String>();
        playerList2ComboBox.addItem("Human Player");
        playerList2ComboBox.addItem("Computer Player");
        
        playerList3ComboBox = new JComboBox<String>();
        playerList3ComboBox.addItem("Human Player");
        playerList3ComboBox.addItem("Computer Player");
        
        playerList4ComboBox = new JComboBox<String>();
        playerList4ComboBox.addItem("Human Player");
        playerList4ComboBox.addItem("Computer Player");


        playerList2ComboBox.setSelectedIndex(0);//Default HUMAN (march 14)
        playerList3ComboBox.setSelectedIndex(0);//Default HUMAN (march 14)
        playerList4ComboBox.setSelectedIndex(0);//Default HUMAN (march 14)

        //Labels for the Number of Players
        player1Label = new JLabel("Player 1:     Red Robot");
        humanPlayerLabel = new JLabel("Human Player");
        player2Label = new JLabel("Player 2:     Green Square");
        player3Label = new JLabel("Player 3:     Yellow Circle");
        player4Label = new JLabel("Player 4:     Blue Moon");
        

        //Adding all the components
        playerPanel.add(player1Label);
        playerPanel.add(humanPlayerLabel);
        playerPanel.add(player2Label);
        playerPanel.add(playerList2ComboBox);
        playerPanel.add(player3Label);
        playerPanel.add(playerList3ComboBox);
        playerPanel.add(player4Label);
        playerPanel.add(playerList4ComboBox);


        mainPane.add(playerPanel);
        
        
          
        //Make the Difficulty panel
        difficultyPanel= new JPanel();
        difficultyPanel.setBackground(Color.WHITE);
        difficultyRadioButtons= new ButtonGroup();
        difficulty= new JLabel("Please select the difficulty of the computer player (if any): ");
        easyRadioButton = new JRadioButton("Easy");
        hardRadioButton = new JRadioButton("Hard");
        difficultyRadioButtons.add(easyRadioButton);
        difficultyRadioButtons.add(hardRadioButton);
        difficultyPanel.add(difficulty);
        difficultyPanel.add(easyRadioButton);
        difficultyPanel.add(hardRadioButton);

        mainPane.add(difficultyPanel);
        
        //Make the button label
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        startButton= new JButton("Start");
        startButton.addActionListener(this);
        buttonPanel.add(startButton);
        mainPane.add(buttonPanel);


        //Pack and make visible
        pack();
        setVisible(true);
        
    }

    //Methods
    
    public void actionPerformed(ActionEvent e){
        Object event = e.getSource();
        if(event == startButton){
            super.dispose();
            GameBoard gameboard= new GameBoard(16,16);

        }
        else if (event == simpleRadioButton){
            gameSettings.setSimpleBoardType();
        }
        else if (event == complexRadioButton){
            gameSettings.setComplexBoardType();
        }
        else if (event == easyRadioButton){
            gameSettings.setEasyDifficulty();
        }
        else if (event == hardRadioButton){
            gameSettings.setHardDifficulty();
        }
        else if (event == playerList2ComboBox){
            if (playerList2ComboBox.getSelectedIndex() == 0){
                gameSettings.setPlayer2PlayerType("HUMAN");
            }
            else if (playerList2ComboBox.getSelectedIndex() == 1){
                gameSettings.setPlayer2PlayerType("COMPUTER");
            }
        }
        else if (event == playerList3ComboBox){
            if (playerList3ComboBox.getSelectedIndex() == 0) {
                gameSettings.setPlayer3PlayerType("HUMAN");
            }
            else if (playerList3ComboBox.getSelectedIndex() == 1){
                gameSettings.setPlayer3PlayerType("COMPUTER");
            }
        }
        else if (event == playerList4ComboBox){
            if (playerList4ComboBox.getSelectedIndex() == 0){
                gameSettings.setPlayer4PlayerType("HUMAN");
            }
            else if (playerList4ComboBox.getSelectedIndex() == 1){
                gameSettings.setPlayer4PlayerType("COMPUTER");
            }
        }
    }



}

