
import java.util.Random;

// Fig. 22.5: ListTest.java
// ListTest class to demonstrate List capabilities.

public class ListTest 
{
   public static void main( String[] args )
   {
      Random random = new Random();
       
      SortedList< Integer > list = new SortedList< Integer >(); // create a List

      for(int x = 0; x < 25; ++x)
      {
        // insert integers in list
        list.offerAtFront( random.nextInt(101) );
        list.print();
      }
   } // end main
} // end class ListTest


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
