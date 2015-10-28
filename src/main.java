
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
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	
	public static void main(String[] args){
		Scanner string = new Scanner(System.in);
		LoginScreen l = new LoginScreen();
		String username;
		String password;
		
		main sD = new main();
		sD.showEvent();
		
		System.out.println("Welcome Employee!");
		System.out.println("Please enter ID:");
		username = string.next();
		
		System.out.println("Password: ");
		password = string.next();
		
		if (username.equals(username) && password.equals(password))
			System.out.println("You are logged in");
		
			
		
		l.menu();
	}
	
	public main(){prepareGUI();}
	
	private void prepareGUI() {
		mainFrame = new JFrame("GUI EXAMPLE");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
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
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
	
	private void showEvent() {
		headerLabel.setText("Press Button");
		JButton okButton = new JButton("OK");	
			JButton("OK");
		JButton submitButton = new JButton("Submit");
			JButton("Submit");
		JButton cancelButton = new JButton("Cancel");
			JButton("Cancel");
		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancel");
		
		okButton.addActionListener(new BCL ());
		submitButton.addActionListener(new BCL());
		cancelButton.addActionListener(new BCL());
		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);
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
			case "OK": statusLabel.setText("OK!");
			break;
			case "Submit": statusLabel.setText("Submitted ! ");
			break;
			case "Cancel": statusLabel.setText("Cancel not possible");
			break;
	}}}
}


