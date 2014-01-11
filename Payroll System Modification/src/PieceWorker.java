/**
 * 
 * @author Boris Jurosevic
 * Assignment Payroll System Notification
 * CS 2550
 */
public final class PieceWorker extends Employee {
   
   //pieceworker variables wage and quantity
   private double wage; 
   private int quantity;        

   // Constructor for class PieceWorker
   public PieceWorker( String first, String last,
                       double x, int y )
   {
      super( first, last );  // call superclass constructor
      setWage( x );
      setQuantity( y );
   }
   
   // Set wage method
   public void setWage( double x ) 
      { wage = ( x > 0 ? x : 0 ); }
   
   // Set quantity method
   public void setQuantity( int y ) 
      { quantity = ( y > 0 ? y : 0 ); }
   
   // earnings method
   public double earnings()
      { return quantity * wage; }
   
   public String toString()
   {
      return "Piece worker: " + super.toString();
   }  
}