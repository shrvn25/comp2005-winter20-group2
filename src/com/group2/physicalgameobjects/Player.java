package com.group2.physicalgameobjects;

import java.awt.*;

public class Player {
//INSTANCE VARIABLES

    String playerType;
    String playerName;
    int location;

    int playerID;
    int tokenCount;
    Robot playersRobot;
    //ArrayList<> //TODO Set up list of movements later

//CONSTRUCTOR
public Player(){
    this.playerName = "";
    this.tokenCount = 0;
    this.playersRobot = new Robot();
    this.playerID = -1;
}
//METHODS

    public String getPlayerType(){
        return this.playerType;
    }

    public void setPlayerType(String newPlayerType){
        this.playerType = newPlayerType;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerName(String newPlayerName){
        this.playerName = newPlayerName;
    }

    public takeTurn(){

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