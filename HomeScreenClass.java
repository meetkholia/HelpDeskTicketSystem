import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class HomeScreenClass {
	
	static JFrame HomeScreenFrame = new JFrame("IT HELP DESK");
	static JPanel HomeScreenPanel = new JPanel();
	
	
		
	
	
	static Boolean bMultiple = false;
	static  int  iRepeater = 1;	
	
	
	void DisplayHomeScreen()
	{
		HomeScreenFrame.setSize(180, 300);
		HomeScreenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);							
		HomeScreenFrame.add(HomeScreenPanel);
		HomeScreen(HomeScreenPanel);
		HomeScreenFrame.setLocationRelativeTo(null); 
		HomeScreenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		HomeScreenFrame.setResizable(false);
		HomeScreenFrame.setVisible(true);
		
	}
	
	// create initial panel for home screen
		private static void HomeScreen(JPanel panelHomeScreen)
		{
			panelHomeScreen.setLayout(null);
			
			JLabel lblFirstName = new JLabel("Please select one of the options");
			lblFirstName.setBounds(10, 10, 700, 20);
			panelHomeScreen.add(lblFirstName);
			
			JButton btnNewTicket = new JButton("New Ticket");
			btnNewTicket.addActionListener (new NewTicket_Click());
			btnNewTicket.setPreferredSize(new Dimension(80,50));
			btnNewTicket.setBounds(10, 35, 150, 25);
			panelHomeScreen.add(btnNewTicket);
			
			JButton btnViewAllTickets  = new JButton("View All Tickets");
			btnViewAllTickets.addActionListener (new ViewAllTickets_Click());					
			btnViewAllTickets.setPreferredSize(new Dimension(80,50));
			btnViewAllTickets.setBounds(10, 65, 150, 25);
			panelHomeScreen.add(btnViewAllTickets);
														
			JButton btnEditTickets  = new JButton("Update Tickets");
			btnEditTickets.addActionListener (new UpdateTickets_Click());
			btnEditTickets.setPreferredSize(new Dimension(80,50));
			btnEditTickets.setBounds(10, 100, 150, 25);
			panelHomeScreen.add(btnEditTickets);
			
			JButton btnCloseTicket  = new JButton("Close Tickets");
			btnCloseTicket.addActionListener (new CloseTicket_Click());
			btnCloseTicket.setPreferredSize(new Dimension(80,50));
			btnCloseTicket.setBounds(10, 135, 150, 25);
			panelHomeScreen.add(btnCloseTicket);
			
			JButton btnPurgeTicketTickets = new JButton("Purge Ticket");
			btnPurgeTicketTickets.addActionListener (new PurgeTickets_Click());
			btnPurgeTicketTickets.setPreferredSize(new Dimension(80,50));
			btnPurgeTicketTickets.setBounds(10, 170, 150, 25);
			panelHomeScreen.add(btnPurgeTicketTickets);
			
		}

		
		static class UpdateTickets_Click implements ActionListener {        
			  public void actionPerformed (ActionEvent e) {	
				  bMultiple = false;
				  EditTicket.InitialEditScreen();				 
			  }
			}
		
		static class NewTicket_Click implements ActionListener {        
			  public void actionPerformed (ActionEvent e) {	
				  NewTicket.InitiateNewTicket();
				  
				 
			  }
			}
		
		 static class PurgeTickets_Click implements ActionListener {        
			  public void actionPerformed (ActionEvent e) {
				  PurgeTicket.InitiatePurgeTicket();		
			  }
			}
		 
		 static class ViewAllTickets_Click implements ActionListener {        
			  public void actionPerformed (ActionEvent e) {
				  
				  	 ViewAllTickets.InitiateViewAllTickets();			  			
			  }
			}
		 
		 static class CloseTicket_Click implements ActionListener {        
			  public void actionPerformed (ActionEvent e) {
				 CloseTicket.InitiateCloseTicket();
				  			  			
			  }
			}
		 
		 
		 
				}
			 
