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


public class CloseTicket {
	
	static JList<String> listIssueType = new JList<String>();
	static JList<String> listTicketNumber_Delete = new JList<String>();
	
	static JPanel ViewMyTicketsPanel = new JPanel();	
	static JFrame ViewViewMyFrame = new JFrame("IT HELP DESK");
	
	static JPanel ConfirmationPanel = new JPanel();	
	static JFrame ConfirmationFrame = new JFrame("IT HELP DESK");
	
	
	public static void  InitiateCloseTicket()
	{
			ResultSet rs = null;
			rs = DataAccessLayer.GetTickets_StatusOpen();
	      
	     
			 // ViewViewMyFrame.setSize(800, 500);
			  ViewViewMyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);							
			  ViewViewMyFrame.add(ViewMyTicketsPanel);
			  int iHeight = HomeScreen_PurgeTicket(ViewMyTicketsPanel,rs);
			  ViewViewMyFrame.setSize(550, iHeight + 150);
			  ViewViewMyFrame.setLocationRelativeTo(null); 
			  ViewViewMyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			  ViewViewMyFrame.setResizable(false);
			  ViewViewMyFrame.setVisible(true);	
			 
	}
	
	
	
	private static int  HomeScreen_PurgeTicket(JPanel panel,ResultSet rs)
	 {		
		int iHeight = 30;
		 try {
				panel.setLayout(null);
		 		panel.removeAll();
		 		Border blackline;
		 		blackline = BorderFactory.createLineBorder(Color.black);
		 	
		 		
				if (rs.isBeforeFirst() == false)
				  {
					JLabel TicketNumber = new JLabel("No Tickes available");
				  	TicketNumber.setBounds(175,10,150,20 );				  
					panel.add(TicketNumber);	
				  }
				  else
				  {
			 				 	
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
					
					
					
			
					
				 	while (rs.next()) {	
				 		JLabel TicketNumberValue = new JLabel(rs.getString(2));
				 		TicketNumberValue.setBounds(10,iHeight,90,20 );
				 		TicketNumberValue.setBorder(blackline);
						panel.add(TicketNumberValue);	
						
						JLabel TicketStatusValue = new JLabel(rs.getString(9));
						TicketStatusValue.setBounds(100,iHeight,120,20 );
						TicketStatusValue.setBorder(blackline);
						panel.add(TicketStatusValue);
						
						JLabel TicketIssueValue = new JLabel(rs.getString(6));
						TicketIssueValue.setBounds(220,iHeight,80,20 );
						TicketIssueValue.setBorder(blackline);
						panel.add(TicketIssueValue);
						
						JLabel TicketAssignedToValue = new JLabel(rs.getString(4));
						TicketAssignedToValue.setBounds(300,iHeight,80,20);
						TicketAssignedToValue.setBorder(blackline);
						panel.add(TicketAssignedToValue);
						
						JLabel TicketAssignedByValue = new JLabel(rs.getString(5));
						TicketAssignedByValue.setBounds(380,iHeight,65,20);
						TicketAssignedByValue.setBorder(blackline);
						panel.add(TicketAssignedByValue);
						
						JLabel TicketStartDateValue = new JLabel(rs.getString(7));
						TicketStartDateValue.setBounds(445,iHeight,65,20 );
						TicketStartDateValue.setBorder(blackline);
						panel.add(TicketStartDateValue);
						
						JLabel TicketEndDateValue = new JLabel(rs.getString(8));
						TicketEndDateValue.setBounds(510,iHeight,65,20 );
						TicketEndDateValue.setBorder(blackline);
						panel.add(TicketEndDateValue);
						iHeight= iHeight +30;					
				 	}
				 	iHeight= iHeight + 50;
				 	
				 	
				 	JLabel labelEditTicketNumber = new JLabel("Select ticket number to close");
				 	labelEditTicketNumber.setBounds(20, iHeight, 200, 20);
					panel.add(labelEditTicketNumber);
				    			 			 
					//txtTicketNumber_Delete.setBounds(190, x, 50, 20);
				    //txtTicketNumber_Delete.setText(null);
					//panel.add(txtTicketNumber_Delete);
					
					
					 Vector<String> temp = new Vector<String>();				   				  
					 temp  = DataAccessLayer.GetTicketIds_StatusOpen();
					 
					 listTicketNumber_Delete.setListData(temp);
					
					 listTicketNumber_Delete.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					 listTicketNumber_Delete.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					 listTicketNumber_Delete.setVisibleRowCount(-1);	
					 
				    JScrollPane listScroller = new JScrollPane(listTicketNumber_Delete);
				    listScroller.setPreferredSize(new Dimension(60, 65));
				    listScroller.setBounds(230, iHeight, 100, 65);
				    
				    //listTicketNumber_Delete.enable();
				    listTicketNumber_Delete.setEnabled(true);
				    
				    panel.add(listScroller);	
				    
					
				    iHeight= iHeight + 65;		 	
				 	JButton ViewMyTickets_Delete = new JButton("Close Ticket");
				 	ViewMyTickets_Delete.addActionListener (new CloseMyTickets_Click());
				 	ViewMyTickets_Delete.setPreferredSize(new Dimension(80,50));
				 	ViewMyTickets_Delete.setBounds(20, iHeight, 150, 20);
					panel.add(ViewMyTickets_Delete);
				  }
		 }
		  catch (SQLException e1) {
			  
				e1.printStackTrace();					   
		  }
		 return iHeight;
		
	 }
	
	static class CloseMyTickets_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
			  
			  if (listTicketNumber_Delete.getSelectedValuesList().size() > 0)
			  {
			  
			 	int iSuccess = DataAccessLayer.CloseTicket(listTicketNumber_Delete.getSelectedValuesList().toString());
			 	
			 	 int iHeight = 0;
				  
				   ConfirmationFrame.setLocationRelativeTo(null); 
				   ConfirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				   
				   ConfirmationPanel.setLayout(null);
				   ConfirmationPanel.removeAll();
			 		
			 		
				    JLabel ConfirmDeleteLabel = new JLabel();
				    ConfirmDeleteLabel.setText(null);
				    String sMessage = "<html>The following tickets have been closed "; 
				    
				   
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
				    
				    JButton Yes_Delete = new JButton("Close");
				    Yes_Delete.addActionListener (new Close_Click());
				    Yes_Delete.setPreferredSize(new Dimension(80,50));
				    Yes_Delete.setBounds(30, iHeight+25, 100, 20);
				    ConfirmationPanel.add(Yes_Delete);
					
					ConfirmationFrame.setResizable(false);
					ConfirmationFrame.setVisible(true);	
					ConfirmationPanel.setLayout(null);
					ConfirmationFrame.add(ConfirmationPanel);

			  }
			  else
			  {
				  JOptionPane.showMessageDialog(null, "Please select one or more tickets to be closed","IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
			  }
			 	
		  }
		}
	
	static class Close_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
			  ConfirmationFrame.dispose();
			  ViewViewMyFrame.dispose();
			  InitiateCloseTicket();
			  
		  }
	}

}
