package com.group2.gui;

import javax.swing.*;
import java.awt.*;

public class ChooseDisplayGUI extends JFrame {
    //Instance Variables
    private Container mainPane;
    private JButton simpleOptionButton, complexOptionButton;
    private JPanel buttonPanel, informationPanel;
    private JLabel infoMessage;


    //Constructor
    public ChooseDisplayGUI(){
        super();

        mainPane = getContentPane();
        mainPane.setLayout(new BorderLayout());

        //Make Buttons
        simpleOptionButton = new JButton("START NEW GAME");
        complexOptionButton = new JButton("LOAD SAVED GAME");

        //TODO Add listeners to buttons

        //Make the information label
        infoMessage = new JLabel("Please choose a simple display or a complex display.");
        informationPanel = new JPanel();
        informationPanel.add(infoMessage);
        mainPane.add(informationPanel, BorderLayout.NORTH);

        //Make the button label
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(simpleOptionButton);
        buttonPanel.add(complexOptionButton);
        mainPane.add(buttonPanel, BorderLayout.SOUTH);


        //Pack and make visible
        pack();
        setVisible(true);
    }

    //Methods

}

