/*
 *  Boris Jurosevic
 *  CS 2550
 *  Assignement 23.8 Drawing Rectangles
 */
import java.awt.*;
import javax.swing.*;

//DrawRectangle class that extends JApplet 
public class DrawRectangle extends JApplet {
	
	//paint
	public void paint (Graphics g){
		
		g.drawRect(5,5,40,50);
		g.drawRect(70,20,20,40);
		g.drawRect(90,100,80,45);
		g.drawRect(120,60,30,30);
	}//end paint
	
	

}//end of Draw Rectangle class
