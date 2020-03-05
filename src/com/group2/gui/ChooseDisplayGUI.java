package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChooseDisplayGUI extends JFrame{
    //Instance Variables
    private Container mainPane;
    private JButton startButton;
    private JPanel buttonPanel, informationPanel, playerPanel, boardPanel;
    private JLabel infoMessage, difficulty, board,humanPlayer, player1, player2, player3, player4;
    private JRadioButton simple, complex;
    private JComboBox<String> playerList,playerList2,playerList3;


    //Constructor
    public ChooseDisplayGUI(){
        super();

        mainPane = getContentPane();
        mainPane.setPreferredSize(new Dimension(500,500));
        mainPane.setLayout(new GridLayout(5,1));
        
        

        //Board Style
        simple= new JRadioButton("Simple");
        complex= new JRadioButton("Complex");

    

        
        //TODO Add listeners to buttons

        //Make the information label
        infoMessage = new JLabel("Please choose a simple display or a complex display.");
        informationPanel = new JPanel();
        informationPanel.add(infoMessage);
        mainPane.add(informationPanel);

        
        //Making the board panel
        boardPanel= new JPanel();
        board= new JLabel("Board Type");

        boardPanel.add(board);
        boardPanel.add(simple);
        boardPanel.add(complex);
        mainPane.add(boardPanel);

        //Making the player panel
        

        playerPanel= new JPanel(new GridLayout(6,2));
        playerList= new JComboBox<String>();
        playerList.addItem("Human Player");
        playerList.addItem("Computer Player");
        
        playerList2= new JComboBox<String>();
        playerList2.addItem("Human Player");
        playerList2.addItem("Computer Player");
        
        playerList3= new JComboBox<String>();
        playerList3.addItem("Human Player");
        playerList3.addItem("Computer Player");

        playerList.setSelectedIndex(0);
        playerList2.setSelectedIndex(0);
        playerList3.setSelectedIndex(0);

        player1= new JLabel("Player 1: ");
        humanPlayer= new JLabel("Human Player");
        player2= new JLabel("Player 2: ");
        player3= new JLabel("Player 3: ");
        player4= new JLabel("Player 4: ");

        playerPanel.add(player1);
        playerPanel.add(humanPlayer);
        playerPanel.add(player2);
        playerPanel.add(playerList);
        playerPanel.add(player3);
        playerPanel.add(playerList2);
        playerPanel.add(player4);
        playerPanel.add(playerList3);

        mainPane.add(playerPanel);
        
        
          

        
        //Make the button label
        buttonPanel = new JPanel();
        startButton= new JButton("Start");
        
        buttonPanel.add(startButton);
        mainPane.add(buttonPanel);


        //Pack and make visible
        pack();
        setVisible(true);
        
    }

    //Methods

}

