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
 * This class builds and connects the various physical objects on a simple board to the actual simple board in
 * programming logic.
 */

public class SimpleBoard extends GameBoard { //TODO Check this

    //int [][][][] newGameBoardAsCoordinates;
    private Square [][] newSimpleBoardAsRowColCoordinates;
    private TargetTile redStarTargetTile, redGearTargetTile, redSaturnTargetTile, redCrescentMoonTargetTile;
    private TargetTile greenStarTargetTile, greenGearTargetTile, greenSaturnTargetTile, greenCrescentMoonTargetTile;
    private TargetTile yellowStarTargetTile, yellowGearTargetTile, yellowSaturnTargetTile, yellowCrescentMoonTargetTile;
    private TargetTile blueStarTargetTile, blueGearTargetTile, blueSaturnTargetTile, blueCrescentMoonTargetTile;
    private TargetTile multicoloredTargetTile;

    /**
     * This constructor first makes a blank simple board in programming structures, and creates and connects the other
     * Java objects to this board.
     */
    public SimpleBoard() {
        super();
        newSimpleBoardAsRowColCoordinates = new Square[16][16];

        //Todo remember x and y coordinates in Java

        //First make all the squares as blanks but with their row and column number coordinate
        for (int row = 0; row < 16; row++){
            for (int column = 0; column < 16; column++){
                newSimpleBoardAsRowColCoordinates[row][column] = new Square(row, column);
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
        newSimpleBoardAsRowColCoordinates[1][4].addTargetTileToSquare(redCrescentMoonTargetTile);
        newSimpleBoardAsRowColCoordinates[1][13].addTargetTileToSquare(redSaturnTargetTile);

        newSimpleBoardAsRowColCoordinates[2][1].addTargetTileToSquare(greenGearTargetTile);
        newSimpleBoardAsRowColCoordinates[2][9].addTargetTileToSquare(blueGearTargetTile);

        newSimpleBoardAsRowColCoordinates[3][6].addTargetTileToSquare(yellowStarTargetTile);

        newSimpleBoardAsRowColCoordinates[5][14].addTargetTileToSquare(greenStarTargetTile);

        newSimpleBoardAsRowColCoordinates[6][3].addTargetTileToSquare(blueSaturnTargetTile);
        newSimpleBoardAsRowColCoordinates[6][11].addTargetTileToSquare(yellowCrescentMoonTargetTile);

        newSimpleBoardAsRowColCoordinates[7][5].addTargetTileToSquare(multicoloredTargetTile);

        newSimpleBoardAsRowColCoordinates[9][1].addTargetTileToSquare(blueCrescentMoonTargetTile);
        newSimpleBoardAsRowColCoordinates[9][14].addTargetTileToSquare(yellowSaturnTargetTile);

        newSimpleBoardAsRowColCoordinates[10][4].addTargetTileToSquare(greenSaturnTargetTile);
        newSimpleBoardAsRowColCoordinates[10][8].addTargetTileToSquare(redGearTargetTile);

        newSimpleBoardAsRowColCoordinates[11][13].addTargetTileToSquare(greenCrescentMoonTargetTile);

        newSimpleBoardAsRowColCoordinates[13][5].addTargetTileToSquare(redStarTargetTile);
        newSimpleBoardAsRowColCoordinates[13][10].addTargetTileToSquare(blueStarTargetTile);

        newSimpleBoardAsRowColCoordinates[14][3].addTargetTileToSquare(yellowGearTargetTile);


    }


    /**
     * This method is a worker method that sets all of the grey impassable boundaries found throughout the
     * board for a simple board.
     */
    private void setBoundaries(){ //MadePrivate
        /*First do outer corners clockwise
        newSimpleBoardAsRowColCoordinates[0][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][0].addNorthEdgeBarrier();

        newSimpleBoardAsRowColCoordinates[0][15].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][15].addEastEdgeBarrier();

        newSimpleBoardAsRowColCoordinates[15][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][15].addSouthEdgeBarrier();

        newSimpleBoardAsRowColCoordinates[15][0].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][0].addWestEdgeBarrier();
*/
        //Do inner square corners clockwise from top left//TODO Change?

        newSimpleBoardAsRowColCoordinates[7][7].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[7][7].addNorthEdgeBarrier();

        newSimpleBoardAsRowColCoordinates[7][8].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[7][8].addEastEdgeBarrier();

        newSimpleBoardAsRowColCoordinates[8][8].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[8][8].addSouthEdgeBarrier();

        newSimpleBoardAsRowColCoordinates[8][7].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[8][7].addWestEdgeBarrier();



        //Now do north edge of whole board can overwrite corners
        newSimpleBoardAsRowColCoordinates[0][0].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][1].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][2].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][3].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][4].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][5].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][6].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][7].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][8].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][9].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][10].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][11].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][12].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][13].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][14].addNorthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][15].addNorthEdgeBarrier();

        //Then east edge of whole board can overwrite corners

        newSimpleBoardAsRowColCoordinates[0][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[1][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[2][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[3][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[4][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[5][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[6][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[7][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[8][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[9][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[10][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[11][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[12][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[13][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[14][15].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][15].addEastEdgeBarrier();

        //Then south edge of whole board can overwrite corners

        newSimpleBoardAsRowColCoordinates[15][15].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][14].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][13].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][12].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][11].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][10].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][9].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][8].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][7].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][6].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][5].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][4].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][3].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][2].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][1].addSouthEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[15][0].addSouthEdgeBarrier();



        //Then west edge of whole board can overwrite corners

        newSimpleBoardAsRowColCoordinates[15][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[14][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[13][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[12][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[11][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[10][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[9][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[8][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[7][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[6][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[5][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[4][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[3][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[2][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[1][0].addWestEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][0].addWestEdgeBarrier();

        //Then do random barriers for particular squares within the board that's left.

        //Starting from top row going down //TODO NOTE THAT ADJACENT BOARDS NEED TO HAVE THE SAME BARRIER ON OPPOSITE SIDES.

        //Barrier1
        newSimpleBoardAsRowColCoordinates[0][1].addEastEdgeBarrier();
        newSimpleBoardAsRowColCoordinates[0][2].addWestEdgeBarrier();

        //Barrier2








    }

    /**
     * This method returns a Square[] array of all squares on the simple board row by row.
     * @return
     */
    public Square[] getArrayOfAllSquaresRowByRow(){

    }


    public Square getSquareAtRowColumnLocation(int row, int column){
        return newSimpleBoardAsRowColCoordinates[row][column];
    }

}

