import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;


public class PurgeTicket {
	
	static JList<String> listIssueType = new JList<String>();
	static JList<String> listTicketNumber_Delete = new JList<String>();
	
	static JPanel PurgeTicketsPanel = new JPanel();	
	static JFrame PurgeTicketsFrame = new JFrame("IT HELP DESK");
	
	static JPanel ConfirmationPanel = new JPanel();	
	static JFrame ConfirmationFrame = new JFrame("IT HELP DESK");
	
	
	public static void  InitiatePurgeTicket()
	{
		 ResultSet rs = null;
	      rs = DataAccessLayer.GetAllTicket();
	      
	     
			 // ViewViewMyFrame.setSize(800, 500);
	      	  PurgeTicketsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);							
			  PurgeTicketsFrame.add(PurgeTicketsPanel);
			  int iHeight = HomeScreen_PurgeTicket(PurgeTicketsPanel,rs);
			  PurgeTicketsFrame.setSize(600, iHeight + 150);
			  PurgeTicketsFrame.setLocationRelativeTo(null); 
			  PurgeTicketsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			  PurgeTicketsFrame.setResizable(false);
			  PurgeTicketsFrame.setVisible(true);	
			 
	}
	
	
	
	private static int  HomeScreen_PurgeTicket(JPanel panelTicketFrame,ResultSet rs)
	 {		
		int iHeight = 30;
		 try {
			 	panelTicketFrame.setLayout(null);
			 	panelTicketFrame.removeAll();
		 		Border blackline;
		 		blackline = BorderFactory.createLineBorder(Color.black);
		 	
		 		
				if (rs.isBeforeFirst() == false)
				  {
					JLabel TicketNumber = new JLabel("No Tickes available");
				  	TicketNumber.setBounds(175,10,150,20 );				  
				  	panelTicketFrame.add(TicketNumber);	
				  }
				  else
				  {			 				 
				  	JLabel TicketNumber = new JLabel("Ticket #");
				  	TicketNumber.setBounds(10,10,90,20 );
				  	TicketNumber.setBorder(blackline);
				  	panelTicketFrame.add(TicketNumber);	
					
					JLabel TicketStatus = new JLabel("Issue Type");
					TicketStatus.setBounds(100,10,120,20 );
					TicketStatus.setBorder(blackline);
					panelTicketFrame.add(TicketStatus);
					
					JLabel TicketIssueType= new JLabel("Ticket Status");
					TicketIssueType.setBounds(220,10,80,20 );
					TicketIssueType.setBorder(blackline);
					panelTicketFrame.add(TicketIssueType);
					
					JLabel TicketAssignedTo = new JLabel("Assigned To");
					TicketAssignedTo.setBounds(300,10,80,20);
					TicketAssignedTo.setBorder(blackline);
					panelTicketFrame.add(TicketAssignedTo);
					
					JLabel TicketAssignedBy = new JLabel("Assigned By");
					TicketAssignedBy.setBounds(380,10,65,20);
					TicketAssignedBy.setBorder(blackline);
					panelTicketFrame.add(TicketAssignedBy);
					
					JLabel TicketStartDate = new JLabel("Start Date");
					TicketStartDate.setBounds(445,10,65,20 );
					TicketStartDate.setBorder(blackline);
					panelTicketFrame.add(TicketStartDate);
					
					JLabel TicketEndDate = new JLabel("End Date");
					TicketEndDate.setBounds(510,10,65,20);
					TicketEndDate.setBorder(blackline);
					panelTicketFrame.add(TicketEndDate);
					
				 	while (rs.next()) {	
				 		JLabel TicketNumberValue = new JLabel(rs.getString(2));
				 		TicketNumberValue.setBounds(10,iHeight,90,20 );
				 		TicketNumberValue.setBorder(blackline);
				 		panelTicketFrame.add(TicketNumberValue);	
						
						JLabel TicketStatusValue = new JLabel(rs.getString(9));
						TicketStatusValue.setBounds(100,iHeight,120,20 );
						TicketStatusValue.setBorder(blackline);
						panelTicketFrame.add(TicketStatusValue);
						
						JLabel TicketIssueValue = new JLabel(rs.getString(6));
						TicketIssueValue.setBounds(220,iHeight,80,20 );
						TicketIssueValue.setBorder(blackline);
						panelTicketFrame.add(TicketIssueValue);
						
						JLabel TicketAssignedToValue = new JLabel(rs.getString(4));
						TicketAssignedToValue.setBounds(300,iHeight,80,20);
						TicketAssignedToValue.setBorder(blackline);
						panelTicketFrame.add(TicketAssignedToValue);
						
						JLabel TicketAssignedByValue = new JLabel(rs.getString(5));
						TicketAssignedByValue.setBounds(380,iHeight,65,20);
						TicketAssignedByValue.setBorder(blackline);
						panelTicketFrame.add(TicketAssignedByValue);
						
						JLabel TicketStartDateValue = new JLabel(rs.getString(7));
						TicketStartDateValue.setBounds(445,iHeight,65,20 );
						TicketStartDateValue.setBorder(blackline);
						panelTicketFrame.add(TicketStartDateValue);
						
						JLabel TicketEndDateValue = new JLabel(rs.getString(8));
						TicketEndDateValue.setBounds(510,iHeight,65,20 );
						TicketEndDateValue.setBorder(blackline);
						panelTicketFrame.add(TicketEndDateValue);
						iHeight= iHeight +30;					
				 	}
				 	iHeight= iHeight + 50;
				 	
				 	
				 	JLabel labelEditTicketNumber = new JLabel("Select ticket number to be purged");
				 	labelEditTicketNumber.setBounds(20, iHeight, 200, 20);
				 	panelTicketFrame.add(labelEditTicketNumber);
					
					
					JLabel labelPurgetTicketNote = new JLabel("<html>Press Shift to select multiple tickets</html>");
					labelPurgetTicketNote.setBounds(20, iHeight+20, 200, 40);
					panelTicketFrame.add(labelPurgetTicketNote);
				    			 			 
					//txtTicketNumber_Delete.setBounds(190, x, 50, 20);
				    //txtTicketNumber_Delete.setText(null);
					//panel.add(txtTicketNumber_Delete);
					
					
					 Vector<String> temp = new Vector<String>();				   				  
					 temp  = DataAccessLayer.GetTicketIds();
					 
					 listTicketNumber_Delete.setListData(temp);
					
					 listTicketNumber_Delete.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					 listTicketNumber_Delete.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					 listTicketNumber_Delete.setVisibleRowCount(-1);	
					 
				    JScrollPane listScroller = new JScrollPane(listTicketNumber_Delete);
				    listScroller.setPreferredSize(new Dimension(60, 65));
				    listScroller.setBounds(230, iHeight, 100, 65);
				    
				    //listTicketNumber_Delete.enable();
				    listTicketNumber_Delete.setEnabled(true);
				    
				    panelTicketFrame.add(listScroller);	
				    
					
				    iHeight= iHeight + 65;		 	
				 	JButton ViewMyTickets_Delete = new JButton("Purge Ticket");
				 	ViewMyTickets_Delete.addActionListener (new EditMyTickets_Click());
				 	ViewMyTickets_Delete.setPreferredSize(new Dimension(80,50));
				 	ViewMyTickets_Delete.setBounds(20, iHeight, 150, 20);
				 	panelTicketFrame.add(ViewMyTickets_Delete);
				  }
		 }
		  catch (SQLException e1) {
			  
				e1.printStackTrace();					   
		  }
		 return iHeight;
		
	 }
	
	static class EditMyTickets_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {

			  if (listTicketNumber_Delete.getSelectedValuesList().size() > 0)
			  {
			 
			    int iHeight = 0;
			  
			   ConfirmationFrame.setLocationRelativeTo(null); 
			   ConfirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			   
			   ConfirmationPanel.setLayout(null);
			   ConfirmationPanel.removeAll();
		 		
		 		
			    JLabel ConfirmDeleteLabel = new JLabel();
			    ConfirmDeleteLabel.setText(null);
			    String sMessage = "<html> Do you want to delete "; 
			    
			   
			    for (int iCount = 0 ; iCount< listTicketNumber_Delete.getSelectedValuesList().size(); iCount++)
			    {
			    	sMessage = sMessage + "<br>" + listTicketNumber_Delete.getSelectedValuesList().get(iCount);
			    	iHeight = iHeight +30;
			    }
			    sMessage = sMessage + "</html>";
			    	
			    ConfirmDeleteLabel.setText(sMessage);
			    ConfirmationFrame.setSize(300,iHeight+100);
			    ConfirmDeleteLabel.setBounds(10,10,250,iHeight); //10,35,90,20 );			  
			    ConfirmationPanel.add(ConfirmDeleteLabel);	
			    
			    JButton Yes_Delete = new JButton("Yes");
			    Yes_Delete.addActionListener (new YesDelete_Click());
			    Yes_Delete.setPreferredSize(new Dimension(80,50));
			    Yes_Delete.setBounds(30, iHeight+25, 100, 20);
			    ConfirmationPanel.add(Yes_Delete);
				
				JButton No_Delete = new JButton("No");
				No_Delete.addActionListener (new NoDelete_Click());
				No_Delete.setPreferredSize(new Dimension(80,50));
				No_Delete.setBounds(150,iHeight+25 , 100, 20);
				ConfirmationPanel.add(No_Delete);
				
				ConfirmationFrame.setResizable(false);
				ConfirmationFrame.setVisible(true);	
				ConfirmationPanel.setLayout(null);
				ConfirmationFrame.add(ConfirmationPanel);
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(null, "Please select one or more tickets to be purged","IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
			  }
		  }
		  
		}
	static class YesDelete_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
			  ConfirmationFrame.dispose();
			  int iSuccess = DataAccessLayer.DeleteTicket(listTicketNumber_Delete.getSelectedValuesList().toString());
			 	if(iSuccess == 1)
				 {
			 		PurgeTicketsFrame.dispose();
			 		JOptionPane.showMessageDialog(null, "Delete successful" ,"IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);			 	
			 		InitiatePurgeTicket();  
				 }
			 	else
			 	{
			 		JOptionPane.showMessageDialog(null, "Delete unsuccessful. Please try again " ,"IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);	
			 	}
		  }
		  
		  }
	
	
		static class NoDelete_Click implements ActionListener {        
			public void actionPerformed (ActionEvent e) {
				ConfirmationFrame.dispose();
			}
		  	
		}
	
	


}
