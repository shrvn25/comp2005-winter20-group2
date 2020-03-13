import java.awt.Color;

import javax.swing.*;

/*
 *  a simple extension of JButton which allows the background colour to be set and switched back and forth with ease
 *  
 *  there are other ways of doing this, but it's a neat way to demonstrate how to create your own gui components
 *  (as well as how to use ternary operators)
 */
public class GridSquare extends JButton
{
    private int xcoord, ycoord;         // not used in this demo, but might be helpful in future...
    private int up, down, left, right;
    // constructor takes the x and y coordinates of this square
    public GridSquare( int xcoord, int ycoord)
    {
        super();
        this.setSize(50,50);
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }
    
    // if the decider is even, it chooses black, otherwise white (for 'column+row' will allow a chequerboard effect)
    public void setColor( int decider)
    {
        Color colour = (int) (decider/2.0) == (decider/2.0) ? Color.WHITE : Color.white;
        this.setBackground( colour);
    }
    
    // if the square s black it becomes white, and vice-versa
    public void switchColor()
    {
        Color colour =Color.white;
        this.setBackground( colour);
    }
    
    public void border()
    {
        //border to the top
        this.setBorder(BorderFactory.createMatteBorder(0,0,0,4,Color.black));
        //border to the bottom
        this.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.black));
        //border to the left
        this.setBorder(BorderFactory.createMatteBorder(0,4,0,0,Color.black));
        //border to the right
        this.setBorder(BorderFactory.createMatteBorder(0,0,4,0,Color.black));
    }
    public void setIcon()
    {   
        //blue icons
        Icon blueCircle =new ImageIcon("bluecircle.jpg");
        Icon blueHex =new ImageIcon("blueHex.jpg");
        Icon blueSquare =new ImageIcon("blueSquare.jpg");
        Icon blueTriangle =new ImageIcon("blueTriangle.jpg");
        //green icons
        Icon greenCircle =new ImageIcon("greencircle.jpg");
        Icon greenHex =new ImageIcon("greenhex.jpg");
        Icon greenSquare =new ImageIcon("greensquare.jpg");
        Icon greenTriangle =new ImageIcon("greentriangle.jpg");
        //red icons
        Icon redCricle =new ImageIcon("redcircle.jpg");
        Icon redHex =new ImageIcon("redhex.jpg");
        Icon redSquare =new ImageIcon("redsquare.jpg");
        Icon redTriangle =new ImageIcon("redtriangle.jpg");
        //yellow icons
        Icon yellowCricle =new ImageIcon("redcircle.jpg");
        Icon yellowHex =new ImageIcon("redhex.jpg");
        Icon yellowSquare =new ImageIcon("redsquare.jpg");
        Icon yellowTriangle =new ImageIcon("redtriangle.jpg");
        
        //jButton1.setIcon(i);


    }
}