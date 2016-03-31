import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class TableSetup {

	 private Connection connect = null;
	 private Statement statement = null;
	
	public void createDataBase() throws Exception {
	    try {
			      // This will load the MySQL driver, each DB has its own driver
			      Class.forName("com.mysql.jdbc.Driver");
			      // Setup the connection with the DB
			      connect = DriverManager
			          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
			              + "user=root&password=jamesp");
			      
			      //create table
			    
			      statement = connect.createStatement();
			      
			     String sql = "CREATE TABLE svall_user_details (UserName varchar(5) NOT NULL, Password varchar(15) NOT NULL,PRIMARY KEY(UserName))";
			     			     
			      statement.executeUpdate(sql);
			      
			      
			      System.out.println("Table svall_user_details has been created");
			      
			      
			      statement = connect.createStatement();
			      
				  sql = "CREATE TABLE svall_ticket_details(ID int NOT NULL AUTO_INCREMENT,TicketID varchar(10) NOT NULL,TicketDescription varchar(100) NOT NULL, AssignedTo varchar(30) NOT NULL, AssignedBy  varchar(30) NOT NULL,  TicketStat varchar(30) NOT NULL,TicketCreatedDate varchar(10) not null, TicketEndDate varchar(10) NOT NULL,  IssueType varchar(35) NOT NULL, PRIMARY KEY (ID), CONSTRAINT  svallioo_c2 FOREIGN KEY (AssignedBy) REFERENCES svall_user_details(UserName))";				     			     
				  statement.executeUpdate(sql);			      			    			    
			    
			      System.out.println("Table svall_ticket_details has been created");
			      
			      statement = connect.createStatement();
			      sql = "CREATE TABLE svall_status_types(StatID int NOT NULL,StatType varchar(30) NOT NULL)";
			      statement.executeUpdate(sql);
		
			      System.out.println("Table svall_status_types has been created");
			      
			      /*statement = connect.createStatement();
			      sql = "CREATE TABLE svallioo_ticketstat(StatID int NOT NULL,StatType varchar(30) NOT NULL)";
			      statement.executeUpdate(sql);*/
			      
			      statement = connect.createStatement();
			      sql = "CREATE TABLE svall_issue_types(IssueID int(11) NOT NULL,IssueType varchar(30) NOT NULL)";
			      statement.executeUpdate(sql);
			      
			      System.out.println("Table svall_issue_types has been created");
			      
				//end create table
	    	 } catch (Exception e) {
	    		 	System.out.println(e.getMessage());  
	    	 }  	    
	    }
	
	
	
	
	  // Insert records to the table in sql
	  public void insertIntoDataBase() throws Exception {
		    try {
		    	 // This will load the MySQL driver, each DB has its own driver
		       Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			 connect = DriverManager
					 .getConnection("jdbc:mysql://74.94.99.101/tickets?"
				              + "user=root&password=jamesp");
				      
		    	  System.out.println("Inserting records into the table...");
		         statement = connect.createStatement();
	
		         String sql =  "insert into svall_user_details values('John','ItmRock5')";
		         statement.executeUpdate(sql);
		         
		         sql =  " insert into svall_user_details values('Raj','Drummer5')";
		         statement.executeUpdate(sql);		         
		         
		         System.out.println("Inserted records into the table svall_user_details");
		         
		         sql =  "insert into svall_issue_types values(0,'WIFI ISSUE')";
		         statement.executeUpdate(sql);
		         
		         sql =  "insert into svall_issue_types values(1,'CORRUPT SOFTWARE')";
		         statement.executeUpdate(sql);
		         
		         sql =  "insert into svall_issue_types values(2,'SYSTEM FAILURE');";
		         statement.executeUpdate(sql);
		         
		         System.out.println("Inserted records into the table svall_issue_types");
		         
		         		         		        
		         sql =  "insert into svall_status_types values(0,'OPEN')";
		         statement.executeUpdate(sql);
		         
		         sql = "insert into svall_status_types values(1,'CLOSE')";
		         statement.executeUpdate(sql);
		         
		         sql = "insert into svall_status_types values(2,'WORKING')";
		         statement.executeUpdate(sql);
		         
		         sql = "insert into svall_status_types values(1,'CLOSE')";
		         statement.executeUpdate(sql);
		         
		         sql = "insert into svall_status_types values(3,'VOID')";
		         statement.executeUpdate(sql);
		         
		         System.out.println("Inserted records into the table svall_status_types");
				      
		
			  } catch (Exception e) {
			    System.out.println(e.getMessage());  
			  }  
		  }
	
}
