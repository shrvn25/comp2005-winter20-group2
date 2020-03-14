/*package com.group2.physicalgameobjects;

import com.group2.javaCode.Robot;
*/



/**
 * This class describes a square on a game board (used for both simple and complex). It has a row and column location on the
 * board (where top left has row col coordinate as (0, 0), top right corner has (0, 15), bottom right corner has
 * (15, 15), and bottom left corner has (15, 0). The square also has a list of what items are currently "on" it
 * in a list, where certain indices are given designated slots for different types of Java objects.
 * It also records if it has an edge barrier that a robot can't pass through, or a diagonal
 * barrier that some robots can pass through (note that two square adjacent to each other that have a edge barrier in between
 * them, have a recorded edge barrier on opposite sides of each other.) Square can also tell you if there is a target
 * tile on it and what that tile is,  and if there is a robot on it, and what that robot is.
 *
 */
public class Square {
    private Location rowColumnCoordinate;
    private RobotPieces squaresRobot;
    private TargetTile squaresTargetTile;
    private DiagonalBarrier squaresDiagonalBarrier;
    private String northEdgeBarrier, southEdgeBarrier, eastEdgeBarrier, westEdgeBarrier;

    /**
     * To first make a square, you need to give it a row coordinate and a column coordinate. Default is that there is
     * nothing on the square at first, you have to add to it.
     * @param rowCoordinate
     * @param columnCoordinate
     */
    public Square(int rowCoordinate, int columnCoordinate){
        //Default is that there is nothing on the square at first, you have to add to it.

        this.rowColumnCoordinate.changeRowCoordinate(rowCoordinate);
        this.rowColumnCoordinate.changeColumnCoordinate(columnCoordinate);
        
        this.squaresRobot = null;
        this.squaresTargetTile = null;
        this.squaresDiagonalBarrier = null;

        this.northEdgeBarrier = null;
        this.southEdgeBarrier = null;
        this.eastEdgeBarrier = null;
        this.westEdgeBarrier = null;
    }

    /**
     * This method receives a robot to put on the square.
     * @param newRobot
     */

    public void addRobotToSquare(RobotPieces newRobot){
        this.squaresRobot = newRobot;
    }

    /**
     * This method returns true if there is a robot currently on it (the square), or false if not.
     * @return
     */

    public boolean isRobotOnSquare(){
        if (this.squaresRobot != null){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * This method returns the actual robot that is on it (the square). WARNING if there is no robot on this
     * and you call it, it will return null.
     * @return
     */

    public RobotPieces getRobotOnSquare(){
        return this.squaresRobot;
    }

    /**
     * This method removes a robot from a square.
     */

    public void removeRobotFromSquare(){
        this.squaresRobot = null;
    }

    /**
     * This method returns true if there is a diagonal barrier on the square, and false if not.
     * @return
     */

    public boolean doesSquareHaveDiagonalBarrier(){
        if (squaresDiagonalBarrier != null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method adds a DiagonalBarrier object to the square.
     * @param newDiagonalBarrier
     */

    public void addDiagonalBarrierToSquare(DiagonalBarrier newDiagonalBarrier){
        this.squaresDiagonalBarrier = newDiagonalBarrier;
    } 

    /**
     * This method returns null if there is no diagonal barrier on square, or 
     * the DiagonalBarrier object found on the square.
     * @return
     */
    public DiagonalBarrier getDiagonalBarrierOnSquare(){
        return this.squaresDiagonalBarrier;
    }



    /**
     * This method adds a target tile to a square.
     * @param newTargetTile
     */

    public void addTargetTileToSquare(TargetTile newTargetTile){
        this.squaresTargetTile = newTargetTile;
    }

    /**
     * This method returns true if the square has a target tile, and false if not.
     * @return
     */

    public boolean doesSquareHaveATargetTile(){
        if (squaresTargetTile != null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method add a square edge barrier to the north edge of the square.
     */

    public void addNorthEdgeBarrier(){
        this.northEdgeBarrier = "NORTH_EDGE_BARRIER";
    }

    /**
     * This method add a square edge barrier to the south edge of the square.
     */

    public void addSouthEdgeBarrier(){
        this.southEdgeBarrier = "SOUTH_EDGE_BARRIER";
    }
    /**
     * This method add a square edge barrier to the east edge of the square.
     */

    public void addEastEdgeBarrier(){
        this.eastEdgeBarrier = "EAST_EDGE_BARRIER";
    }
    /**
     * This method add a square edge barrier to the west edge of the square.
     */

    public void addWestEdgeBarrier(){
        this.westEdgeBarrier = "WEST_EDGE_BARRIER";
    }
    /**
     * This method returns true if square has a north edge barrier, false if not.
     * @return
     */

    public boolean doesSquareHaveNorthEdgeBarrier(){
        if (this.northEdgeBarrier.equals("NORTH_EDGE_BARRIER")) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method returns true if square has south edge barrier, false if not.
     * @return
     */

    public boolean doesSquareHaveSouthEdgeBarrier(){
        if (this.southEdgeBarrier.equals("SOUTH_EDGE_BARRIER")) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method returns true if square has east edge barrier, false if not.
     * @return
     */
    public boolean doesSquareHaveEastEdgeBarrier(){
        if (this.eastEdgeBarrier.equals("EAST_EDGE_BARRIER")) {
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * This method returns true if a square has a west edge barrier, false if not.
     * @return
     */
    public boolean doesSquareHaveWestEdgeBarrier(){
        if (this.westEdgeBarrier.equals("WEST_EDGE_BARRIER")) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method returns the Location object of a square.
     * @return
     */
    public Location getSquaresRowColumnLocation(){
        return this.rowColumnCoordinate;
    }

/* UNUSED METHODS
    public void setSquareToUnvisted(){
        this.wasSquareVisited = false;
    }

    public void setSquareToVisited(){
        this.wasSquareVisited = true;
    }

    public void setSquareAsCurrentNodeInDA(){
        this.isSquareTheCurrentNodeForDA = true;
    }

    public void setSquareAsNOTCurrentNodeInDA(){
        this.isSquareTheCurrentNodeForDA = false;
    }

    public void changeActualDistanceValueForDA(int newDistanceValue){
        this.actualDistanceValue = newDistanceValue;
    }

    public void changePreliminaryDistanceValueForDA(int preliminaryDistanceValue){
        this.preliminaryDistanceValue = preliminaryDistanceValue;
    }*/

    /*
    /**
     * This method accepts a string direction "NORTH" "SOUTH" "EAST" "WEST" and returns if the player or user can move
     * in that
     * @param directionIWishToMove
     * @return
     */
/*
    public boolean canIMoveNorth(String directionIWishToMove){
        if (doesSquareHaveNorthEdgeBarrier() == true){
            return false;
        }
        else{
            return true;
        }

    }

    public boolean canIMoveSouth(String directionIWishToMove){
        if (doesSquareHaveSouthEdgeBarrier() == true){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean canIMoveEast(String directionIWishToMove){
        if (doesSquareHaveEastEdgeBarrier() == true){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean canIMoveWest(String directionIWishToMove){
        if (doesSquareHaveWestEdgeBarrier() == true){
            return false;
        }
        else{
            return true;
        }
    }

*/




}
