import java.util.Scanner;


public class main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		LoginScreen l = new LoginScreen();
		String username;
		String password;
		
		System.out.println("Welcome Employee!");
		System.out.println("Please enter ID:");
		username = input.next();
		
		System.out.println("Password: ");
		password = input.next();
		
		if (username.equals(username) && password.equals(password))
			System.out.println("You are logged in");
		
		
		l.menu();
	}
}
