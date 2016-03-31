import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class LoginScreen {

	static JFrame LoginFrame = new JFrame("IT HELP DESK");
	static JPanel LoginPanel = new JPanel();
	
	static int iLoginAttempt  = 0 ;	
	public  static String  sLoginName = null;

	static JTextField txtUserNameText = new JTextField(20);
	static JPasswordField txtUserPasswordText = new JPasswordField(20);
		
//	DataAccessLayer objDataAcessLayer = new DataAccessLayer();
		
	
	public static void main(String[] args)  
	{ 
		try
		{
			String sWelcomeMessage = "Welcome to the IT Help Desk System " + "\n" + "Press Ok button to continue" ;
			JOptionPane.showMessageDialog(null, sWelcomeMessage,"IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
			LoginScreen objLoginScreen = new LoginScreen();
			objLoginScreen.CreateLoginScreen();
		}
		
		catch (Exception e) {
			System.out.println("Server busy!!! Please try again");
		}
		
		
	/*	TableSetup tbs = new TableSetup();
		try {
			tbs.createDataBase();
			tbs.insertIntoDataBase();
		} 
		catch (Exception e) {
			System.out.println("Ërror Occured");
		}*/
		
		
	}
	
	// Create the login screen
	void CreateLoginScreen()
	{
		LoginFrame.setSize(300, 165);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		LoginFrame.add(LoginPanel);
		placeComponents_Login(LoginPanel);
		LoginFrame.setLocationRelativeTo(null); 
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		LoginFrame.setResizable(false);
		LoginFrame.setVisible(true);
	}
	
	//Create panel for login screen
	private static void placeComponents_Login(JPanel panel_Login) {

		panel_Login.setLayout(null);

		JLabel lblUserLabel = new JLabel("User");
		lblUserLabel.setBounds(10, 10, 80, 25);
		panel_Login.add(lblUserLabel);

		//JTextField userText = new JTextField(20);
		txtUserNameText.setBounds(100, 10, 160, 25);
		panel_Login.add(txtUserNameText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel_Login.add(passwordLabel);

		//JPasswordField passwordText = new JPasswordField(20);
		txtUserPasswordText.setBounds(100, 40, 160, 25);
		panel_Login.add(txtUserPasswordText);

		JButton loginButton = new JButton("login");
		loginButton.addActionListener (new btn_Login());
		loginButton.setBounds(10, 80, 80, 25);
		panel_Login.add(loginButton);
		
		JButton registerButton = new JButton("Cancel");
		registerButton.addActionListener (new btn_Cancel());
		registerButton.setBounds(180, 80, 80, 25);
		panel_Login.add(registerButton);
			
	}
	
	 static class btn_Login implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
			String sExists = "";
			sLoginName = txtUserNameText.getText();
			sExists = DataAccessLayer.ValidateUser(txtUserNameText.getText(),txtUserPasswordText.getText()); // getPassword
			if (sExists.equals("1"))
			{
				LoginFrame.setVisible(false);
				LoginScreen.sLoginName = txtUserNameText.getText();
				new HomeScreenClass().DisplayHomeScreen();
							
			}
			else if(sExists.equals("0") && iLoginAttempt<4)
			{
				JOptionPane.showMessageDialog(null, "Invalid Login details. Please try again","IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
				iLoginAttempt++;
				
			}
			else if(sExists.equals("0") && iLoginAttempt==4)
			{
				JOptionPane.showMessageDialog(null, "Exceeded number of attempts. Good Bye", "IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
				
		}
	}
	
	
	static class btn_Cancel implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
			 JOptionPane.showMessageDialog(null, "Have a nice day!!!","IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
			 System.exit(0);
		  }
		}
	
	
	
	
	
	 
	
		 
	
	 
	
	
	
	
	
	
	 
	  
	 
	 
	
	
	
	
	
	/*	private static void placeComponents1_Register(JPanel panel) {

		panel.setLayout(null);
		JLabel LabelFirstName = new JLabel("First Name");
		LabelFirstName.setBounds(30, 10, 50, 25);
		panel.add(LabelFirstName);

		JTextField TextFirstName = new JTextField(20);
		TextFirstName.setBounds(100, 10, 160, 25);
		panel.add(TextFirstName);
		
		
		JLabel LabelLastName = new JLabel("Last Name");
		LabelLastName.setBounds(30 ,40,80, 25);
		panel.add(LabelLastName);

		JTextField TextLastName = new JTextField(20);
		TextLastName.setBounds(100, 40, 160, 25);
		panel.add(TextLastName);
		
		JLabel LabelUserName= new JLabel("User Name");
		LabelUserName.setBounds(30 ,70,80, 25);
		panel.add(LabelUserName);

		JTextField TextUserName = new JTextField(20);
		TextUserName.setBounds(100, 70, 160, 25);
		panel.add(TextUserName);
		
		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setBounds(30 ,100,80, 25);
		panel.add(LabelPassword);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 100, 160, 25);
		panel.add(passwordText);
		
		JButton registerButton = new JButton("Submit");
		registerButton.addActionListener (new Action3());
		registerButton.setPreferredSize(new Dimension(80,50));
		registerButton.setBounds(30, 130, 80, 25);
		panel.add(registerButton);
		
		JButton CancelButton = new JButton("Cancel");
	
		registerButton.addActionListener (new Action2());
		CancelButton.setPreferredSize(new Dimension(50,50));
		CancelButton.setBounds(140, 130, 85, 25);
		panel.add(CancelButton);		
		
	}*/
	
	
	
	
// login button
	
	
	
	
	 
	 
	/* private static void OnRegister()
		{
			
			LoginFrame.setVisible(false);
		
			RegistrationFrame.setSize(300, 250);
			RegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			RegistrationFrame.add(RegistrationPanel);
			placeComponents1_Register(RegistrationPanel);
			RegistrationFrame.setLocationRelativeTo(null); 
			RegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			RegistrationFrame.setResizable(false);
			RegistrationFrame.setVisible(true);	
			
		}*/
	 
	
	 static class Action3 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
						
		  }
		}
	 
	/*void OnRegister()
	{
		  LoginFrame.setVisible(false);
		  JOptionPane.showMessageDialog(null, "asdfasdfasdf","IT HELP DESK", JOptionPane.INFORMATION_MESSAGE);
	}*/
	
	
	
	
	
	/*private JFrame LoginFrame = new JFrame("IT HELP DESK");
	private JButton bok = new JButton("OK");
	
	public void  LoginScreen1() {
	
		LoginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		LoginFrame.getContentPane().add(bok);
		
		bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				//new SecondFrame();
			}
		});
		f.setSize(100,100);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		//new LoginScreen();
		LoginScreen l  =  new LoginScreen();
		l.LoginScreen1();
	}*/
}
		
	

