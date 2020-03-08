package com.group2.physicalgameobjects;

import com.group2.physicalgameobjects.Color.BlueColor;
import com.group2.physicalgameobjects.Color.GreenColor;
import com.group2.physicalgameobjects.Color.RedColor;
import com.group2.physicalgameobjects.Color.YellowColor;
import com.group2.physicalgameobjects.Symbols.GearSymbol;
import com.group2.physicalgameobjects.Symbols.CrescentMoonSymbol;
import com.group2.physicalgameobjects.Symbols.SaturnSymbol;
import com.group2.physicalgameobjects.Symbols.StarSymbol;

/**
 * This class
 */

public class SimpleBoard extends GameBoard { //TODO Check this

    //int [][][][] newGameBoardAsCoordinates;
    private Square [][] newSimpleBoardAsRowColCoordinates;
    private TargetTile redStarTargetTile, redGearTargetTile, redSaturnTargetTile, redCrescentMoonTargetTile;
    private TargetTile greenStarTargetTile, greenGearTargetTile, greenSaturnTargetTile, greenCrescentMoonTargetTile;
    private TargetTile yellowStarTargetTile, yellowGearTargetTile, yellowSaturnTargetTile, yellowCrescentMoonTargetTile;
    private TargetTile blueStarTargetTile, blueGearTargetTile, blueSaturnTargetTile, blueCrescentMoonTargetTile;
    private TargetTile multicoloredTargetTile;


    public SimpleBoard() {
        super();
        newSimpleBoardAsRowColCoordinates = new Square[16][16];

        //Todo remember x and y coordinates in Java

        //First make all the squares as blanks
        for (int row = 0; row < 16; row++){
            for (int column = 0; column < 16; column++){
                newSimpleBoardAsRowColCoordinates[row][column] = new Square();
            }
        }

        setTargetSquares();
        setBoundaries();

    }

    /**
     * This method is a worker method to make all of the target squares and then add those into the right
     * place for a simple board.
     */
    //TODO Double check these are in the right spot.


//TODO Go back and rename all symbols to saturn crescent moon gear and star

    private void setTargetSquares(){//MadePrivate
        //First make all the Target Tiles
        redGearTargetTile = new TargetTile(new RedColor(), new GearSymbol());
        redCrescentMoonTargetTile = new TargetTile(new RedColor(), new CrescentMoonSymbol());
        redSaturnTargetTile = new TargetTile(new RedColor(), new SaturnSymbol());
        redStarTargetTile = new TargetTile(new RedColor(), new StarSymbol());

        blueGearTargetTile = new TargetTile(new BlueColor(), new GearSymbol());
        blueCrescentMoonTargetTile = new TargetTile(new BlueColor(), new CrescentMoonSymbol());
        blueSaturnTargetTile = new TargetTile(new BlueColor(), new SaturnSymbol());
        blueStarTargetTile = new TargetTile(new BlueColor(), new StarSymbol());

        yellowGearTargetTile = new TargetTile(new YellowColor(), new GearSymbol());
        yellowCrescentMoonTargetTile = new TargetTile(new YellowColor(), new CrescentMoonSymbol());
        yellowSaturnTargetTile = new TargetTile(new YellowColor(), new SaturnSymbol());
        yellowStarTargetTile = new TargetTile(new YellowColor(), new StarSymbol());

        greenGearTargetTile = new TargetTile(new GreenColor(), new GearSymbol());
        greenCrescentMoonTargetTile = new TargetTile(new GreenColor(), new CrescentMoonSymbol());
        greenSaturnTargetTile = new TargetTile(new GreenColor(), new SaturnSymbol());
        greenStarTargetTile = new TargetTile(new GreenColor(), new StarSymbol());

        //Then add the TargetTiles to Those Squares for a Simple Board
        newSimpleBoardAsRowColCoordinates[1][4].addTargetSquareToSquare(redCrescentMoonTargetTile);
        newSimpleBoardAsRowColCoordinates[1][13].addTargetSquareToSquare(redSaturnTargetTile);

        newSimpleBoardAsRowColCoordinates[2][1].addTargetSquareToSquare(greenGearTargetTile);
        newSimpleBoardAsRowColCoordinates[2][9].addTargetSquareToSquare(blueGearTargetTile);

        newSimpleBoardAsRowColCoordinates[3][6].addTargetSquareToSquare(yellowStarTargetTile);

        newSimpleBoardAsRowColCoordinates[5][14].addTargetSquareToSquare(greenStarTargetTile);

        newSimpleBoardAsRowColCoordinates[6][3].addTargetSquareToSquare(blueSaturnTargetTile);
        newSimpleBoardAsRowColCoordinates[6][11].addTargetSquareToSquare(yellowCrescentMoonTargetTile);

        newSimpleBoardAsRowColCoordinates[7][5].addTargetSquareToSquare(multicoloredTargetTile);

        newSimpleBoardAsRowColCoordinates[9][1].addTargetSquareToSquare(blueCrescentMoonTargetTile);
        newSimpleBoardAsRowColCoordinates[9][14].addTargetSquareToSquare(yellowSaturnTargetTile);

        newSimpleBoardAsRowColCoordinates[10][4].addTargetSquareToSquare(greenSaturnTargetTile);
        newSimpleBoardAsRowColCoordinates[10][8].addTargetSquareToSquare(redGearTargetTile);

        newSimpleBoardAsRowColCoordinates[11][13].addTargetSquareToSquare(greenCrescentMoonTargetTile);

        newSimpleBoardAsRowColCoordinates[13][5].addTargetSquareToSquare(redStarTargetTile);
        newSimpleBoardAsRowColCoordinates[13][10].addTargetSquareToSquare(blueStarTargetTile);

        newSimpleBoardAsRowColCoordinates[14][3].addTargetSquareToSquare(yellowGearTargetTile);


    }

    priavte void

    private void setBoundaries(){ //MadePrivate

    }


}

