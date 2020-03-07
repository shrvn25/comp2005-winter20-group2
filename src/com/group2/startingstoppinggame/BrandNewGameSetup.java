package com.group2.startingstoppinggame;

import com.group2.gui.GameSettings;
import com.group2.physicalgameobjects.Player;
import com.group2.physicalgameobjects.Robot;
import com.group2.physicalgameobjects.TargetChip;


public class BrandNewGameSetup {
    Player player1, player2, player3, player4, player5;
    Robot redStarRobot, greenSquareRobot, yellowCircleRobot, blueHalfMoonRobot;
    TargetChip redStarTargetChip, redCircleTargetChip, redSquareTargetChip, redHalfMoonTargetChip;
    TargetChip greenStarTargetChip, greenCircleTargetChip, greenSquareTargetChip, greenHalfMoonTargetChip;
    TargetChip yellowStarTargetChip, yellowCircleTargetChip, yellowSquareTargetChip, yellowHalfMoonTargetChip;
    TargetChip blueStarTargetChip, blueCircleTargetChip, blueSquareTargetChip, blueHalfMoonTargetChip;
    TargetChip multicoloredTargetChip;
    CurrentGamePlay theCurrentGameplay;

    Player playerArray[];
    Robot robotArray[];
    TargetChip arrayOfAllTargetChipsInGame[];
    TargetChip arrayOfShuffledTargetChipsToBeDrawn[];//TODO Maybe Arraylist Later for easy popping




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

        //Player 1
        if (theRecordedGameSettings.player1PlayerTypeisHuman()){
            player1.setPlayerTypeToHuman();
        }
        else{
            player1.setPlayerTypeToComputer();
        }
        //Player 2
        if (theRecordedGameSettings.player2PlayerTypeisHuman()){
            player2.setPlayerTypeToHuman();
        }
        else{
            player2.setPlayerTypeToComputer();
        }
        //Player 3
        if (theRecordedGameSettings.player3PlayerTypeisHuman()){
            player3.setPlayerTypeToHuman();
        }
        else{
            player3.setPlayerTypeToComputer();
        }

        //Player 4
        if (theRecordedGameSettings.player3PlayerTypeisHuman()){
            player4.setPlayerTypeToHuman();
        }
        else{
            player4.setPlayerTypeToComputer();
        }

        //Generate the array of all tokens in the game //TODO token to targetChips
        //TODO Are these target chips designed correctly?

        redStarTargetChip = new TargetChip("RED", "STAR");
        redCircleTargetChip = new TargetChip("RED", "CIRCLE");
        redSquareTargetChip = new TargetChip("RED", "SQUARE");
        redHalfMoonTargetChip = new TargetChip("RED", "HALFMOON");

        greenStarTargetChip = new TargetChip("GREEN", "STAR");
        greenCircleTargetChip = new TargetChip("GREEN", "CIRCLE");
        greenSquareTargetChip = new TargetChip("GREEN", "SQUARE");
        greenHalfMoonTargetChip = new TargetChip("GREEN", "HALFMOON");

        yellowStarTargetChip = new TargetChip("YELLOW", "STAR");
        yellowCircleTargetChip = new TargetChip("YELLOW", "CIRCLE");
        yellowSquareTargetChip = new TargetChip("YELLOW", "SQUARE");
        yellowHalfMoonTargetChip = new TargetChip("YELLOW", "HALFMOON");

        blueStarTargetChip = new TargetChip("BLUE", "STAR");
        blueCircleTargetChip = new TargetChip("BLUE", "CIRCLE");
        blueSquareTargetChip = new TargetChip("BLUE", "SQUARE");
        blueHalfMoonTargetChip = new TargetChip("BLUE", "HALFMOON");

        multicoloredTargetChip = new TargetChip("MULTICOLOR", "VORTEX");



        //Declare array for all chips, and add all these chip objects to this array.
        arrayOfAllTargetChipsInGame[17];

        arrayOfAllTargetChipsInGame[0] = redStarTargetChip;
        arrayOfAllTargetChipsInGame[1] = redCircleTargetChip;
        arrayOfAllTargetChipsInGame[2] = redSquareTargetChip;
        arrayOfAllTargetChipsInGame[3] = redHalfMoonTargetChip;

        arrayOfAllTargetChipsInGame[4] = greenStarTargetChip;
        arrayOfAllTargetChipsInGame[5] = greenCircleTargetChip;
        arrayOfAllTargetChipsInGame[6] = greenSquareTargetChip;
        arrayOfAllTargetChipsInGame[7] = greenHalfMoonTargetChip;

        arrayOfAllTargetChipsInGame[8] = yellowStarTargetChip;
        arrayOfAllTargetChipsInGame[9] = yellowCircleTargetChip;
        arrayOfAllTargetChipsInGame[10] = yellowSquareTargetChip;
        arrayOfAllTargetChipsInGame[11] = yellowHalfMoonTargetChip;

        arrayOfAllTargetChipsInGame[12] = blueStarTargetChip;
        arrayOfAllTargetChipsInGame[13] = blueCircleTargetChip;
        arrayOfAllTargetChipsInGame[14] = blueSquareTargetChip;
        arrayOfAllTargetChipsInGame[15] = blueHalfMoonTargetChip;

        arrayOfAllTargetChipsInGame[16] = multicoloredTargetChip;



        //Randomize the tokens for the gameplay order. //TODO Randomize the tokens for the gameplay order and put them into the arrayOfShuffledTargetChipsToBeDrawn.
        //TODO Right now these are in the same order. REMEMBER ABOUT COPYING ARRAY"S IT"S WIERD, IT EDITS ITSELF! DEEP COPY!

        for (int i = 0; i < arrayOfAllTargetChipsInGame.length; i++){
            arrayOfShuffledTargetChipsToBeDrawn[i] = arrayOfAllTargetChipsInGame[i]; //TODO I THINK THIS IS CORRECT, CHECK IT WILL NOT CHANGE ORIGINAL ARRAY OF ALL TARGET CHIPS.
        }//TODO Does multicolored vortex chip need to be in list?


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

        //Set up the locations of all robots for each player

        //Then put these robots into the robot array.
        robotArray[0] = redStarRobot;
        robotArray[1] = greenSquareRobot;
        robotArray[2] = yellowCircleRobot;
        robotArray[3] = blueHalfMoonRobot;

        //Hook up players with their robots //TODO This may need to be fixed.
        player1.setPlayersRobot(robotArray[0]);//Player 1 is always with the red star robot
        player2.setPlayersRobot(robotArray[1]);//Player 2 is always with the green star robot
        player3.setPlayersRobot(robotArray[2]);//Player 3 is always with the yellow circle robot
        player4.setPlayersRobot(robotArray[3]);//Player 4 is always with the blue half moon robot


        //FINALLY, pass the arrays of players, the robots, the random tokens to pull from, and the board,
        //to the object that will deal with the current gameplay, called CurrentGameplay.

        //TODO FInish creating and giving current gameplay the stuff.

        theCurrentGameplay = newCurrentGamePlay(playerArray, arrayOfAllTargetChipsInGame, board);

    }

    public createAllNewPlayers(){

    }

    public createAllRobots(){

    }
    public createAllTokens(){

    }


}
