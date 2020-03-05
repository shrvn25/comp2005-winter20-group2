import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseDisplayGUI extends JFrame implements ActionListener {
    //Instance Variables
    private Container mainPane;
    private JButton simpleOptionButton, complexOptionButton;
    private JPanel buttonPanel, informationPanel;
    private JLabel infoMessage;


    //Constructor
    public ChooseDisplayGUI(){
        super();

        mainPane = getContentPane();
        mainPane.setPreferredSize(new Dimension(500,500));
        mainPane.setLayout(new BorderLayout());
        
        
        //Make Buttons
        simpleOptionButton = new JButton("SIMPLE DISPLAY");
        complexOptionButton = new JButton("COMPLEX DISPLAY");

        //TODO Add listeners to buttons

        //Make the information label
        simpleOptionButton.addActionListener(this);
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
    public void actionPerformed(ActionEvent e){
        Object event = e.getSource();
        if(event == simpleOptionButton){
            GameBoard newGameBoard = new GameBoard(16, 16);

        }
        //else if(x== loadSavedGameButton){

        //}
    }


    //Methods

}