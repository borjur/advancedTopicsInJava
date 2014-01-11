/**
 *  Boris Jurosevic
 *  CS 2550
 *  Assignment Networking
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Server 
{
   private ServerSocket server; // server socket
   private Socket connection; // connection to a client
   private Scanner input; // input scanner
   private Formatter output; // output formatter

   // constructor
   public Server()
   {
      try 
      {
         server = new ServerSocket( 5001, 10 ); // create ServerSocket
      } // end try
      catch ( IOException exception ) 
      {
         exception.printStackTrace();
         System.exit( 0 );
      } // end catch
   } // end Server constructor

   // run server
   public void runServer()
   {
      try // wait for connection, get streams, read file
      {
         connection = server.accept(); // accept connection
         output = new Formatter( connection.getOutputStream() );
         output.flush(); // flush output to send header information
         input = new Scanner( connection.getInputStream() );
         File file = new File( input.nextLine() ); // get file name
         String result; // result from checking file

         // file does exist
         if ( file.exists() ) 
         { 
            Scanner fileInput = new Scanner( file ); // file scanner
            output.format( "The file is:\n" ); // write header
            output.flush(); // flush output

            while ( fileInput.hasNextLine() )
            {
               result = fileInput.nextLine(); // read a line from file
               output.format( "%s\n", result ); // output line of file
               output.flush(); // flush output
            } // end while
         } // end if
         else // file does not exist
         {
        	 //result = file.getAbsolutePath() + " does not exist\n";

            result = file.getName() + " does not exist\n";
            output.format( result ); // write that file does not exist
            output.flush(); // flush output
         } // end else
      } // end try
      catch( IOException ioException ) 
      {
         ioException.printStackTrace();
         System.exit( 0 );
      } // end catch
      finally
      {
         try
         {
            output.close(); // close output
            input.close(); // close input
            connection.close(); // close connection to client
         } // end try
         catch ( IOException ioException )
         {
            ioException.printStackTrace();
            System.exit( 0 );
         } 
      } 
   } 
} 