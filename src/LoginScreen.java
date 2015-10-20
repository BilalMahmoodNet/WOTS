
import java.util.*;


public class LoginScreen {
	
	
	
	public static void main(String[] args){
		DBConnect conn = new DBConnect();
		Scanner input = new Scanner(System.in);
		
	/*	String username;
		String password;
		
		System.out.println("Welcome Employee!");
		System.out.println("Please enter ID:");
		username = input.next();
		
		System.out.println("Password: ");
		password = input.next();
		
		if (username.equals(username) && password.equals(password))
			System.out.println("You are logged in");
		*/
		conn.accessDB();
		
	}
}
