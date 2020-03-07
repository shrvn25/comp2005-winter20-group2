package com.group2.physicalgameobjects;

public class Token {

    String color;
    String shape;
    int location;

    public Token(String newColor, String newShape){ //TODO I updated signature compared to class diagram.
        this.color = newColor;
        this.shape = newShape;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String newColor){
        this.color = newColor;
    }

    public String getShape(){
        return this.shape;
    }

    public void setShape(String newShape){
        this.shape = newShape;
    }

}
