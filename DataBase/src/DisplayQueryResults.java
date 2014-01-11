/**
 * Boris Jurosevic
 * CS 2550
 * Assignment DataBase
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class DisplayQueryResults extends JFrame 
{
   // JDBC driver and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DATABASE_URL = "jdbc:mysql://localhost/books";
   static final String USERNAME = "root";
   static final String PASSWORD = "tuzla801";
   
   // default query retrieves all data from authors table
   static final String DEFAULT_QUERY = "SELECT * FROM authors";
   
   private ResultSetTableModel tableModel;
   private JTable table;
   private JComboBox inputQuery;
   private JButton submitQuery;
   private JTextField input;
    
   public DisplayQueryResults() 
   {   
      super( "Select Query. Click Submit to See Results." );

      // create ResultSetTableModel with default JDBC driver, 
      // database URL and query
      try 
      {
         // create TableModel for results of query SELECT * FROM authors
         tableModel = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL, 
            USERNAME, PASSWORD, DEFAULT_QUERY );
      } // end try
      catch ( ClassNotFoundException cnfex ) 
      {
         System.err.println( "Failed to load JDBC driver." );
         cnfex.printStackTrace();
         System.exit( 1 );  // terminate program
      } // end catch
      catch ( SQLException sqlex ) 
      {
         System.err.println( "Unable to connect" );
         sqlex.printStackTrace();
         System.exit( 1 );  // terminate program
      } 

      String names[] = { "All authors", "All titles", 
         "A specific author", "A specific title" };

      // if connected to database, set up GUI      
      inputQuery = new JComboBox( names );

      submitQuery = new JButton( "Submit query" );
      submitQuery.addActionListener(
         new ActionListener() 
         {
            public void actionPerformed( ActionEvent e ) 
            {
               getTable();
            } 
         } 
      ); 

      JPanel topPanel = new JPanel();
      input = new JTextField( 20 ); // for user input query
      input.addActionListener(
         new ActionListener() 
         {
            public void actionPerformed( ActionEvent e )
            {
               try 
               {
                  String query = input.getText();
                  tableModel.setQuery( query );
               } // end try
               catch ( SQLException sqlex ) 
               {
                  sqlex.printStackTrace();
               } // end catch
            } 
         } 
      ); 
   
      JPanel centerPanel = new JPanel();
      centerPanel.setLayout( new FlowLayout() );
      centerPanel.add( new JLabel( "Please enter your query, author or title:" ) );
      centerPanel.add( input );
      topPanel.setLayout( new BorderLayout() );
      topPanel.add( inputQuery, BorderLayout.NORTH );
      topPanel.add( centerPanel, BorderLayout.CENTER );
      topPanel.add( submitQuery, BorderLayout.SOUTH );
 
      table = new JTable( tableModel );

      // set up GUI
      setLayout( new BorderLayout() );
      add( topPanel, BorderLayout.NORTH );
      add( new JScrollPane( table ), BorderLayout.CENTER );      
      getTable();
      setSize( 500, 500 );
      setVisible( true );

      // dispose of window when user quits application (this overrides
      // the default of HIDE_ON_CLOSE)
      setDefaultCloseOperation( DISPOSE_ON_CLOSE );
      
      // ensure database connection is closed when user quits application
      addWindowListener(
         new WindowAdapter() 
         {
            // disconnect from database and exit when window has closed
            public void windowClosed( WindowEvent event )
            {
               tableModel.disconnectFromDatabase();
               System.exit( 0 );
            } 
         } 
      ); 
   } 

   // execute query and display result in table
   private void getTable()
   {        
      try 
      {
         int selection = inputQuery.getSelectedIndex();
         String query = null;

         // execute predefined query
         switch ( selection ) 
         {
            case 0:
               query = "SELECT * FROM authors";
               break;
            case 1:
               query = "SELECT * FROM titles";
               break;
            case 2:
               query = "SELECT authors.lastName, authors.firstName, "+
                  "titles.title, titles.isbn FROM " +
                  "titles INNER JOIN (authorISBN INNER JOIN authors ON" +
                  " authorISBN.authorID = authors.authorID) ON " +
                  "titles.isbn = authorISBN.isbn WHERE authors.lastName" +
                  " = '" + input.getText() + "' ORDER BY " +
                  "authors.lastName, authors.firstName ASC";
                  break;
            case 3:
               query = "SELECT titles.isbn, titles.title, " +
                  "authors.lastName, authors.firstName FROM titles " +
                  "INNER JOIN (authorISBN INNER JOIN authors ON " +
                  "authorISBN.authorID = authors.authorID) ON " +
                  "titles.ISBN = authorISBN.ISBN WHERE titles.title = '" +
                  input.getText() + "' ORDER BY authors.lastName, " +
                  "authors.firstName ASC";
                  break;
         } // end switch
           
         tableModel.setQuery( query );
      } // end try
      catch ( SQLException sqlex ) 
      {
         sqlex.printStackTrace();

         // recover from invalid query by executing default query
         try 
         {
            tableModel.setQuery( DEFAULT_QUERY );
            inputQuery.setSelectedIndex( 0 );
         } // end try
         catch ( SQLException sqlException2 ) 
         {
            sqlException2.printStackTrace();
            tableModel.disconnectFromDatabase(); // close connection
            System.exit( 1 ); // terminate application
         }                    
      } 
   } 

   public static void main( String args[] ) 
   {
      DisplayQueryResults app = new DisplayQueryResults();
   } 
} 