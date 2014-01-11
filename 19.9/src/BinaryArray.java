// Fig. 19.4: BinaryArray.java
// Class that contains an array of random integers and a method 
// that uses binary search to find an integer.
import java.util.Random;
import java.util.Arrays;

public class BinaryArray
{
   private int[] data; // array of values
   private static final Random generator = new Random();

   // create array of given size and fill with random integers
   public BinaryArray( int size )
   {
      data = new int[ size ]; // create space for array

      // fill array with random ints in range 10-99
      for ( int i = 0; i < size; i++ )
         data[ i ] = 10 + generator.nextInt( 90 );

      Arrays.sort( data );
   } // end BinaryArray constructor

   private int recursiveBinarySearch(int searchElement, int start, int end)
   {
       int middle = (start + end)/2;
       if(start > end) return -1;
       else if(data[middle] == searchElement) return middle;
       else if(data[middle] > searchElement) return recursiveBinarySearch(searchElement, start, middle-1);
       else return recursiveBinarySearch(searchElement, middle+1, end);
   }
   
   // perform a binary search on the data
   public int binarySearch( int searchElement )
   {
      return recursiveBinarySearch(searchElement, 0, data.length - 1);
   } // end method binarySearch

   // method to output certain values in array
   public String remainingElements( int low, int high )
   {
      StringBuilder temporary = new StringBuilder();

      // output spaces for alignment
      for ( int i = 0; i < low; i++ )
         temporary.append( "   " );

      // output elements left in array
      for ( int i = low; i <= high; i++ )
         temporary.append( data[ i ] + " " );

      temporary.append( "\n" );
      return temporary.toString();
   } // end method remainingElements

   // method to output values in array
   public String toString()
   {
      return remainingElements( 0, data.length - 1 );
   } // end method toString   
} // end class BinaryArray


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/