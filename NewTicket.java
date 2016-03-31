import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;




public class NewTicket {
	
	static JFrame NewTicketFrame = new JFrame("IT HELP DESK");
	static JPanel NewTicketPanel = new JPanel();
	
	static JLabel lblTicketNumberID = new JLabel("To be Generted");
	static JTextArea txtTicketDescription = new JTextArea();
	
	
	static JList<String> listIssueType = new JList<String>();
	static JList<String> listTicketNumber_Delete = new JList<String>();
	
	static JTextField txtTicketNumberDelete = new JTextField();
	
	
	public static void  InitiateNewTicket()
	{
		NewTicketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);							
		NewTicketFrame.add(NewTicketPanel);
		HomeScreen_NewTicket(NewTicketPanel);
		NewTicketFrame.setSize(350, 300);
		NewTicketFrame.setLocationRelativeTo(null); 
		NewTicketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		NewTicketFrame.setResizable(false);
		NewTicketFrame.setVisible(true);
	}
	
	
	private static void  HomeScreen_NewTicket(JPanel panelTicketFrame)
	 {		
		panelTicketFrame.setLayout(null);
		panelTicketFrame.removeAll();
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
										
		JLabel lblTicketNumber = new JLabel("Ticket Number");
		lblTicketNumber.setBounds(50, 30, 125, 25);
		lblTicketNumber.setBorder(blackline);
		panelTicketFrame.add(lblTicketNumber);
		
		//JLabel LabelTicketNumberID = new JLabel("To be Generated");
		lblTicketNumberID.setBounds(175, 30, 125, 25);
		lblTicketNumberID.setBorder(blackline);
		lblTicketNumberID.setText("To be Generated");
		panelTicketFrame.add(lblTicketNumberID);
		
		JLabel lblTicketDescription = new JLabel("Ticket Description");
		lblTicketDescription.setBounds(50, 60, 125, 60);
		lblTicketDescription.setBorder(blackline);
		panelTicketFrame.add(lblTicketDescription);
		
		//JTextArea txtTicketDescription = new JTextArea();
		txtTicketDescription.setLineWrap(true);
		txtTicketDescription.setWrapStyleWord(true);		
		txtTicketDescription.setBorder(blackline);
		
		JScrollPane spTxtdescription = new JScrollPane(txtTicketDescription); 
		spTxtdescription.setBounds(175, 60, 125, 60);
		spTxtdescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);								
		txtTicketDescription.setText(null);
		//txtTicketDescription.enable();
		txtTicketDescription.setEnabled(true);
		//sp.enable();
		spTxtdescription.setEnabled(true);
		panelTicketFrame.add(spTxtdescription);
		   
		JLabel lblTicketIssueType = new JLabel("Issue Type");
		lblTicketIssueType.setBounds(50, 120, 125, 60);
		lblTicketIssueType.setBorder(blackline);
		panelTicketFrame.add(lblTicketIssueType);
											
		 Vector<String> temp = new Vector<String>();				   				  
		 temp  = DataAccessLayer.GetIssueTypes();
		 listIssueType.setListData(temp);
		
		 listIssueType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 listIssueType.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		 listIssueType.setVisibleRowCount(-1);	 
	     JScrollPane listScroller = new JScrollPane(listIssueType);
	     listScroller.setPreferredSize(new Dimension(60, 240));
	      listScroller.setBounds(175, 120, 125, 60);
	   // listIssueType.enable();
	     listIssueType.setEnabled(true);
	     panelTicketFrame.add(listScroller);	
	     
	     
	     JButton btnTicketSubmitButton = new JButton("Submit");
	    btnTicketSubmitButton.addActionListener (new EditMyTickets_Click());					
	    btnTicketSubmitButton.setBounds(50, 190, 80, 40);
	    
	    //TicketSubmitButton.show();
	   // btnTicketSubmitButton.setVisible(true);
	    panelTicketFrame.add(btnTicketSubmitButton);	
	 }
	
	static class EditMyTickets_Click implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {

			  if (txtTicketDescription.getText().trim().length() != 0 && listIssueType.getSelectedValue() != null )
				{
				  String []smyStringArray = new String[4];
				
				    smyStringArray = DataAccessLayer.InsertTicket(txtTicketDescription.getText(),LoginScreen.sLoginName,listIssueType.getSelectedValue().toString());					
					String sMessage = "<html>Ticket has been created!!<br>Ticket# : " + smyStringArray[0] + "</html>";
					JOptionPane.showMessageDialog(null, sMessage ,"IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
					NewTicketFrame.dispose();
			  
				}
			  else
			  {
				  if(txtTicketDescription.getText().trim().length() == 0 && listIssueType.getSelectedValue() == null  )
					{
						JOptionPane.showMessageDialog(null, "Please enter Issue description and select an Issue Type", "IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
					
					}
					else if(txtTicketDescription.getText().trim().length() == 0 && listIssueType.getSelectedValue() != null )
					{
						JOptionPane.showMessageDialog(null, "Please enter Issue description", "IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
					
					}
					else if(txtTicketDescription.getText().trim().length() != 0 && listIssueType.getSelectedValue() == null )
					{
						JOptionPane.showMessageDialog(null, "Please select an issue Type", "IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
						
					}	
			  }
		}
	}
}
	
	