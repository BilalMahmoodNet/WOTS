import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost";
	
	static final String USER = "root";
	static final String PASS = "netbuilder";
	
	private Connection conn = null;
	private Statement stmt = null;

	public void accessDB() {
	
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public ResultSet queryDB(String query) {
		ResultSet result = null;
		
		try {
			Statement stmt = conn.createStatement();
			
	        System.out.println("The SQL query is: " + query); // Echo For debugging
	        System.out.println();
	 
	        result = stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
		
	}

}

