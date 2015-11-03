import java.util.Scanner;
import javax.swing.JFrame;

public class main extends JFrame 
{
	public static void main(String[] args)
	{
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
}