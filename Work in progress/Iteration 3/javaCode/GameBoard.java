import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameBoard extends JFrame implements ActionListener
{

    //public static final int dim = 16;
    //private static final Color COL_BACKGROUND = new Color(190, 190, 190);
    //private static final Color COL_CELL1 = new Color(210, 210, 210);
    //private static final Color COL_CELL2 = new Color(245, 245, 245);
    //private static final Color COL_WALL = new Color(85, 85, 85);
// gui components that are contained in this frame:
private JPanel sidePanel, bottomPanel, topPanel, playerPanel;	// top and bottom panels in the main window
private JLabel sideLabel, topLabel,topLabel2,topLabel3,topLabel4, player1Label, player2Label, player3Label, player4Label;				// a text label to appear in the top panel
private JButton topButton, startBiddingButton;				// a 'reset' button to appear in the top panel
private GridSquare [][] gridSquares;	// squares to appear in grid formation in the bottom panel
private int x,y;						// the size of the grid
private JComboBox<Integer> movesList1, movesList2, movesList3, movesList4 ;
private ImageIcon blueCircleIcon, blueHexIcon, blueSquareIcon, blueTriangleIcon, greenCircleIcon, greenHexIcon, greenSquareIcon, greenTriangleIcon;
private ImageIcon redCircleIcon, redHexIcon, redSquareIcon, redTriangleIcon, yellowCircleIcon, yellowHexIcon, yellowSquareIcon, yellowTriangleIcon;
private ImageIcon vortexIcon;
private TargetTile blueCircleTargetTile, blueHexTargetTile, blueSquareTargetTile, blueTriangleTargetTile;
private TargetTile greenCircleTargetTile, greenHexTargetTile, greenSquareTargetTile, greenTriangleTargetTile;
private TargetTile redCircleTargetTile, redHexTargetTile, redSquareTargetTile, redTriangleTargetTile;
private TargetTile yellowCircleTargetTile, yellowHexTargetTile, yellowSquareTargetTile, yellowTriangleTargetTile;
private TargetTile vortexTargetTile;
private ImageIcon redRobotIcon, greenRobotIcon, yellowRobotIcon, blueRobotIcon;
private RobotPieces redRobot, greenRobot, yellowRobot, blueRobot;
private Player player1, player2, player3, player4, playerWithLowestBid;
//private VerifyBidProcessor verifyBidProcessor;




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

    createIconObjects();
    createPanels();
    createButtonsWithIconsAndTargetTilesAndAddToGrid();
    setupVisualAndLogicalBorders();
    addRobotIconsAndRobotsToStartingPositions();
    //addStartBiddingButton();
    addPanelsToGetContentPane();


    // housekeeping : behaviour
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    setResizable( false);
    setVisible( true);


    createPlayersAndConnectRobots();

}



/*
 *  handles actions performed in the gui
 *  this method must be present to correctly implement the ActionListener interface
 */
public void actionPerformed (ActionEvent actionEvent)
{
    // get the object that was selected in the gui
    Object selected = actionEvent.getSource();

    if (selected.equals(startBiddingButton)){
        startBiddingRound();
    }
    else if (selected.equals(movesList1)){
        player1.setBidNumber( movesList1.getSelectedIndex() );
    }
    else if (selected.equals(movesList2)){
        player2.setBidNumber( movesList2.getSelectedIndex() );
    }
    else if (selected.equals(movesList3)){
        player3.setBidNumber( movesList3.getSelectedIndex() );
    }
    else if (selected.equals(movesList4)){
        player4.setBidNumber( movesList4.getSelectedIndex() );
    }


    
    /*
     * I'm using instanceof here so that I can easily cover the selection of any of the gridsquares
     * with just one piece of code.
     * In a real system you'll probably have one piece of action code per selectable item.
     * Later in the course we'll see that the Command Holder pattern is a much smarter way to handle actions.
     */
    /*
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
    */

}



private void createIconObjects(){
    //blue icons
    blueCircleIcon =new ImageIcon("bluecircle.jpg");
    blueHexIcon =new ImageIcon("bluehex.jpg");
    blueSquareIcon =new ImageIcon("bluesquare.jpg");
    blueTriangleIcon =new ImageIcon("bluetriangle.jpg");
    //green icons
    greenCircleIcon =new ImageIcon("greencircle.jpg");
    greenHexIcon =new ImageIcon("greenhex.jpg");
    greenSquareIcon =new ImageIcon("greensquare.jpg");
    greenTriangleIcon =new ImageIcon("greentriangle.jpg");
    //red icons
    redCircleIcon =new ImageIcon("redcircle.jpg");
    redHexIcon =new ImageIcon("redhex.jpg");
    redSquareIcon =new ImageIcon("redsquare.jpg");
    redTriangleIcon =new ImageIcon("redtriangle.jpg");
    //yellow icons
    yellowCircleIcon =new ImageIcon("yellowcircle.jpg");
    yellowHexIcon =new ImageIcon("yellowhex.jpg");
    yellowSquareIcon =new ImageIcon("yellowsquare.jpg");
    yellowTriangleIcon =new ImageIcon("yellowtriangle.jpg");

    vortexIcon =new ImageIcon("vortex.jpeg");
}

private void createPanels(){
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
    //topButton = new JButton("");
    //topButton.addActionListener( this);			// IMPORTANT! Without this, clicking the button does nothing.

    startBiddingButton = new JButton("Start Bidding Round!");
    startBiddingButton.addActionListener(this);

    topPanel.add(startBiddingButton);
    topPanel.add(topLabel2);
    topPanel.add(topLabel3);
    topPanel.add(topLabel4);
    //topPanel.add( topLabel);



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
    player1Label = new JLabel("Player 1: ");
    player2Label = new JLabel("Player 2: ");
    player3Label = new JLabel("Player 3: ");
    player4Label = new JLabel("Player 4: ");

    playerPanel.add(startBiddingButton);
    playerPanel.add( topLabel2);
    playerPanel.add( topLabel3);
    playerPanel.add( topLabel4);
    //playerPanel.add( topLabel3);
    //Adding all the components
    playerPanel.add(player1Label);
    playerPanel.add(movesList1);
    playerPanel.add(player2Label);
    playerPanel.add(movesList2);
    playerPanel.add(player3Label);
    playerPanel.add(movesList3);
    playerPanel.add(player4Label);
    playerPanel.add(movesList4);


    //topPanel.add(player1Label);
    //topPanel.add(player2Label);
    //topPanel.add(player3Label);
    //topPanel.add(player4Label);
    //topPanel.add ( topButton);


}

private void createButtonsWithIconsAndTargetTilesAndAddToGrid(){
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

    //make all the TargetTiles
    redCircleTargetTile = new TargetTile("RED", "CIRCLE");
    redSquareTargetTile = new TargetTile("RED", "SQUARE");
    redHexTargetTile = new TargetTile("RED", "HEX");
    redTriangleTargetTile = new TargetTile("RED", "TRIANGLE");

    greenCircleTargetTile = new TargetTile("GREEN", "CIRCLE");
    greenSquareTargetTile = new TargetTile("GREEN", "SQUARE");
    greenHexTargetTile = new TargetTile("GREEN", "HEX");
    greenTriangleTargetTile = new TargetTile("GREEN", "TRIANGLE");

    yellowCircleTargetTile = new TargetTile("YELLOW", "CIRCLE");
    yellowSquareTargetTile = new TargetTile("YELLOW", "SQUARE");
    yellowHexTargetTile = new TargetTile("YELLOW", "HEX");
    yellowTriangleTargetTile = new TargetTile("YELLOW", "TRIANGLE");

    blueCircleTargetTile = new TargetTile("BLUE", "CIRCLE");
    blueSquareTargetTile = new TargetTile("BLUE", "SQUARE");
    blueHexTargetTile = new TargetTile("BLUE", "HEX");
    blueTriangleTargetTile = new TargetTile("BLUE", "TRIANGLE");

    vortexTargetTile = new TargetTile("MULTICOLOR", "VORTEX");



    //set Target Tiles and their icons
    gridSquares[1][4].setIcon(new ImageIcon(redCircleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[1][4].addTargetTileToSquare(redCircleTargetTile);
    gridSquares[1][13].setIcon(new ImageIcon(redSquareIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[1][13].addTargetTileToSquare(redSquareTargetTile);
    gridSquares[2][1].setIcon(new ImageIcon(greenTriangleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[2][1].addTargetTileToSquare(greenTriangleTargetTile);
    gridSquares[2][9].setIcon(new ImageIcon(blueTriangleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[2][9].addTargetTileToSquare(blueTriangleTargetTile);
    gridSquares[3][6].setIcon(new ImageIcon(yellowHexIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[3][6].addTargetTileToSquare(yellowHexTargetTile);
    gridSquares[5][14].setIcon(new ImageIcon(greenHexIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[5][14].addTargetTileToSquare(greenHexTargetTile);
    gridSquares[6][3].setIcon(new ImageIcon(blueSquareIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[6][3].addTargetTileToSquare(blueSquareTargetTile);
    gridSquares[6][11].setIcon(new ImageIcon(yellowCircleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[6][11].addTargetTileToSquare(yellowCircleTargetTile);
    gridSquares[8][5].setIcon(new ImageIcon(vortexIcon.getImage().getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[8][5].addTargetTileToSquare(vortexTargetTile);
    gridSquares[9][1].setIcon(new ImageIcon(blueCircleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[9][1].addTargetTileToSquare(blueCircleTargetTile);
    gridSquares[9][14].setIcon(new ImageIcon(yellowSquareIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[9][14].addTargetTileToSquare(yellowSquareTargetTile);
    gridSquares[10][4].setIcon(new ImageIcon(greenSquareIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[10][4].addTargetTileToSquare(greenSquareTargetTile);
    gridSquares[10][8].setIcon(new ImageIcon(redTriangleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[10][8].addTargetTileToSquare(redTriangleTargetTile);
    gridSquares[11][13].setIcon(new ImageIcon(greenCircleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[11][13].addTargetTileToSquare(greenCircleTargetTile);
    gridSquares[13][5].setIcon(new ImageIcon(redHexIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[13][5].addTargetTileToSquare(redHexTargetTile);
    gridSquares[13][10].setIcon(new ImageIcon(blueHexIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[13][10].addTargetTileToSquare(blueHexTargetTile);
    gridSquares[14][3].setIcon(new ImageIcon(yellowTriangleIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));
    gridSquares[14][3].addTargetTileToSquare(yellowTriangleTargetTile);




}

private void setupVisualAndLogicalBorders(){
    //set the exterior barriers visually
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





    //set the interior barriers and the logic

    //First do outer perimeter logic barriers

    //First do north edge of whole board can overwrite corners
    gridSquares[0][0].addNorthEdgeBarrier();
    gridSquares[0][1].addNorthEdgeBarrier();
    gridSquares[0][2].addNorthEdgeBarrier();
    gridSquares[0][3].addNorthEdgeBarrier();
    gridSquares[0][4].addNorthEdgeBarrier();
    gridSquares[0][5].addNorthEdgeBarrier();
    gridSquares[0][6].addNorthEdgeBarrier();
    gridSquares[0][7].addNorthEdgeBarrier();
    gridSquares[0][8].addNorthEdgeBarrier();
    gridSquares[0][9].addNorthEdgeBarrier();
    gridSquares[0][10].addNorthEdgeBarrier();
    gridSquares[0][11].addNorthEdgeBarrier();
    gridSquares[0][12].addNorthEdgeBarrier();
    gridSquares[0][13].addNorthEdgeBarrier();
    gridSquares[0][14].addNorthEdgeBarrier();
    gridSquares[0][15].addNorthEdgeBarrier();

    //Then east edge of whole board can overwrite corners

    gridSquares[0][15].addEastEdgeBarrier();
    gridSquares[1][15].addEastEdgeBarrier();
    gridSquares[2][15].addEastEdgeBarrier();
    gridSquares[3][15].addEastEdgeBarrier();
    gridSquares[4][15].addEastEdgeBarrier();
    gridSquares[5][15].addEastEdgeBarrier();
    gridSquares[6][15].addEastEdgeBarrier();
    gridSquares[7][15].addEastEdgeBarrier();
    gridSquares[8][15].addEastEdgeBarrier();
    gridSquares[9][15].addEastEdgeBarrier();
    gridSquares[10][15].addEastEdgeBarrier();
    gridSquares[11][15].addEastEdgeBarrier();
    gridSquares[12][15].addEastEdgeBarrier();
    gridSquares[13][15].addEastEdgeBarrier();
    gridSquares[14][15].addEastEdgeBarrier();
    gridSquares[15][15].addEastEdgeBarrier();

    //Then south edge of whole board can overwrite corners

    gridSquares[15][15].addSouthEdgeBarrier();
    gridSquares[15][14].addSouthEdgeBarrier();
    gridSquares[15][13].addSouthEdgeBarrier();
    gridSquares[15][12].addSouthEdgeBarrier();
    gridSquares[15][11].addSouthEdgeBarrier();
    gridSquares[15][10].addSouthEdgeBarrier();
    gridSquares[15][9].addSouthEdgeBarrier();
    gridSquares[15][8].addSouthEdgeBarrier();
    gridSquares[15][7].addSouthEdgeBarrier();
    gridSquares[15][6].addSouthEdgeBarrier();
    gridSquares[15][5].addSouthEdgeBarrier();
    gridSquares[15][4].addSouthEdgeBarrier();
    gridSquares[15][3].addSouthEdgeBarrier();
    gridSquares[15][2].addSouthEdgeBarrier();
    gridSquares[15][1].addSouthEdgeBarrier();
    gridSquares[15][0].addSouthEdgeBarrier();

    //Then west edge of whole board can overwrite corners

    gridSquares[15][0].addWestEdgeBarrier();
    gridSquares[14][0].addWestEdgeBarrier();
    gridSquares[13][0].addWestEdgeBarrier();
    gridSquares[12][0].addWestEdgeBarrier();
    gridSquares[11][0].addWestEdgeBarrier();
    gridSquares[10][0].addWestEdgeBarrier();
    gridSquares[9][0].addWestEdgeBarrier();
    gridSquares[8][0].addWestEdgeBarrier();
    gridSquares[7][0].addWestEdgeBarrier();
    gridSquares[6][0].addWestEdgeBarrier();
    gridSquares[5][0].addWestEdgeBarrier();
    gridSquares[4][0].addWestEdgeBarrier();
    gridSquares[3][0].addWestEdgeBarrier();
    gridSquares[2][0].addWestEdgeBarrier();
    gridSquares[1][0].addWestEdgeBarrier();
    gridSquares[0][0].addWestEdgeBarrier();

    //Now do rest


    //First corner barrier

    gridSquares[0][4].setBorder(BorderFactory.createMatteBorder(4,1,6,1,Color.BLACK));
    gridSquares[0][4].addSouthEdgeBarrier();
    gridSquares[1][3].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[1][3].addEastEdgeBarrier();
    gridSquares[1][4].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));
    gridSquares[1][4].addNorthEdgeBarrier();
    //Border not filled in.
    gridSquares[1][4].addWestEdgeBarrier();

    //Second corner barrier

    gridSquares[0][13].setBorder(BorderFactory.createMatteBorder(4,1,6,1,Color.BLACK));
    gridSquares[0][13].addSouthEdgeBarrier();
    gridSquares[1][12].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[1][12].addEastEdgeBarrier();
    gridSquares[1][13].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));
    gridSquares[1][13].addNorthEdgeBarrier();
    gridSquares[1][13].addWestEdgeBarrier();

    //Third corner barrier

    gridSquares[13][3].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[13][3].addSouthEdgeBarrier();
    gridSquares[14][2].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[14][2].addEastEdgeBarrier();
    gridSquares[14][3].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));
    gridSquares[14][3].addNorthEdgeBarrier();
    gridSquares[14][3].addWestEdgeBarrier();

    //Fourth corner barrier

    gridSquares[12][10].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[12][10].addSouthEdgeBarrier();
    gridSquares[13][9].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[13][9].addEastEdgeBarrier();
    gridSquares[13][10].setBorder(BorderFactory.createMatteBorder(6,6,1,1,Color.BLACK));
    gridSquares[13][10].addNorthEdgeBarrier();
    gridSquares[13][10].addWestEdgeBarrier();

    //Fifth corner barrier

    gridSquares[2][9].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[2][9].addSouthEdgeBarrier();
    gridSquares[2][9].addEastEdgeBarrier();
    gridSquares[2][10].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[2][10].addWestEdgeBarrier();
    gridSquares[3][9].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[3][9].addNorthEdgeBarrier();

    //Sixth corner barrier

    gridSquares[3][6].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[3][6].addSouthEdgeBarrier();
    gridSquares[3][6].addEastEdgeBarrier();
    gridSquares[3][7].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[3][7].addWestEdgeBarrier();
    gridSquares[4][6].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[4][6].addNorthEdgeBarrier();

    //Seventh corner barrier

    gridSquares[9][1].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[9][1].addSouthEdgeBarrier();
    gridSquares[9][1].addEastEdgeBarrier();
    gridSquares[9][2].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[9][2].addWestEdgeBarrier();
    gridSquares[10][1].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[10][1].addNorthEdgeBarrier();


    //Eighth corner barrier

    gridSquares[9][14].setBorder(BorderFactory.createMatteBorder(1,1,6,6,Color.BLACK));
    gridSquares[9][14].addSouthEdgeBarrier();
    gridSquares[9][14].addEastEdgeBarrier();
    gridSquares[9][15].setBorder(BorderFactory.createMatteBorder(1,6,1,4,Color.BLACK));
    gridSquares[9][15].addWestEdgeBarrier();
    gridSquares[10][14].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[10][14].addNorthEdgeBarrier();

    //Ninth corner barrier

    gridSquares[1][1].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[1][1].addSouthEdgeBarrier();
    gridSquares[2][1].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[2][1].addNorthEdgeBarrier();
    gridSquares[2][1].addWestEdgeBarrier();
    gridSquares[2][2].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[2][2].addEastEdgeBarrier();

    //Tenth corner barrier

    gridSquares[7][5].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[7][5].addSouthEdgeBarrier();
    gridSquares[8][5].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[8][5].addNorthEdgeBarrier();
    gridSquares[8][5].addEastEdgeBarrier();
    gridSquares[8][6].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[8][6].addWestEdgeBarrier();

    //Eleventh corner barrier

    gridSquares[5][11].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[5][11].addSouthEdgeBarrier();
    gridSquares[6][11].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[6][11].addNorthEdgeBarrier();
    gridSquares[6][11].addEastEdgeBarrier();
    gridSquares[6][12].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[6][12].addWestEdgeBarrier();

    //Tweleth corner barrier

    gridSquares[9][8].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[9][8].addSouthEdgeBarrier();
    gridSquares[10][8].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[10][8].addNorthEdgeBarrier();
    gridSquares[10][8].addEastEdgeBarrier();
    gridSquares[10][9].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[10][9].addWestEdgeBarrier();

    //Thirteenth corner barrier

    gridSquares[12][5].setBorder(BorderFactory.createMatteBorder(1,1,6,1,Color.BLACK));
    gridSquares[12][5].addSouthEdgeBarrier();
    gridSquares[13][5].setBorder(BorderFactory.createMatteBorder(6,1,1,6,Color.BLACK));
    gridSquares[13][5].addNorthEdgeBarrier();
    gridSquares[13][5].addEastEdgeBarrier();
    gridSquares[13][6].setBorder(BorderFactory.createMatteBorder(1,6,1,1,Color.BLACK));
    gridSquares[13][6].addWestEdgeBarrier();

    //Fourteenth corner barrier

    gridSquares[6][2].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[6][2].addEastEdgeBarrier();
    gridSquares[6][3].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[6][3].addWestEdgeBarrier();
    gridSquares[6][3].addSouthEdgeBarrier();
    gridSquares[7][3].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[7][3].addNorthEdgeBarrier();

    //Fifteenth corner barrier

    gridSquares[5][13].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[5][13].addEastEdgeBarrier();
    gridSquares[5][14].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[5][14].addWestEdgeBarrier();
    gridSquares[5][14].addSouthEdgeBarrier();
    gridSquares[6][14].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[6][14].addNorthEdgeBarrier();

    //Sixteenth corner barrier

    gridSquares[10][3].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[10][3].addEastEdgeBarrier();
    gridSquares[10][4].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[10][4].addWestEdgeBarrier();
    gridSquares[10][4].addSouthEdgeBarrier();
    gridSquares[11][4].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[11][4].addNorthEdgeBarrier();

    //Barrier

    gridSquares[11][12].setBorder(BorderFactory.createMatteBorder(1,1,1,6,Color.BLACK));
    gridSquares[11][12].addEastEdgeBarrier();
    gridSquares[11][13].setBorder(BorderFactory.createMatteBorder(1,6,6,1,Color.BLACK));
    gridSquares[11][13].addWestEdgeBarrier();
    gridSquares[11][13].addSouthEdgeBarrier();
    gridSquares[12][13].setBorder(BorderFactory.createMatteBorder(6,1,1,1,Color.BLACK));
    gridSquares[12][13].addNorthEdgeBarrier();

    //Barrier

    gridSquares[7][7].setBorder(BorderFactory.createMatteBorder(8,8,0,0,Color.BLACK));
    gridSquares[7][7].addNorthEdgeBarrier();
    gridSquares[7][7].addWestEdgeBarrier();
    gridSquares[7][8].setBorder(BorderFactory.createMatteBorder(8,0,0,8,Color.BLACK));
    gridSquares[7][8].addNorthEdgeBarrier();
    gridSquares[7][8].addEastEdgeBarrier();
    gridSquares[8][7].setBorder(BorderFactory.createMatteBorder(0,8,8,0,Color.BLACK));
    gridSquares[8][7].addWestEdgeBarrier();
    gridSquares[8][7].addSouthEdgeBarrier();
    gridSquares[8][8].setBorder(BorderFactory.createMatteBorder(0,0,8,8,Color.BLACK));
    gridSquares[8][8].addSouthEdgeBarrier();
    gridSquares[8][8].addEastEdgeBarrier();
}

private void addRobotIconsAndRobotsToStartingPositions(){
    redRobotIcon = new ImageIcon("redRobot.jpg");
    greenRobotIcon = new ImageIcon("greenRobot.jpg");
    yellowRobotIcon = new ImageIcon("yellowRobot.jpg");
    blueRobotIcon = new ImageIcon("blueRobot.jpg");
    //TODO need to finish adding icons here



    redRobot = new RobotPieces("RED", "STAR");
    redRobot.setRobotRowCoordinate(11);
    redRobot.setRobotColumnCoordinate(3);
    gridSquares[11][3].addRobotToSquare(redRobot);
    gridSquares[11][3].setIcon(new ImageIcon(redRobotIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));

    greenRobot = new RobotPieces("GREEN", "");
    greenRobot.setRobotRowCoordinate(5);
    greenRobot.setRobotColumnCoordinate(13);
    gridSquares[5][13].addRobotToSquare(greenRobot);
    gridSquares[5][13].setIcon(new ImageIcon(greenRobotIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));

    yellowRobot = new RobotPieces("YELLOW", "");
    yellowRobot.setRobotRowCoordinate(3);
    yellowRobot.setRobotColumnCoordinate(10);
    gridSquares[3][10].addRobotToSquare(yellowRobot);
    gridSquares[3][10].setIcon(new ImageIcon(yellowRobotIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));

    blueRobot = new RobotPieces("BLUE", "");
    blueRobot.setRobotRowCoordinate(0);
    blueRobot.setRobotColumnCoordinate(0);
    gridSquares[0][0].addRobotToSquare(blueRobot);
    gridSquares[0][0].setIcon(new ImageIcon(blueRobotIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH)));

}


private void addPanelsToGetContentPane(){
    // now add the top and bottom panels to the main frame
    getContentPane().setLayout( new BorderLayout());
    getContentPane().add( topPanel, BorderLayout.EAST);
    getContentPane().add( bottomPanel, BorderLayout.CENTER);		// needs to be center or will draw too small
    getContentPane().add( playerPanel, BorderLayout.EAST);
}

private void createPlayersAndConnectRobots(){
    player1 = new Player();
    player2 = new Player();
    player3 = new Player();
    player4 = new Player();

    //TODO Set all to human now, THIS WILL NEED TO BE CHANGED to connect to game settings.

    player1.setPlayerTypeToHuman();
    player2.setPlayerTypeToHuman();
    player3.setPlayerTypeToHuman();
    player4.setPlayerTypeToHuman();

    player1.setPlayersRobot(redRobot);
    player2.setPlayersRobot(greenRobot);
    player3.setPlayersRobot(yellowRobot);
    player4.setPlayersRobot(blueRobot);
}

private void startBiddingRound(){
    Timer biddingTimer = new Timer();

    int currentPlayer1Bid = 0;
    int currentPlayer2Bid = 0;
    int currentPlayer3Bid = 0;
    int currentPlayer4Bid = 0;

    biddingTimer.startTime();

    while (biddingTimer.hasBiddingTimeStopped == false){
        if (currentPlayer1Bid != player1.getBidNumber()){
            currentPlayer1Bid = player1.getBidNumber();
        }
        if (currentPlayer2Bid != player2.getBidNumber()){
            currentPlayer2Bid = player1.getBidNumber();
        }
        if (currentPlayer3Bid != player3.getBidNumber()){
            currentPlayer3Bid = player3.getBidNumber();
        }
        if (currentPlayer4Bid != player4.getBidNumber()){
            currentPlayer4Bid = player4.getBidNumber();
        }
    }

    playerWithLowestBid = new Player();
    playerWithLowestBid = determinePlayerWithLowestBid();


    //TODO Now get that person to click through their squares
    //DUMMY CODE Will need to be removed.
    GridSquare [] squaresPlayerClicked = {new GridSquare(-1, -1), new GridSquare(-1, -1), new GridSquare(-1, -1)};

    //DummyCode
    GridSquare squareWithCurrentTargetTile = new GridSquare(-1, -1);


   // VerifyBidProcessor verifyBidProcessor = new VerifyBidProcessor(playerWithLowestBid.getBidNumber(), squaresPlayerClicked, playerWithLowestBid.getPlayersRobot(), squareWithCurrentTargetTile);

   // if (verifyBidProcessor.wereMovesLegalAndAccurate() == true){
        //
  //  }





    //How to disable players bids?

}


private Player determinePlayerWithLowestBid(){
    int currentLowestBid = player1.getBidNumber();
    Player currentPlayerWithLowestBid = player1;

    if (currentLowestBid > player2.getBidNumber()){
        currentLowestBid = player2.getBidNumber();
        currentPlayerWithLowestBid = player2;
    }

    if (currentLowestBid > player3.getBidNumber()) {
        currentLowestBid = player3.getBidNumber();
        currentPlayerWithLowestBid = player3;
    }

    if (currentLowestBid > player4.getBidNumber()){
        currentLowestBid = player4.getBidNumber();
        currentPlayerWithLowestBid = player4;
    }

    return currentPlayerWithLowestBid;
}


}
