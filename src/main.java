
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class main extends JFrame {
	
	private JFrame mainFrame;
	private JFrame customerFrame;
	private JFrame purchaseFrame;
	private JFrame orderFrame;
	private JFrame productFrame;
	
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;	
	
	public static void main(String[] args){
		Scanner string = new Scanner(System.in);
		LoginScreen l = new LoginScreen();
		String username;
		String password;
		
		mainGUI GUI = new mainGUI();
		
		
		System.out.println("Welcome Employee!");
		System.out.println("Please enter ID:");
		username = string.next();
		
		System.out.println("Password: ");
		password = string.next();
		
		if (username.equals(username) && password.equals(password))
			System.out.println("You are logged in");
				
		l.menu();
	}
	
	/*public main(){prepareGUI();}
	
	private void prepareGUI() {
		mainFrame = new JFrame("GUI EXAMPLE");mainFrame.setSize(300, 300);mainFrame.setLayout(new GridLayout(3, 1));
		
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		
		mainFrame.addWindowListener(new WindowAdapter() 
	{
		public void 
		windowClosing(WindowEvent windowEvent)
		{
			System.exit(0);
		}
	});
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainFrame.add(controlPanel);
		mainFrame.add(headerLabel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
	
	private void showEventMain() {
		headerLabel.setText("Please choose an option");
		JButton customerButton = new JButton("New Customer");	
			JButton("New Customer");
		JButton purchaseOrderButton = new JButton("New Purchase");
			JButton("New Purchase");
		JButton ordersButton = new JButton("View Orders");
			JButton("View Orders");
		JButton productsButton = new JButton("View Products");
			JButton("View Products");
			
		customerButton.setActionCommand("New Customer");
		purchaseOrderButton.setActionCommand("New Purchase");
		ordersButton.setActionCommand("View Orders");
		productsButton.setActionCommand("View Products");
		
		customerButton.addActionListener(new BCL ());
		purchaseOrderButton.addActionListener(new BCL());
		ordersButton.addActionListener(new BCL());
		productsButton.addActionListener(new BCL());
		
		controlPanel.add(customerButton);
		controlPanel.add(purchaseOrderButton);
		controlPanel.add(ordersButton);
		controlPanel.add(productsButton);
		mainFrame.setVisible(true);
	}
	
	private void JButton(String string) {
		// TODO Auto-generated method stub
		
	}

	private class BCL implements ActionListener
	{
		public void actionPerformed (ActionEvent ae) {
			String command = ae.getActionCommand();
				switch (command) {
						case "New Customer": mainFrame.setVisible(false);customerFrame.setVisible(true);
							
						break;
						case "New Purchase": mainFrame.setVisible(false);purchaseFrame.setVisible(true);
						
						break;
						case "View Orders": mainFrame.setVisible(false);orderFrame.setVisible(true);
						
						break;
						case "View Products": mainFrame.setVisible(false);productFrame.setVisible(true);
						
						break;
	}}}*/
}
