/**
 * Boris Jurosevic
 * CS 2550
 * Assignment Concurrency 
 * Bouncing Ball
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JPanel;
import javax.swing.JFrame;
//ball panel class that exnteds jpanel
public class BallPanel extends JPanel
{
   private Ball blueBall; // bouncing ball
   private ExecutorService threadExecutor; // for running Ball runnable
   private JFrame parentWindow; // parent window of JPanel
   private final int MAX_X = 200; // horizontal edge of JPanel
   private final int MAX_Y = 200; // vertical edge of JPanel

   public BallPanel( JFrame window )
   {
      parentWindow = window; // set parent window of JPanel

      // create ExecutorService for running ball runnable
      threadExecutor = Executors.newCachedThreadPool();

      // let BallPanel be its own MouseListener
      addMouseListener( 
         new MouseAdapter() 
         {
            public void mousePressed( MouseEvent event ) 
            {
               createBall( event ); // delegate call to ball starter
               RepaintTimer timer = new RepaintTimer( parentWindow );
               threadExecutor.execute( timer );
            } 
         } 
      ); 
   } 

   // create a ball and set it in motion if no ball exists
   private void createBall( MouseEvent event )
   {
      if ( blueBall == null ) // if no ball exists
      {
         int x = event.getX(); // get x position of mouse press
         int y = event.getY(); // get y position of mouse press
         blueBall = new Ball( x, y ); // create new ball
         threadExecutor.execute( blueBall ); // set ball in motion
      } 
   } 

   // return minimum size of animation
   public Dimension getMinimumSize()
   { 
      return getPreferredSize(); 
   } 

   // return preferred size of animation
   public Dimension getPreferredSize()
   {
      return new Dimension( MAX_X, MAX_Y );
   } 

   // draw ball at current position
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      if ( blueBall != null ) // if ball exists
      {
         g.setColor( Color.blue ); // set color to blue
         g.fillOval( blueBall.getX(), blueBall.getY(), 20, 20 ); // draws
      } 
   } 
} 