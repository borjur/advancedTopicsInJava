/**
 *  Boris Jurosevic
 *  CS 2550
 *  Assignment Networking
 */

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener 
{
   private JTextField fileField; // textfield to input file
   private JTextArea contents; // textarea to display contents
   private Scanner input; // input scanner
   private Formatter output; // output formatter
   private Socket connection; // connection to server
   private JPanel panel; // panel to hold components
   private JLabel label; // label to prompt user
   private JScrollPane scroller; // scroller for textarea

   // set up GUI, connect to server, get streams
   public Client()
   {
      label = new JLabel( "Please enter file name you want to retrieve:" );
      panel = new JPanel(); // create JPanel
      panel.setLayout( new GridLayout( 1, 2, 0, 0 ) );
      panel.add( label ); // add label to panel
      fileField = new JTextField(); // create textfield
      fileField.addActionListener( this ); // add action listener
      panel.add( fileField ); // add textfield to panel
      contents = new JTextArea(); // create textarea
      scroller = new JScrollPane( contents ); // add scrolling
      setLayout( new BorderLayout() ); // set layout of JFrame
      add( panel, BorderLayout.NORTH ); // add panel to north
      add( scroller, BorderLayout.CENTER ); // add scrolling textarea

      try // connect to server, get streams
      {
         // create Socket to make connection to server
         connection = new Socket( InetAddress.getLocalHost(), 5001 );
         output = new Formatter( connection.getOutputStream() );
         output.flush(); // flush output to send header information
         input = new Scanner( connection.getInputStream() );
      } // end try
      catch( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch

      setSize( 400, 200 ); // set window size
      setVisible( true ); // show window
   } // end Client constructor

   // process file name entered by user
   public void actionPerformed( ActionEvent event )
   {
      try // display contents of file
      {
         String fileName = event.getActionCommand() + "\n";
         output.format( fileName );
         output.flush(); // flush output
         String inputLine = input.nextLine(); // read input line
         contents.setText( inputLine ); // show input line in textarea

         // if file exists, display file contents
         if ( inputLine.equals( "The file is:" ) ) 
         {
            while ( input.hasNextLine() ) 
            {
               inputLine = input.nextLine(); // read a new line
               contents.append( inputLine + "\n" ); // add line
            } // end while
         } // end if

         fileField.setEditable( false ); // disable editing
         fileField.setBackground( Color.lightGray ); // set color
         fileField.removeActionListener( this ); // remove listener
      } // end try
      finally
      {
         try
         {
            input.close(); // close output
            output.close(); // close input
            connection.close(); // close connection to server
         }
         catch ( IOException ioException )
         {
            ioException.printStackTrace();
            System.exit( 1 );
         } 
      } 
   } 
} 


