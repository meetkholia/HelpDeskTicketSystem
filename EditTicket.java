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

public class EditTicket
{
	static JPanel EditticketsPanel = new JPanel();	
	static JFrame EditticketsFrame = new JFrame("IT HELP DESK");
	
	static JPanel EditticketPanel = new JPanel();	
	static JFrame EditticketFrame = new JFrame("IT HELP DESK");
	
	
	
	static JList<String> listTicketNumber_Delete = new JList<String>();
	static JList<String> listIssueType = new JList<String>();
	static JList<String> listIssueType_Edit = new JList<String>();
	
	static JList<String> listEditIssueType = new JList<String>();
	static JList<String> listEditStatusType = new JList<String>();
	
	static JLabel TicketNumberValue_Edit = new JLabel();
	
	public static void InitialEditScreen()
	{
		 
		  EditticketsFrame.setSize(600, 500);
		  EditticketsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);						  			
		  EditticketsPanel.revalidate();
		  EditticketsPanel.repaint();
		  EditticketsPanel.removeAll();
		  EditticketsFrame.add(EditticketsPanel);
		  ResultSet rs = null;
	      rs = DataAccessLayer.GetAllTicket();	
		  HomeScreen_EditTicket(EditticketsPanel,rs);
		  EditticketsFrame.setLocationRelativeTo(null); 
		  EditticketsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		  EditticketsFrame.setResizable(false);
		  EditticketsFrame.setVisible(true);
	}
	
	private static void HomeScreen_EditTicket(JPanel panel,ResultSet rs)
	{
		 int iHeight = 30; 
		 try {
			 if (rs.isBeforeFirst() == false)
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
			 	
			 	iHeight= iHeight +50;
			 	JLabel labelEditTicketNumber = new JLabel("Select ticket number to delete");
			 	labelEditTicketNumber.setBounds(20, iHeight, 200, 20);
				panel.add(labelEditTicketNumber);
			    			 			 
				//txtTicketNumber_Delete.setBounds(190, x, 50, 20);
			//	txtTicketNumber_Delete.setText(null);
				//panel.add(txtTicketNumber_Delete);
				
				
				 Vector<String> temp = new Vector<String>();				   				  
				 temp  = DataAccessLayer.GetTicketIds();
				 
				 listIssueType_Edit.setListData(temp);
				
				 listIssueType_Edit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				 listIssueType_Edit.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				 listIssueType_Edit.setVisibleRowCount(-1);	
				 
			    JScrollPane listScroller = new JScrollPane(listIssueType_Edit);
			    listScroller.setPreferredSize(new Dimension(60, 65));
			    listScroller.setBounds(230, iHeight, 100, 65);
			   // listIssueType_Edit.enable();
			    listIssueType_Edit.setEnabled(true);
			    panel.add(listScroller);	
			    		 	
			 	JButton ViewMyTickets_Delete = new JButton("Update Ticket");
			 	ViewMyTickets_Delete.addActionListener (new EditMyTicket_Click());
			 	ViewMyTickets_Delete.setPreferredSize(new Dimension(80,50));
			 	ViewMyTickets_Delete.setBounds(20, iHeight+65, 150, 20);
				panel.add(ViewMyTickets_Delete);
			  }
		 }
	  catch (SQLException e1) {
		  
			e1.printStackTrace();					   
	  }
		
	}
	
	static class EditMyTicket_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {	
			 
			 
			  EditticketFrame.setSize(800, 500);
			  EditticketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);						  			
			  EditticketPanel.revalidate();
			  EditticketPanel.repaint();
			  EditticketPanel.removeAll();
			  EditticketFrame.add(EditticketPanel);
			 
			  if (listIssueType_Edit.getSelectedValue() == null)
			  {
				  JOptionPane.showMessageDialog(null, "Please select a Ticket ID to edit" ,"IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
			  }
			  else
			  {
				  HomeScreen_EditTicket(EditticketPanel,listIssueType_Edit.getSelectedValue().toString());
				  EditticketFrame.setLocationRelativeTo(null); 
				  EditticketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				  EditticketFrame.setResizable(false);
				  EditticketFrame.setVisible(true);
			  }
			 
		  }
		}
	
	static void HomeScreen_EditTicket(JPanel panel, String sTicketID)
	{
		 	ResultSet rs = null;
		 	try
		 	{
		 		 Vector<String> temp = new Vector<String>();				   				  
				 temp  = DataAccessLayer.GetIssueTypes();
				 
				 Vector<String> temp1 = new Vector<String>();				   				  
				 temp1  = DataAccessLayer.GetStatusTypes();
				 
		 		rs = DataAccessLayer.GetTicketInfo(sTicketID);	
		 		
		 		panel.setLayout(null);
		 		panel.removeAll();
		 		Border blackline;
		 		blackline = BorderFactory.createLineBorder(Color.black);
		 		
			  	JLabel TicketNumber = new JLabel("Ticket #");
			  	TicketNumber.setBounds(10,10,90,20 );
			  	TicketNumber.setBorder(blackline);
				panel.add(TicketNumber);	
				
				JLabel TicketStatus = new JLabel("Issue Type");
				TicketStatus.setBounds(100,10,65,20 );
				TicketStatus.setBorder(blackline);
				panel.add(TicketStatus);
				
				JLabel TicketIssueType= new JLabel("Ticket Status");
				TicketIssueType.setBounds(165,10,135,20 );
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
				
				int x = 30;
				
				while (rs.next()) {

			 	TicketNumberValue_Edit.setBounds(10,x,90,65 );
			 	TicketNumberValue_Edit.setBorder(blackline);
			 	TicketNumberValue_Edit.setText(rs.getString(2));
				panel.add(TicketNumberValue_Edit);
				
				 listEditStatusType.setListData(temp1);
				
				 listEditStatusType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				 listEditStatusType.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				 listEditStatusType.setVisibleRowCount(-1);	
				
				 
			    JScrollPane listScroller = new JScrollPane(listEditStatusType);
			    listScroller.setPreferredSize(new Dimension(60, 65));
			    listScroller.setBounds(100,x,65,40);
			
			    panel.add(listScroller);
			    String s = rs.getString(6);
			    String s2 = rs.getString(9);
			    int  iindex  = DataAccessLayer.GetStatusTypeIndex(s);
			    listEditStatusType.setSelectedIndex(iindex);

				// JList listEditIssueType = new JList();
				 listEditIssueType.setListData(temp);
				
				 listEditIssueType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				 listEditIssueType.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				 listEditIssueType.setVisibleRowCount(-1);	
				
				 
			    JScrollPane listScroller1 = new JScrollPane(listEditIssueType);
			    listScroller1.setPreferredSize(new Dimension(60, 65));
			    listScroller1.setBounds(165, x, 135, 65);
			
			    panel.add(listScroller1);
			
			      iindex  = DataAccessLayer.GetIssueTypeIndex(s2);
			    listEditIssueType.setSelectedIndex(iindex);
				
				
				JLabel TicketAssignedToValue = new JLabel(rs.getString(4));
				TicketAssignedToValue.setBounds(300,x,80,65);
				TicketAssignedToValue.setBorder(blackline);						
				panel.add(TicketAssignedToValue);
				
				JLabel TicketAssignedByValue = new JLabel(rs.getString(5));
				TicketAssignedByValue.setBounds(380,x,65,65);
				TicketAssignedByValue.setBorder(blackline);
				panel.add(TicketAssignedByValue);
				
				JLabel TicketStartDateValue = new JLabel(rs.getString(7));
				TicketStartDateValue.setBounds(445,x,65,65 );
				TicketStartDateValue.setBorder(blackline);
				panel.add(TicketStartDateValue);
				
				JLabel TicketEndDateValue = new JLabel(rs.getString(8));
				TicketEndDateValue.setBounds(510,x,65,65 );
				TicketEndDateValue.setBorder(blackline);
				panel.add(TicketEndDateValue);
				
				JButton ViewAllTickets  = new JButton("SAVE");
				ViewAllTickets.addActionListener (new Save_Click());
				ViewAllTickets.setPreferredSize(new Dimension(80,50));
				ViewAllTickets.setBounds(10, 100, 150, 25);
				panel.add(ViewAllTickets);
				
				JButton EditTickets  = new JButton("CANCEL");
				EditTickets.addActionListener (new Cancel_Click());
				EditTickets.setPreferredSize(new Dimension(80,50));
				EditTickets.setBounds(10, 135, 150, 25);
				panel.add(EditTickets);
				
				
			 }
		 	}
		 	catch(SQLException ex)
		 	{
		 		
		 	}
		
	}
	
	static class Cancel_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {	
			  EditticketFrame.dispose();
		  }
		}
	
	static class Save_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {	
			  
			int iSuccess =  DataAccessLayer.SaveTicket(listEditIssueType.getSelectedValue().toString(),listEditStatusType.getSelectedValue().toString(), TicketNumberValue_Edit.getText());
			EditticketFrame.dispose();
			JOptionPane.showMessageDialog(null, "Update Successful" ,"IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);	
			EditticketsFrame.dispose();
			InitialEditScreen();
			 
		  }
		}
}