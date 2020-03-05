package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gui.ChooseDisplayGUI;

public class StartMenuGUI extends JFrame implements ActionListener{
    //Instance Variables
    private Container mainPane;
    private JButton startNewGameButton;
    private JPanel buttonPanel, informationPanel;
    private JLabel infoMessage ;
   
  
    

    //Constructor
    public StartMenuGUI(){
        super();

        mainPane = getContentPane();
        mainPane.setPreferredSize(new Dimension(500,500));
        mainPane.setLayout(new BorderLayout());
        

        //Make Buttons  
        startNewGameButton = new JButton("START NEW GAME");
       

     

        

        //TODO Add listeners to buttons
        
        startNewGameButton.addActionListener(this);
       
      


        //Make the information panel
        infoMessage = new JLabel("Welcome to Ricochet Robots!");
        informationPanel = new JPanel();
        informationPanel.add(infoMessage);
        mainPane.add(informationPanel, BorderLayout.NORTH);


        //Make the button label
        buttonPanel = new JPanel();
        
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(startNewGameButton);
        
        mainPane.add(buttonPanel, BorderLayout.SOUTH);


        //Pack and make visible
        pack();
        setVisible(true);

        
    }

    public void actionPerformed(ActionEvent e){
        Object x= e.getSource();
        if(x== startNewGameButton){
            ChooseDisplayGUI newChooseDisplayGUI= new ChooseDisplayGUI();

        }
       
    }

    //Methods


}
