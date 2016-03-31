import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class ViewAllTickets {
	
	static JPanel ViewAllticketsPanel = new JPanel();	
	static JFrame ViewAllticketsFrame = new JFrame("IT HELP DESK");
	

	public static void InitiateViewAllTickets()
	{
		 ResultSet rsDataSet = null;
		 rsDataSet = DataAccessLayer.GetAllTicket();	
		 
		  ViewAllticketsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);							
		  ViewAllticketsFrame.add(ViewAllticketsPanel);
		  
		 int iHeight =  HomeScreen_ViewAllTicket(ViewAllticketsPanel,rsDataSet);
		  ViewAllticketsFrame.setSize(600, iHeight + 150);
		  ViewAllticketsFrame.setLocationRelativeTo(null); 
		  ViewAllticketsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		  ViewAllticketsFrame.setResizable(false);
		  ViewAllticketsFrame.setVisible(true);	
	}
	
	 private static int  HomeScreen_ViewAllTicket(JPanel panel,ResultSet rsDataSet)
	 {
		 int iHeight = 30; 
		 try {
			 if (rsDataSet.isBeforeFirst() == false)
			  {
				JLabel TicketNumber = new JLabel("No Tickes available");
			  	TicketNumber.setBounds(175,10,150,20 );
			  
				panel.add(TicketNumber);	
			  }
			  else
			  {
		  
			 	panel.setLayout(null);
		 		panel.removeAll();
		 		Border blackline;
		 		blackline = BorderFactory.createLineBorder(Color.black);
		 		
			  	JLabel TicketNumber = new JLabel("Ticket #");
			  	TicketNumber.setBounds(10,10,90,20 );
			  	TicketNumber.setBorder(blackline);
				panel.add(TicketNumber);	
				
				JLabel TicketStatus = new JLabel("Issue Type");
				TicketStatus.setBounds(100,10,120,20 );
				TicketStatus.setBorder(blackline);
				panel.add(TicketStatus);
				
				JLabel TicketIssueType= new JLabel("Ticket Status");
				TicketIssueType.setBounds(220,10,80,20 );
				TicketIssueType.setBorder(blackline);
				panel.add(TicketIssueType);
				
				JLabel TicketAssignedTo = new JLabel("Assigned To");
				TicketAssignedTo.setBounds(300,10,80,20);
				TicketAssignedTo.setBorder(blackline);
				panel.add(TicketAssignedTo);
				
				JLabel TicketAssignedBy = new JLabel("Assigned By");
				TicketAssignedBy.setBounds(380,10,65,20);
				TicketAssignedBy.setBorder(blackline);
				panel.add(TicketAssignedBy);
				
				JLabel TicketStartDate = new JLabel("Start Date");
				TicketStartDate.setBounds(445,10,65,20 );
				TicketStartDate.setBorder(blackline);
				panel.add(TicketStartDate);
				
				JLabel TicketEndDate = new JLabel("End Date");
				TicketEndDate.setBounds(510,10,65,20);
				TicketEndDate.setBorder(blackline);
				panel.add(TicketEndDate);
			
		
			 	while (rsDataSet.next()) {	
			 		JLabel TicketNumberValue = new JLabel(rsDataSet.getString(2));
			 		TicketNumberValue.setBounds(10,iHeight,90,20 );
			 		TicketNumberValue.setBorder(blackline);
					panel.add(TicketNumberValue);	
					
					JLabel TicketStatusValue = new JLabel(rsDataSet.getString(9));
					TicketStatusValue.setBounds(100,iHeight,120,20 );
					TicketStatusValue.setBorder(blackline);
					panel.add(TicketStatusValue);
					
					JLabel TicketIssueValue = new JLabel(rsDataSet.getString(6));
					TicketIssueValue.setBounds(220,iHeight,80,20 );
					TicketIssueValue.setBorder(blackline);
					panel.add(TicketIssueValue);
					
					JLabel TicketAssignedToValue = new JLabel(rsDataSet.getString(4));
					TicketAssignedToValue.setBounds(300,iHeight,80,20);
					TicketAssignedToValue.setBorder(blackline);
					panel.add(TicketAssignedToValue);
					
					JLabel TicketAssignedByValue = new JLabel(rsDataSet.getString(5));
					TicketAssignedByValue.setBounds(380,iHeight,65,20);
					TicketAssignedByValue.setBorder(blackline);
					panel.add(TicketAssignedByValue);
					
					JLabel TicketStartDateValue = new JLabel(rsDataSet.getString(7));
					TicketStartDateValue.setBounds(445,iHeight,65,20 );
					TicketStartDateValue.setBorder(blackline);
					panel.add(TicketStartDateValue);
					
					JLabel TicketEndDateValue = new JLabel(rsDataSet.getString(8));
					TicketEndDateValue.setBounds(510,iHeight,65,20 );
					TicketEndDateValue.setBorder(blackline);
					panel.add(TicketEndDateValue);
					iHeight= iHeight +30;
			 	}
			  }
			
		}
		  catch (SQLException e1) {
			  
				e1.printStackTrace();					   
		  }
		return iHeight;
	 }
	
}
