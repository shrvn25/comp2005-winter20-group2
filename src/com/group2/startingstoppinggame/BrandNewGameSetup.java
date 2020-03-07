package com.group2.startingstoppinggame;

import com.group2.physicalgameobjects.Player;
import com.group2.physicalgameobjects.Robot;


public class BrandNewGameSetup {
    Player player1, player2, player3, player4, player5;
    Robot redStarRobot, greenSquareRobot, yellowCircleRobot, blueHalfMoonRobot;

    Player playerArray[];
    Robot robotArray[];




    public BrandNewGameSetup(){
        //First create arrays to hold all players and robots
        playerArray = new Player[4];
        robotArray = new Robot[4];

        //First create Player Objects

        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
        player4 = new Player();

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
