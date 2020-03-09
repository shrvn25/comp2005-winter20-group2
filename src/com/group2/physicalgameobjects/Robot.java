package com.group2.physicalgameobjects;


/**
 * This class represents a physical robot. It can have four different colors, four different shapes to help those
 * who are visually impaired.
 */
public class Robot {
    private String color;
    private String shape;
    private //TODO ROBOT MOVEMENT DIRECTION?
    private int [][] robotsRowColumnLocation;

    /**
     * When the robot is first made, it must be provided with a Color and a Shape.
     */

    public Robot(String newColor, String newShape, int rowLocation, int columnLocation){ //TODO this is new now with color and shape inputs
        this.color = newColor;
        this.shape = newShape;
        this.robotsRowColumnLocation = new int[rowLocation][columnLocation];
    }

    /**
     * Return the color of Robot.
     * @return
     */

    public String getColor(){
        return this.color;
    }

    /**
     * Set the color of the robot.
     * @param newColor
     */

    public void setColor(String newColor){
        this.color = color;
    }

    /**
     * Get the shape of the robot.
     * @return
     */

    public String getShape(){
        return this.shape;
    }

    /**
     * Set the shape of the robot.
     * @param newShape
     */

    public void setShape(String newShape){
        this.shape = newShape;
    }

    public int[][] getCurrentRowColumnLocation(){
        return this.robotsRowColumnLocation;
    }



/* Originally there
    private static final Color[] robotColours = {
            new Color(245, 99, 99), //Color.RED,
            new Color(99, 245, 99), //Color.GREEN,
            new Color(99, 99, 245), //Color.BLUE,
            new Color(245, 245, 99),//Color.YELLOW,
    };
    public static final String[] robotShapes = {
            "circle", "triangle", "square", "hexagon"
    };

 */

    public String getImageFileLocation(){

    }

    public setImageFileLocation(String imageFileLocation){

    }




}