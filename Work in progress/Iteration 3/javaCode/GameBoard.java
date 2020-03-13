import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameBoard extends JFrame implements ActionListener
{

    //public static final int dim = 16;
    //private static final Color COL_BACKGROUND = new Color(190, 190, 190);
    //private static final Color COL_CELL1 = new Color(210, 210, 210);
    //private static final Color COL_CELL2 = new Color(245, 245, 245);
    //private static final Color COL_WALL = new Color(85, 85, 85);
// gui components that are contained in this frame:
private JPanel sidePanel, bottomPanel, topPanel, playerPanel;	// top and bottom panels in the main window
private JLabel sideLabel, topLabel,topLabel2,topLabel3,topLabel4,  player1, player2, player3, player4;				// a text label to appear in the top panel
private JButton topButton;				// a 'reset' button to appear in the top panel
private GridSquare [][] gridSquares;	// squares to appear in grid formation in the bottom panel
private int x,y;						// the size of the grid
private JComboBox<Integer> movesList1, movesList2, movesList3, movesList4 ;



/*
 *  constructor method takes as input how many rows and columns of gridsquares to create
 *  it then creates the panels, their subcomponents and puts them all together in the main frame
 *  it makes sure that action listeners are added to selectable items
 *  it makes sure that the gui will be visible
 */
public GameBoard(int x, int y)
{
    this.x = x;
    this.y = y;
    this.setSize(1200,800);
    //blue icons
    ImageIcon blueCircle =new ImageIcon("bluecircle.jpg");
    ImageIcon blueHex =new ImageIcon("bluehex.jpg");
    ImageIcon blueSquare =new ImageIcon("bluesquare.jpg");
    ImageIcon blueTriangle =new ImageIcon("bluetriangle.jpg");
    //green icons
    ImageIcon greenCircle =new ImageIcon("greencircle.jpg");
    ImageIcon greenHex =new ImageIcon("greenhex.jpg");
    ImageIcon greenSquare =new ImageIcon("greensquare.jpg");
    ImageIcon greenTriangle =new ImageIcon("greentriangle.jpg");
    //red icons
    ImageIcon redCricle =new ImageIcon("redcircle.jpg");
    ImageIcon redHex =new ImageIcon("redhex.jpg");
    ImageIcon redSquare =new ImageIcon("redsquare.jpg");
    ImageIcon redTriangle =new ImageIcon("redtriangle.jpg");
    //yellow icons
    ImageIcon yellowCricle =new ImageIcon("yellowcircle.jpg");
    ImageIcon yellowHex =new ImageIcon("yellowhex.jpg");
    ImageIcon yellowSquare =new ImageIcon("yellowsquare.jpg");
    ImageIcon yellowTriangle =new ImageIcon("yellowtriangle.jpg");

    ImageIcon vortex =new ImageIcon("vortex.jpeg");
   
    // first create the panels
    topPanel = new JPanel();
    topPanel.setLayout( new FlowLayout());
    
    bottomPanel = new JPanel();
    bottomPanel.setLayout( new GridLayout( x, y));
    bottomPanel.setSize(800,800);
    
    // then create the components for each panel and add them to it
    
    // for the top panel:
    topLabel = new JLabel("Make a bid!");
    topLabel2 = new JLabel("Timer starts when a bid is made.");
    topLabel3 = new JLabel("Timer");
    topLabel4 = new JLabel("01:00");
    topButton = new JButton("");
    topButton.addActionListener( this);			// IMPORTANT! Without this, clicking the button does nothing.
    topPanel.add( topLabel);

    playerPanel= new JPanel(new GridLayout(6,2));
    playerPanel.setSize(100,800);

    movesList1= new JComboBox<Integer>();


    movesList2= new JComboBox<Integer>();

    
    movesList3= new JComboBox<Integer>();


    movesList4= new JComboBox<Integer>();


    for(int i=0; i<31; i++){
        movesList1.addItem(i);
        movesList2.addItem(i);
        movesList3.addItem(i);
        movesList4.addItem(i);
    }



    //Labels for the Number of Players
    player1= new JLabel("Player 1: ");
    player2= new JLabel("Player 2: ");
    player3= new JLabel("Player 3: ");
    player4= new JLabel("Player 4: ");
    
    playerPanel.add( topLabel);
    playerPanel.add( topLabel2);
    playerPanel.add( topLabel3);
    playerPanel.add( topLabel4);
    //playerPanel.add( topLabel3);
    //Adding all the components
    playerPanel.add(player1);
    playerPanel.add(movesList1);
    playerPanel.add(player2);
    playerPanel.add(movesList2);
    playerPanel.add(player3);
    playerPanel.add(movesList3);
    playerPanel.add(player4);
    playerPanel.add(movesList4);
    
    
    //topPanel.add(player1Label);
    //topPanel.add(player2Label);
    //topPanel.add(player3Label);
    //topPanel.add(player4Label);
    //topPanel.add ( topButton);
    

    // for the bottom panel:	
    // create the buttons and add them to the grid
    gridSquares = new GridSquare [x][y];
    for ( int column = 0; column < x; column ++){
        for ( int row = 0; row < y; row ++){
            gridSquares [column][row] = new GridSquare( x,y);
            gridSquares [column][row].setSize( 20, 20);
            gridSquares [column][row].setColor( column + row);
            gridSquares [column][row].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
 
            
            //gridSquares [column][row].addMouseListener( this);		// AGAIN, don't forget this line!
            
            bottomPanel.add( gridSquares [column][row]);
        }
    }
    for ( int row = 1; row < y; row ++){
            gridSquares [0][row].setBorder(BorderFactory.createMatteBorder(4,1,1,1,Color.black));
        }
    for ( int column = 1; column < y; column ++){
            gridSquares [column][0].setBorder(BorderFactory.createMatteBorder(1,4,1,1,Color.black));
        }
    for ( int row = 1; row < y; row ++){
            gridSquares [15][row].setBorder(BorderFactory.createMatteBorder(1,1,4,1,Color.black));
        }
    for ( int column = 1; column < y; column ++){
            gridSquares [column][15].setBorder(BorderFactory.createMatteBorder(1,1,1,4,Color.black));
        }
    gridSquares [0][0].setBorder(BorderFactory.createMatteBorder(4,4,1,1,Color.black));
    gridSquares [0][15].setBorder(BorderFactory.createMatteBorder(4,1,1,4,Color.black));
    gridSquares [15][0].setBorder(BorderFactory.createMatteBorder(1,4,4,1,Color.black));
    gridSquares [15][15].setBorder(BorderFactory.createMatteBorder(1,1,4,4,Color.black));
    //set Target Tiles
    gridSquares[1][4].setIcon(new ImageIcon(redCricle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[1][13].setIcon(new ImageIcon(redSquare.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[2][1].setIcon(new ImageIcon(greenTriangle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[2][9].setIcon(new ImageIcon(blueTriangle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[3][6].setIcon(new ImageIcon(yellowHex.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[5][14].setIcon(new ImageIcon(greenHex.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[6][3].setIcon(new ImageIcon(blueSquare.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[6][11].setIcon(new ImageIcon(yellowCricle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[8][5].setIcon(new ImageIcon(vortex.getImage().getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[9][1].setIcon(new ImageIcon(blueCircle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[9][14].setIcon(new ImageIcon(yellowSquare.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[10][4].setIcon(new ImageIcon(greenSquare.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[10][8].setIcon(new ImageIcon(redTriangle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[11][13].setIcon(new ImageIcon(greenCircle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[13][5].setIcon(new ImageIcon(redHex.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[13][10].setIcon(new ImageIcon(blueHex.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[14][3].setIcon(new ImageIcon(yellowTriangle.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    //set the exterior barriers
    gridSquares[0][1].setBorder(BorderFactory.createMatteBorder(4,1,1,6,Color.BLACK));
    gridSquares[0][2].setBorder(BorderFactory.createMatteBorder(4,6,1,1,Color.BLACK));

    gridSquares[0][11].setBorder(BorderFactory.createMatteBorder(4,1,1,6,Color.BLACK));
    gridSquares[0][12].setBorder(BorderFactory.createMatteBorder(4,6,1,1,Color.BLACK));

    gridSquares[3][15].setBorder(BorderFactory.createMatteBorder(1,1,6,4,Color.BLACK));
    gridSquares[4][15].setBorder(BorderFactory.createMatteBorder(6,1,1,4,Color.BLACK));

    gridSquares[10][15].setBorder(BorderFactory.createMatteBorder(1,1,6,4,Color.BLACK));
    gridSquares[11][15].setBorder(BorderFactory.createMatteBorder(6,1,1,4,Color.BLACK));

    gridSquares[15][11].setBorder(BorderFactory.createMatteBorder(1,1,4,6,Color.BLACK));
    gridSquares[15][12].setBorder(BorderFactory.createMatteBorder(1,6,4,1,Color.BLACK));

    gridSquares[15][6].setBorder(BorderFactory.createMatteBorder(1,1,4,6,Color.BLACK));
    gridSquares[15][7].setBorder(BorderFactory.createMatteBorder(1,6,4,1,Color.BLACK));

    gridSquares[5][0].setBorder(BorderFactory.createMatteBorder(1,4,6,1,Color.BLACK));
    gridSquares[6][0].setBorder(BorderFactory.createMatteBorder(6,4,1,1,Color.BLACK));

    gridSquares[11][0].setBorder(BorderFactory.createMatteBorder(1,4,6,1,Color.BLACK));
    gridSquares[12][0].setBorder(BorderFactory.createMatteBorder(6,4,1,1,Color.BLACK));
    //set the interior barriers
    gridSquares[0][4].setBorder(BorderFactory.createMatteBorder(4,1,6,1,Color.BLACK));
    gridSquares[1][3].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[1][4].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));

    gridSquares[0][13].setBorder(BorderFactory.createMatteBorder(4,1,6,1,Color.BLACK));
    gridSquares[1][12].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[1][13].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));

    gridSquares[13][3].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[14][2].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[14][3].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));

    gridSquares[12][10].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[13][9].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[13][10].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));

    gridSquares[2][9].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[2][10].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[3][9].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));

    gridSquares[3][6].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[3][7].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[4][6].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));

    gridSquares[9][1].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[9][2].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[10][1].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));

    gridSquares[9][14].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[9][15].setBorder(BorderFactory.createMatteBorder(1,6,1,4,Color.BLACK));
    gridSquares[10][14].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));

    gridSquares[1][1].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[2][1].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[2][2].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));

    gridSquares[7][5].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[8][5].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[8][6].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));

    gridSquares[5][11].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[6][11].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[6][12].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));

    gridSquares[9][8].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[10][8].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[10][9].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));

    gridSquares[12][5].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[13][5].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[13][6].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));

    gridSquares[6][2].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[6][3].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[7][3].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));

    gridSquares[5][13].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[5][14].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[6][14].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));

    gridSquares[10][3].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[10][4].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[11][4].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));

    gridSquares[11][12].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[11][13].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[12][13].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    
    gridSquares[7][7].setBorder(BorderFactory.createMatteBorder(8,8,0,0,Color.BLACK));
    gridSquares[7][8].setBorder(BorderFactory.createMatteBorder(8,0,0,8,Color.BLACK));
    gridSquares[8][7].setBorder(BorderFactory.createMatteBorder(0,8,8,0,Color.BLACK));
    gridSquares[8][8].setBorder(BorderFactory.createMatteBorder(0,0,8,8,Color.BLACK));
    
    // now add the top and bottom panels to the main frame
    getContentPane().setLayout( new BorderLayout());
    getContentPane().add( topPanel, BorderLayout.EAST);
    getContentPane().add( bottomPanel, BorderLayout.CENTER);		// needs to be center or will draw too small
    getContentPane().add( playerPanel, BorderLayout.EAST);
    
    // housekeeping : behaviour
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    setResizable( false);
    setVisible( true);
}



/*
 *  handles actions performed in the gui
 *  this method must be present to correctly implement the ActionListener interface
 */
public void actionPerformed (ActionEvent aevt)
{
    // get the object that was selected in the gui
    Object selected = aevt.getSource();
    
    /*
     * I'm using instanceof here so that I can easily cover the selection of any of the gridsquares
     * with just one piece of code.
     * In a real system you'll probably have one piece of action code per selectable item.
     * Later in the course we'll see that the Command Holder pattern is a much smarter way to handle actions.
     */
    
    // if a gridsquare is selected then switch its color
    if ( selected instanceof GridSquare)
    {
        ((GridSquare) selected).switchColor();
    }
    
    // if resetting the squares' colours is requested then do so
    if ( selected.equals( topButton) )
    {
        for ( int column = 0; column < x; column ++)
        {
            for ( int row = 0; row < y; row ++)
            {
                gridSquares [column][row].setColor( column + row);
            }
        }
    }
}
}
