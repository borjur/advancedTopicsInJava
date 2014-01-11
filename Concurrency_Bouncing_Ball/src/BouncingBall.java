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

import javax.swing.JFrame;
//bouncing ball class that exends jframe
public class BouncingBall extends JFrame
{
   private BallPanel ballCanvas; // JPanel in which ball bounces

   public BouncingBall()
   {
      ballCanvas = new BallPanel( this ); // create new BallPanel
      add( ballCanvas ); // add BallPanel to JFrame

      pack(); // make window just large enough for its GUI
      setVisible( true ); // show window
   } 

   public static void main( String args[] )
   {
      BouncingBall application = new BouncingBall();
      application.setDefaultCloseOperation( EXIT_ON_CLOSE );
   } 
} 