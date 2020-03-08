package com.group2.physicalgameobjects;

import java.util.ArrayList;

public class Player {
//INSTANCE VARIABLES

    private String playerType;
    private String playerName;
    private int location;

    private int playerID;
    private int tokenCount;
    private Robot playersRobot;

    private ArrayList<TargetChip> playersCollectedTargetChips;



    //ArrayList<> //TODO Set up list of movements later

//CONSTRUCTOR
public Player(){
    this.playerName = "";
    this.tokenCount = 0;
    this.playersRobot = new Robot();
    this.playerID = -1;
    this.playersCollectedTargetChips = new ArrayList<TargetChip>();
}
//METHODS

    public String getPlayerType(){
        return this.playerType;
    }

    /*public void setPlayerType(String newPlayerType){
        this.playerType = newPlayerType;
    }*/

    public void setPlayerTypeToHuman(){
        this.playerType = "HUMAN";
    }

    public void setPlayerTypeToComputer(){
        this.playerType = "COMPUTER";
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerName(String newPlayerName){
        this.playerName = newPlayerName;
    }

    public takeTurn(){

    }

    public getPlayersCurrentLocation(){ //TODO RETURN AN ARRAY HERE OF X AND Y COORDINATES

    }

    public void setPlayersRobot(Robot playersNewRobot){
        this.playersRobot = playersNewRobot;
    }

    public Robot getPlayersRobot(){
        return this.playersRobot;
    }

    public void addTargetChipToPlayersCollection(TargetChip wonTargetChip){
        this.playersCollectedTargetChips.add(wonTargetChip);
    }

    public int getNumberOfTargetChipsPlayerHasWon(){
        return this.playersCollectedTargetChips.size();
    }









/* //Leaving out for now
    public Robot getRobot(){
        return this.playersRobot;
    }

    public void changeRobot(Robot newRobot){
        this.playersRobot = newRobot;
    }



    public void changePlayerID( int newID){
        this.playerID = newID;
    }


    public void addOneTokenToCount(){
        this.tokenCount += 1;
    }
*/
}