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
//public class repainttimer that implements runnable interface
public class RepaintTimer implements Runnable
{
   private final JFrame repaintComponent;

   public RepaintTimer( JFrame frame )
   {
      // specify component to be repainted	
      repaintComponent = frame;
   } 
   
   public void run()
   {
      while ( true )
      {
         try
         {
            Thread.sleep( 20 );
         } 
         catch ( InterruptedException ex )
         {
            ex.printStackTrace();
         } 
         
         repaintComponent.repaint(); // repaint the component
     } 
   } 
} 

