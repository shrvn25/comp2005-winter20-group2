package gui;

import com.group2.gui.GameSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SetupPlayersGUI extends JFrame implements ActionListener{
    //Instance Variables
    private Container mainPane;
    private JButton startButton;
    private JPanel buttonPanel, informationPanel, playerPanel, boardPanel, difficultyPanel;
    private JLabel infoMessage, difficulty, board,humanPlayer, player1, player2, player3, player4;
    private JRadioButton simpleBoardRadioButton, complexBoardRadioButton, easy, hard;
    private ButtonGroup boardTypes, difficultyRadioButtons;
    private JComboBox<String> player2ComboBox, player3ComboBox, player4ComboBox;


    //Constructor
    public SetupPlayersGUI(){

        //First create the GameSettings object so it can record stuff.

        GameSettings newGameSettings = new GameSettings(); //The default is all human players, easy mode and simple board.
        
        //getContentPane().setBackground(Color.CYAN);//Can change colour later.
        mainPane = getContentPane();
        mainPane.setPreferredSize(new Dimension(1000,1000));
        mainPane.setLayout(new GridLayout(5,1));


        //TODO change defaults to human player.
        

        //Board Choice Buttons
        simpleBoardRadioButton = new JRadioButton("Simple");
        complexBoardRadioButton = new JRadioButton("Complex");

        //TODO Add listeners to buttons
        simpleBoardRadioButton.addActionListener( e -> newGameSettings.setBoardType(0));
        complexBoardRadioButton.addActionListener( e -> newGameSettings.setBoardType(1));

        
      
        


        //Making the board panel
        boardPanel= new JPanel();
        //boardPanel.setBackground(Color.CYAN);//Can change colour later.
        board= new JLabel("Please choose a board type: ");
        boardTypes= new ButtonGroup();
        
       
        boardPanel.add(board);
        boardPanel.add(simpleBoardRadioButton);
        boardPanel.add(complexBoardRadioButton);
        boardTypes.add(simpleBoardRadioButton);
        boardTypes.add(complexBoardRadioButton);
        mainPane.add(boardPanel);

        //Making the player panel
        

        playerPanel= new JPanel(new GridLayout(6,2));
        //playerPanel.setBackground(Color.YELLOW);//Change colour later.
        player2ComboBox = new JComboBox<String>();
        player2ComboBox.addItem("Human Player");
        player2ComboBox.addItem("Computer Player");


        player3ComboBox = new JComboBox<String>();
        player3ComboBox.addItem("Human Player");
        player3ComboBox.addItem("Computer Player");
        
        player4ComboBox = new JComboBox<String>();
        player4ComboBox.addItem("Human Player");
        player4ComboBox.addItem("Computer Player");

        //Add Action Listeners to this JComboBoxes //TODO THIS RIGHT SPOT BEFORE SETSELECTEDINDEX?

        player2ComboBox


        player2ComboBox.setSelectedIndex(0);//Changed to HUMAN
        player3ComboBox.setSelectedIndex(0);//Changed to HUMAN
        player4ComboBox.setSelectedIndex(0);//Changed to HUMAN

        //Labels for the Number of Players
        player1= new JLabel("Player 1:     Red Robot with Star");
        humanPlayer= new JLabel("Human Player");
        player2= new JLabel("Player 2:     Green Robot with Square");
        player3= new JLabel("Player 3:     Yellow Robot with Circle");
        player4= new JLabel("Player 4:     Blue Robot with Half Moon");






        //Adding all the components
        playerPanel.add(player1);
        playerPanel.add(humanPlayer);
        playerPanel.add(player2);
        playerPanel.add(player2ComboBox);
        playerPanel.add(player3);
        playerPanel.add(player3ComboBox);
        playerPanel.add(player4);
        playerPanel.add(player4ComboBox);


        mainPane.add(playerPanel);
        
        
          
        //Make the Difficulty panel
        difficultyPanel= new JPanel();
        //difficultyPanel.setBackground(Color.YELLOW);//Change colour later.
        difficultyRadioButtons= new ButtonGroup();
        difficulty= new JLabel("Please select the difficulty of the computer player (if any): ");
        easy= new JRadioButton("Easy");
        hard= new JRadioButton("Hard");
        difficultyRadioButtons.add(easy);
        difficultyRadioButtons.add(hard);
        difficultyPanel.add(difficulty);
        difficultyPanel.add(easy);
        difficultyPanel.add(hard);

        mainPane.add(difficultyPanel);
        
        //Make the button label
        buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.YELLOW);//Change colour later.
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
        Object event= e.getSource();
        if(event== startButton){
            super.dispose();
            gui.GameBoard gameboard= new gui.GameBoard(16,16);

        }


       
    }



}

