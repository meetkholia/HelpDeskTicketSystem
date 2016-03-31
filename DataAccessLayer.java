import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


public  class DataAccessLayer {
	
private static Connection connect = null;
	private  static Statement statement = null;
	private static ResultSet resultSet = null;
	private static int iToggle = 0 ;
	  
	public static String ValidateUser(String sUserName, String sPassword)
	{
	 try {
		 
		
		 	String sPresent = "";
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      //create table
	    
	      statement = connect.createStatement();
	      
	      String sql = "select count(*) from svall_user_details where UserName = '"+ sUserName + "' and Password = '"+ sPassword + "'";

	      resultSet =  statement.executeQuery(sql);
	      while (resultSet.next()) {		       
			 sPresent = resultSet.getString(1);  //retrieve cost
	      }
	      
	      return sPresent;	      
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return null;
	 }  
	}
	
	public static String[] GetUsers()
	{
	 try {
		
		 
		 String[] myStringArray = new String[3];
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      //create table
	    
	      statement = connect.createStatement();
	      
	      String sql = "SELECT TicketStatus FROM tickets.svall_TicketStat";

	      resultSet =  statement.executeQuery(sql);
	      int iCount  = 0 ; 
	      while (resultSet.next()) {		    	  
	    	  myStringArray[iCount] = resultSet.getString(1);  
	    	  iCount++;
	      }
	      
	      return myStringArray;	      
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return null;
	 }  
	}
	
	public static String[] InsertTicket(String sDescription,String sAssignedby,String sIssueType)
	{
	 try {
		 
		
		 
		 String[] myStringArray = new String[5];
		 String sTicketNumber = "";
		 int sID = 1;
		 String sAssignedTo,sCurrentDate,sEnddate;
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date TicketStartdate = new Date();
		 Date  TicketEnddate= new Date();
		
		 
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      statement = connect.createStatement();	      
	      String sql = "SELECT id FROM svall_ticket_details ORDER BY id DESC LIMIT 1 ";
	      resultSet =  statement.executeQuery(sql);
	      
	   
	       while (resultSet.next()) {		    	  
	    	  	sID = resultSet.getInt(1);  
	    	  	sID = (sID+1);
		    
		      	}
	  	 sTicketNumber = "ITM_HD_" + sID  ;
   		
	      
	      	
	      	myStringArray[0] = sTicketNumber;
	      	if (iToggle == 1)
	      	{
	      		sAssignedTo = "mkholia"; 
	      		iToggle = 0;
	      	}
	      	else
	      	{
	      		sAssignedTo = "svallioo";
	      		iToggle = 1;
	      	}
	      	myStringArray[1] = sAssignedTo;
	      	
	      	 sCurrentDate = dateFormat.format(TicketStartdate).toString().substring(0,10);
		     Calendar cal = Calendar.getInstance();  
		     cal.setTime(TicketStartdate);  
		     cal.add(Calendar.DATE, 10); // add 10 days  		      	 
		     TicketEnddate = cal.getTime();
		     
		     sEnddate = dateFormat.format(TicketEnddate).toString().substring(0,10);
		 	 myStringArray[2] = sCurrentDate;
		 	 myStringArray[3] = sEnddate;
		 	myStringArray[4] = sIssueType;
		 	
		     sql = "insert into svall_ticket_details values ('"+ sID + "','" + sTicketNumber + "','" + sDescription +"','" + sAssignedTo +"','" + sAssignedby + "','OPEN','" + sCurrentDate + "','" + sEnddate + "','" + sIssueType +"')";
		     statement.executeUpdate(sql);
		     
		     return myStringArray;
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return null;
	 }  
	}

	public static ResultSet GetUserTicket(String sUserName)
	{
	 try {
		 
		
		 	
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      //create table
	    
	      statement = connect.createStatement();
	      
	      String sql = "select * from svall_ticket_details where AssignedBy = '"+ sUserName + "'";

	      resultSet =  statement.executeQuery(sql);
	     
	      return resultSet;	      
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return null;
	 }  
	}
	
	public static ResultSet GetAllTicket()
	{
	 try {
		 
		
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      //create table
	    
	      statement = connect.createStatement();
	      
	      String sql = "select * from svall_ticket_details";

	      resultSet =  statement.executeQuery(sql);
	      
	      return resultSet;	      
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return null;
	 }  
	}
	
	public static int  DeleteTicket(String sTicketID)
	{
		 
		int iSuccess = -1 ;
			 	
	 try {
		 
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      //create table
	    
	     
	      
	    
	      String[] sTicketIDs = sTicketID.replace("[", "").replace("]", "").split(",");
	      
	      for (int iCount = 0 ;iCount<sTicketIDs.length; iCount++)
	      {
	    	  statement = connect.createStatement();
	    	//  String sql = "DELETE FROM svall_TicketDetails WHERE TicketID = '" + sTicketID + "'";
	    	  String sql = "DELETE FROM svall_ticket_details WHERE TicketID = '" + sTicketIDs[iCount].trim() + "'";
	    	  statement.execute(sql);
	      }
	      iSuccess = 1;
	      
	      return iSuccess;	      
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return iSuccess;
	 }  
	}
	
	
	
	public static Vector<String>  GetStatusTypes()
	{
		
		
		 
	 try {
		 
		
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      //create table
	    
	   
	      
	      String sql = "SELECT StatType FROM svall_status_types";

	      resultSet =  statement.executeQuery(sql);
	     
	      //String[] myStringArray = new String[resultSe];
	      Vector<String> temp = new Vector<String>();
	      
	      while (resultSet.next()) {		    	  	    	
	    	  temp.add(resultSet.getString(1));	    	
	      }
	      
	      return temp;	      
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return null;
	 }  
	}
	
	public static Vector<String>   GetIssueTypes()
	{
		
	
	 try {
		 
		 
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      //create table
	    
	   
	      
	      String sql = "SELECT IssueType FROM svall_issue_types";

	      resultSet =  statement.executeQuery(sql);
	     
	      //String[] myStringArray = new String[resultSe];
	      Vector<String> temp = new Vector<String>();
	      
	      while (resultSet.next()) {		    	  	    	
	    	  temp.add(resultSet.getString(1));	    	
	      }
	      
	      return temp;	      
		//end create table
	 } catch (Exception e) {
		 	System.out.println(e.getMessage());  
		 	return null;
	 }  
	}
	
	public static Vector<String> GetTicketIds()
	{ 
		
		 try {			 			 
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
		              + "user=root&password=jamesp");
		      
		      String sql = "SELECT TicketID FROM svall_ticket_details";

		      resultSet =  statement.executeQuery(sql);
		     
		      //String[] myStringArray = new String[resultSe];
		      Vector<String> temp = new Vector<String>();
		      
		      while (resultSet.next()) {		    	  	    	
		    	  temp.add(resultSet.getString(1));	    	
		      }
		      
		      return temp;	      
			//end create table
		 } catch (Exception e) {
			 	System.out.println(e.getMessage());  
			 	return null;
		 }  		
	}
	
	public static ResultSet GetTicketInfo(String sTicketID)
	{
		
		 try {			 			 
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
		              + "user=root&password=jamesp");
		      
		      String sql = "SELECT * FROM svall_ticket_details where TicketID = '" + sTicketID + "'";

		      resultSet =  statement.executeQuery(sql);
		      
		      return resultSet;	      
			//end create table
		 } catch (Exception e) {
			 	System.out.println(e.getMessage());  
			 	return null;
		 } 
	}
	
	public static int  GetIssueTypeIndex(String sTicketIssueType)
	{
		
		 try {
			 
			 	int  iIndex = 0;
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
		              + "user=root&password=jamesp");
		      
		      //create table
		    
		      statement = connect.createStatement();
		      
		      String sql = "SELECT IssueID FROM svall_issue_types where IssueType = '" + sTicketIssueType + "'";

		      resultSet =  statement.executeQuery(sql);
		      while (resultSet.next()) {		       
		    	  iIndex = resultSet.getInt(1);  //retrieve cost
		      }
		     
		      return iIndex;	      
			//end create table
		 } catch (Exception e) {
			 	System.out.println(e.getMessage());  
			 	
			 	return -1;
		 }  
		
	}
	
	public static int  GetStatusTypeIndex(String sTicketStatusType)
	{ 
		
		
		 try {
			 
			 	int  iIndex = 0;
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
		              + "user=root&password=jamesp");
		      
		      //create table
		    
		      statement = connect.createStatement();
		      
		      String sql = "SELECT * FROM svall_status_types where StatType = '" + sTicketStatusType + "'";

		      resultSet =  statement.executeQuery(sql);
		      while (resultSet.next()) {		       
		    	  iIndex = resultSet.getInt(1);  //retrieve cost
		      }
		     
		      return iIndex;	      
			//end create table
		 } catch (Exception e) {
			 	System.out.println(e.getMessage());
			 	
			 	return -1;
		 }  
		
	}
	
	
	public static int  SaveTicket(String sIssueType, String sStatusType,String sTicketID)
	{
		
		 
		int iSuccess = 0 ;
		 try {
			 
		  Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      
	      String sql = "UPDATE svall_ticket_details SET TicketStat = '"+ sStatusType +"' , IssueType = '" + sIssueType +"' WHERE ticketID = '"+ sTicketID + "'";
	      
	      iSuccess = statement.executeUpdate(sql);
	     
	      return iSuccess;
		 }
		 catch(Exception ex)
		 {
			
			 return iSuccess;
		 }
		
	}
	
	public static Vector<String> GetTicketIds_StatusOpen()
	{ 
		
		 try {			 			 
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
		              + "user=root&password=jamesp");
		      
		      String sql = "SELECT TicketID FROM svall_ticket_details where TicketStat <> 'CLOSE'";

		      resultSet =  statement.executeQuery(sql);
		      Vector<String> temp = new Vector<String>();
		      
		      while (resultSet.next()) {		    	  	    	
		    	  temp.add(resultSet.getString(1));	    	
		      }
		      
		      return temp;      
			//end create table
		 } catch (Exception e) {
			 	System.out.println(e.getMessage());  
			 	return null;
		 }  		
	}
	
	public static ResultSet GetTickets_StatusOpen()

	{ 
		
		 try {			 			 
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
		              + "user=root&password=jamesp");
		      
		      String sql = "SELECT * FROM svall_ticket_details where TicketStat <> 'CLOSE'";

		      resultSet =  statement.executeQuery(sql);
		     
		    
		      return resultSet;	      
			//end create table
		 } catch (Exception e) {
			 	System.out.println(e.getMessage());  
			 	return null;
		 }  		
	}
	
	public static int CloseTicket(String sTicketID)
	{				
		int iSuccess = 0 ;
		 try {
			 
		  Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://74.94.99.101/tickets?"
	              + "user=root&password=jamesp");
	      	   	    	   
	      String[] sTicketIDs = sTicketID.replace("[", "").replace("]", "").split(",");
	      
	      for (int iCount = 0 ;iCount<sTicketIDs.length; iCount++)
	      {
	    	  statement = connect.createStatement();	    	
	    	   String sql = "UPDATE svall_ticket_details SET TicketStat = 'CLOSE' WHERE ticketID = '"+ sTicketIDs[iCount].trim() + "'";
	    	  statement.execute(sql);
	      }	     	    
		 }
		 catch(Exception ex)
		 {
			 
		 }
		 return iSuccess;
	}
}


