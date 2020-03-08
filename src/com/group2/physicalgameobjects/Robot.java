package com.group2.physicalgameobjects;

public class Robot {
    private String color;
    private String shape;

    public Robot(String newColor, String newShape){ //TODO this is new now with color and shape inputs
        this.color = newColor;
        this.shape = newShape;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String newColor){
        this.color = color;
    }

    public String getShape(){
        return this.shape;
    }

    public void setShape(String newShape){
        this.shape = newShape;
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




}