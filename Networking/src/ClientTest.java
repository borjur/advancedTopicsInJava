/**
 *  Boris Jurosevic
 *  CS 2550
 *  Assignment Networking
 */
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class ClientTest
{
   public static void main( String args[] )
   {
	   
	  SwingUtilities.invokeLater(new Runnable(){
		  
	 public void run(){
	  
      Client application = new Client(); // create client application
      
      
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
	  }
   });
}
}