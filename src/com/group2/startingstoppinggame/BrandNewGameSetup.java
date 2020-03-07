package com.group2.startingstoppinggame;

import com.group2.gui.GameSettings;
import com.group2.physicalgameobjects.Player;
import com.group2.physicalgameobjects.Robot;
import com.group2.*;


public class BrandNewGameSetup {
    Player player1, player2, player3, player4, player5;
    Robot redStarRobot, greenSquareRobot, yellowCircleRobot, blueHalfMoonRobot;

    Player playerArray[];
    Robot robotArray[];




    public BrandNewGameSetup(GameSettings theRecordedGameSettings){
        //First create arrays to hold all players and robots
        playerArray = new Player[4];
        robotArray = new Robot[4];

        //First create Player Objects

        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
        player4 = new Player();

        //Get all of the players' recorded type, and then
        //change the player type of these players according to what is recorded in the GameSettings class.

        int player1sRecordedType = theRecordedGameSettings.getRecordedPlayer1PlayerType();
        int player2sRecordedType = theRecordedGameSettings.getRecordedPlayer2PlayerType();
        int player3sRecordedType = theRecordedGameSettings.getRecordedPlayer3PlayerType();
        int player4sRecordedType = theRecordedGameSettings.getRecordedPlayer4PlayerType();

        if (theRecordedGameSettings.player1PlayerTypeisHuman()){
            player1.setPlayerTypeToHuman();
        }
        else{
            player1.setPlayerTypeToComputer();
        }

        if (theRecordedGameSettings.player2PlayerTypeisHuman()){
            player2.setPlayerTypeToHuman();
        }
        else{
            player2.setPlayerTypeToComputer();
        }

        if (theRecordedGameSettings.player2PlayerTypeisHuman()){
            player2.setPlayerTypeToHuman();
        }
        else{
            player2.setPlayerTypeToComputer();
        }


        makePlayerComputer();

        //Then put these players into the player array.
        playerArray[0] = player1;
        playerArray[1] = player2;
        playerArray[2] = player3;
        playerArray[3] = player4;




        //Next create robot objects.
        redStarRobot = new Robot("RED", "STAR");
        greenSquareRobot = new Robot("GREEN", "SQUARE");
        yellowCircleRobot = new Robot("YELLOW", "CIRCLE");
        blueHalfMoonRobot = new Robot("BLUE", "HALFMOON");

        //Then put these robots into the robot array.
        robotArray[0] = redStarRobot;
        robotArray[1] = greenSquareRobot;
        robotArray[2] = yellowCircleRobot;
        robotArray[3] = blueHalfMoonRobot;

    }

    public createAllNewPlayers(){

    }

    public createAllRobots(){

    }
    public createAllTokens(){

    }


}
