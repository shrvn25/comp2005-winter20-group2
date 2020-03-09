package com.group2.gameplayrules;


import com.group2.physicalgameobjects.Player;
import com.group2.physicalgameobjects.Robot;
import com.group2.physicalgameobjects.SimpleBoard;
import com.group2.physicalgameobjects.Square;

import java.util.HashSet;

/**
 * This class deals with the bidding process.
 */
public class MakingBidsProcess {

    int bid;

    public MakingBidsProcess(){

    }

    public void makeBid(){

    }

    /**
     * This method takes in the list of players, an array of their robots on the board, and the current setup of the gameboard.
     * It returns the
     * The array must be written this way: first index is player1, second player 2, etc.
     * The array for robots must be written in this way: first index is player1's robot, etc.
     *
     * @param player1
     * @param player2
     * @param player3
     * @param player4
     * @param robot1
     * @param robot2
     * @param robot3
     * @param robot4
     * @param theCurrentGameBoard
     */

    public void makingBidsProcess(Player player1, Player player2, Player player3, Player player4, Robot robot1, Robot robot2, Robot robot3, Robot robot4, int[][] targetTileRowColumnLocation, SimpleBoard theCurrentSimpleGameBoard){
        //First get each of the robot's locations on the board
        int [][] robot1Location = robot1.getCurrentRowColumnLocation();
        int [][] robot2Location = robot2.getCurrentRowColumnLocation();
        int [][] robot3Location = robot3.getCurrentRowColumnLocation();
        int [][] robot4Location = robot4.getCurrentRowColumnLocation();

        //First calculate the shortest path from robot1 to the target tile on this gameboard.
        //This uses's Disjksra's algorithm (shortest path to target tile on this gameboard)


        //First get all the squares on the gameboard into an array by adding them starting in top left corner
        //and going from left to right, row by row.
        //Square [] squareArray = theCurrentSimpleGameBoard.getArrayOfAllSquaresRowByRow();

        //Within this  whole board, set all nodes to not visited, and set all distances to infinity by writing -1.
        for (int row = 0; row < 15; row++){
            for (int column = 0; column < 15; column++){
                theCurrentSimpleGameBoard.getSquareAtRowColumnLocation(row, column).setSquareToUnvisted();
                theCurrentSimpleGameBoard.getSquareAtRowColumnLocation(row,column).changeActualDistanceValueForDA(-1);
            }
        }


        //Our initial node right now is the player1 robot, robot1. Set the square this robot sits on to a distance
        //value of 0.


        //First get the robot's location.
        int[]robot1Location = robot1.getCurrentRowColumnLocation();//Fix later.
        Square robotsSquare = theCurrentSimpleGameBoard.getSquareAtRowColumnLocation(robot1Location[0], robot1Location[1]);

        robotsSquare.changeActualDistanceValueForDA(0);
        for (int i = 0; i < squareArray.length; i++){
            if ( robot1Location.equals(squareArray[i].getSquaresRowColumnLocation()) ) { //TODO check this.
                squareArray[i].changeDistanceValueForDA(0);
                robotsSquare = squareArray[i];
            }
        }

        //Make a hashset for visited squares, and make a set for unvisited squares, both of which are first empty.

        HashSet<Square> unvistedSquaresHashSet = new HashSet<Square>();
        HashSet<Square> visitedSquaresHashSet = new HashSet<Square>();

        //Add all the unvisited squares to the unvisitedSquaresHashSet

        for (int row = 0; row < 15; row++){
            for (int column = 0; column < 15; column++){
                unvistedSquaresHashSet.add(theCurrentSimpleGameBoard.getSquareAtRowColumnLocation(row, column));
            }
        }

        //Now find the robot square in this hash set, and set it to



        //Now, check the four north, south, east, west squares adjacent to the current square, and assign
        //a preliminary distance value. Remember that we need to check if there's a barrier. If there is, we can't get
        //to the square, so the distance would be infinite.

        //First check the north square if there is no barrier on the north edge of the square. If there is, we can't
        //go there.

        if (robotsSquare.doesSquareHaveNorthEdgeBarrier() == false){
            if (theCurrentSimpleGameBoard.getSquareAtRowColumnLocation())
            theCurrentSimpleGameBoard.getSquareAtRowColumnLocation()

        }





        //First set all squares as unvisited
        //





    }

}
