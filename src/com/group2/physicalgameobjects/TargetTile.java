package com.group2.physicalgameobjects;

import com.group2.physicalgameobjects.Symbols.*;

public class TargetTile {
    Symbol symbol;
    String color;

    public TargetTile(){
        this.symbol = null;
        this.color = "";

    }

    public void addCircleSymbol(){
        this.symbol = new CircleSymbol();
    }

    public void addSquareSymbol(){
        this.symbol = new SquareSymbol();
    }

    public void addHalfMoonSymbol(){
        this.symbol = new HalfMoonSymbol();
    }

    public void addStarSymbol(){
        this.symbol = new StarSymbol();
    }

    public void addRedColor{
        this.color = "RED"
    }
}
