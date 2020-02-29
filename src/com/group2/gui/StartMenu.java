import javax.swing.*;
import java.awt.*;
import com.group2.startingstoppinggame.*;

public class StartMenuGUI extends JFrame {
    //Instance Variables
    private Container mainPane;
    private JButton startNewGameButton, loadSavedGameButton;
    private JPanel buttonPanel, informationPanel;
    private JLabel infoMessage;


    //Constructor
    public StartMenuGUI{
        super();

        mainPane = getContentPane();
        mainPane.setLayout(new BorderLayout());

        //Make Buttons
        startNewGameButton = new JButton("START NEW GAME");
        loadSavedGameButton = new JButton("LOAD SAVED GAME");

        //TODO Add listeners to buttons

        //Make the information label
        infoMessage = new JLabel("Welcome to Ricochet Robots!");
        informationPanel = new JPanel();
        informationPanel.add(infoMessage);
        mainPane.add(informationPanel, BorderLayout.NORTH);

        //Make the button label
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(startNewGameButton);
        buttonPanel.add(loadSavedGameButton);
        mainPane.add(buttonPanel, BorderLayout.SOUTH);


        //Pack and make visible
        pack();
        setVisible(true);
    }

    //Methods

}
