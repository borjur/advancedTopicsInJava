/**
 * Boris Jurosevic
 * CS 2550
 * Assignment Concurrency 
 * Bouncing Ball
 */

import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Create a ball to bounce around a JPanel.
import java.util.Random;
//public class ball implements runnable
public class Ball implements Runnable
{
private boolean xUp; // controls whether ball is moving up or down
private boolean yUp; // controls whether ball is moving left or right
private int x; // horizontal position of ball
private int y; // vertical position of ball
private int xDx; // change in horizontal position of ball
private int yDy; // change in vertical position of ball
private final int MAX_X = 200; // horizontal edge of JPanel
private final int MAX_Y = 200; // vertical edge of JPanel
private Random generator = new Random();

public Ball( int xPos, int yPos )
{
   xUp = false; // set ball to moving left
   yUp = false; // set ball to moving up
   xDx = generator.nextInt( 5 ) + 1; // change in x (1-5 pixels)
   yDy = generator.nextInt( 5 ) + 1; // change in y (1-5 pixels)
   x = xPos; // set ball to horizontal position of mouse press
   y = yPos; // set ball to vertical position of mouse press
} 

// bounces ball perpetually until window is closed
public void run()
{
   while ( true ) // infinite loop
   {
      try 
      {
         Thread.sleep( 20 ); // sleep for 20 milliseconds
      } // end try
      // process InterruptedException during sleep
      catch ( InterruptedException exception ) 
      {
         exception.printStackTrace();
      } // end catch

      // determine new x-position
      if ( xUp == true )
         x += xDx; // move ball right
      else
         x -= xDx; // move ball left

      // determine new y-position
      if ( yUp == true )
         y += yDy; // move ball down
      else
         y -= yDy; // move ball up

      if ( y <= 0 ) // if bounce off top of JPanel
         yUp = true; // ball is moving down
      else if ( y >= MAX_Y - 10 ) // if bounce off bottom of JPanel
         yUp = false; // ball is moving up

      if ( x <= 0 ) // if bounce off right of JPanel
         xUp = true; // ball is moving right
      else if ( x >= MAX_X - 10 ) // if bounce off left of JPanel
         xUp = false; // ball is moving left 
   }  
} 

// get horizontal position of ball
public int getX()
{
   return x; 
} 

// get vertical position of ball
public int getY()
{
   return y; 
} 
} 



