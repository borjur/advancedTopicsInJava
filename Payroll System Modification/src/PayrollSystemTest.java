/**
 * 
 * @author Boris Jurosevic
 * Assignment Payroll System Notification
 * CS 2550
 */


public class PayrollSystemTest 
{
   public static void main( String[] args ) 
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = new SalariedEmployee( "Boris", "Jurosevic", "801-233-343", 214.00 );
      HourlyEmployee hourlyEmployee = new HourlyEmployee( "Wade", "Peeler", "801-221-2332", 10.25, 20 );
      CommissionEmployee commissionEmployee = new CommissionEmployee( "George", "Bush", "801-323-2323", 12000, .03 );
      BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee( "Michael", "Jordan", "312-332-8886", 4000, .07, 800 );

      
      
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         salariedEmployee, "hasearned", salariedEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "has earned", hourlyEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         commissionEmployee, "has earned", commissionEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         basePlusCommissionEmployee, 
         "has earned", basePlusCommissionEmployee.earnings() );

      // this is four element array
      Employee[] employees = new Employee[ 4 ]; 

      // initialize empolyee arrays
      employees[ 0 ] = salariedEmployee;
      employees[ 1 ] = hourlyEmployee;
      employees[ 2 ] = commissionEmployee; 
      employees[ 3 ] = basePlusCommissionEmployee;


      // for loop for each elemenet for array
      for ( Employee currentEmployee : employees ) 
      {
         System.out.println( currentEmployee ); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if ( currentEmployee instanceof BasePlusCommissionEmployee ) 
         {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
               ( BasePlusCommissionEmployee ) currentEmployee;

            employee.setBaseSalary( 2.20 * employee.getBaseSalary() );

            System.out.printf( 
               "new base salary with 10%% increase is: $%,.2f\n",
               employee.getBaseSalary() );
         } // end if

         System.out.printf( 
            "earned $%,.2f\n\n", currentEmployee.earnings() );
      } // end for

      // get type name of each object in employees array
      for ( int j = 0; j < employees.length; j++ )
         System.out.printf( "this employee %d is a %s\n", j, 
            employees[ j ].getClass().getName() ); 
   } 
}
