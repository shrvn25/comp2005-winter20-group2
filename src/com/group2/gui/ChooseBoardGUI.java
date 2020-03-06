package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gui.ChooseDisplayGUI;

public class ChooseBoardGUI extends JFrame implements ActionListener{
    private Container mainPane;
    private JPanel chooseBoardPanel;
    private JLabel chooseBoardType;
    private JRadioButton simpleBoard, complexBoard;
    private JButton startGameButton;
    private ButtonGroup boardTypes;

    public ChooseBoardGUI(){
        super();
        //Creating the container 
        mainPane=getContentPane();
        mainPane.setPreferredSize(new Dimension(600,200));
        
        //Initializing all the components
        chooseBoardPanel= new JPanel();
        chooseBoardPanel.setLayout(new GridLayout(4,2));
        chooseBoardPanel.setPreferredSize(new Dimension(600,200));
        
        startGameButton= new JButton("Start Game");
        startGameButton.addActionListener(this);
        chooseBoardType= new JLabel("Please choose the board type:");
        simpleBoard= new JRadioButton("simple");
        complexBoard= new JRadioButton("complex");
        boardTypes= new ButtonGroup();
        

        //Creating button group for the radio Buttons
        boardTypes.add(simpleBoard);
        boardTypes.add(complexBoard);

        //adding the components to the panel
        chooseBoardPanel.add(chooseBoardType);
        chooseBoardPanel.add(simpleBoard);
        chooseBoardPanel.add(complexBoard);
        chooseBoardPanel.add(startGameButton);
        
        mainPane.add(chooseBoardPanel);
        
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object x= e.getSource();
        if(x== startGameButton){
            super.dispose();
            gui.ChooseDisplayGUI chooseDisplay= new gui.ChooseDisplayGUI();

        }
       
    }
}