package com.group2.physicalgameobjects;

import java.util.List;

public class Square {
    private int rowColumnCoordinate[][];
    private List listOfItemsOnSquare; //Because you can store different data types in an we need to make a list instead of arraylist(Like barrier and if a robot is on it or not). Designate a index in the array for something.
    //Robot robotOnSquare;
    private boolean robotIsOnSquare;
    private boolean squareIsATargetTile;
    private SquareEdgeBarrier northEdgeBarrier, southEdgeBarrier, eastEdgeBarrier, westEdgeBarrier;



    public Square(int rowCoordinate, int columnCoordinate){
        //Default is that there is nothing on the square at first, you have to add to it.

        rowColumnCoordinate = new int[rowCoordinate][columnCoordinate];
        listOfItemsOnSquare = new List;

        for (int i = 0; i < 4; i++) { //Three spaces for barrier in first index, targetsquare in second, and robotsquare in third.
            //Add null object to all of these now //TODO Is this correct?
            listOfItemsOnSquare.add(null);
        }

        robotIsOnSquare = false;
        squareIsATargetTile = false;

        northEdgeBarrier = null;
        southEdgeBarrier = null;
        eastEdgeBarrier = null;
        westEdgeBarrier = null;

    }

    public addRobotToSquare(Robot newRobot){
        robotIsOnSquare = true;
        listOfItemsOnSquare.add(2, newRobot);
    }

    public boolean isRobotOnSquare(){
        if (robotIsOnSquare == true){
            return true;
        }
        else{
            return false;
        }
    }

    public Robot getRobotOnSquare(){
        Robot robotToReturn = (Robot) listOfItemsOnSquare.get(2);//TODO IS THIS OK????? CASTING HERE????
        return robotToReturn;
    }

    public void removeRobotFromSquare(){
        robotIsOnSquare = false;
        listOfItemsOnSquare.set(2, null);

    }

    /*public addBarrierToSquare(){

    }*/ //This is later with a complex board.

    public void addTargetSquareToSquare(TargetTile newTargetTile){

        listOfItemsOnSquare.add(1, newTargetTile);
    }

    public boolean isSquareATargetTile(){
        if (squareIsATargetTile == true){
            return true;
        }
        else{
            return false;
        }
    }

    public void addNorthEdgeBarrier(){//TODO may need to tweak later
        this.northEdgeBarrier = new SquareEdgeBarrier();
    }

    public void addSouthEdgeBarrier(){
        this.southEdgeBarrier = new SquareEdgeBarrier();
    }

    public void addEastEdgeBarrier(){
        this.eastEdgeBarrier = new SquareEdgeBarrier();
    }

    public void addWestEdgeBarrier(){
        this.westEdgeBarrier = new SquareEdgeBarrier();
    }

    public boolean doesSquareHaveNorthEdgeBarrier(){

    }

    public boolean doesSquareHaveSouthEdgeBarrier(){

    }
    public boolean doesSquareHaveEastEdgeBarrier(){

    }
    public boolean doesSquareHaveWestEdgeBarrier(){

    }




}
