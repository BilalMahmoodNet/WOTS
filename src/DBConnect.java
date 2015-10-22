import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnect { //class contains the database code

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   // the driver
	static final String DB_URL = "jdbc:mysql://localhost:3300/wots"; // My database URL
	
	static final String USER = "root";
	static final String PASS = "netbuilder";//database password
	
	public Connection conn = null;
	private Statement stmt = null;

	public void accessDB() {	// makes the connection
	
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
	
	private void closeDB() { //closes the connection
		try {
			if (stmt!= null)
				stmt.close();
		}catch (SQLException se) {}
		try {
			if (conn !=null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		System.out.println("Closed");
	}
	
	public ResultSet queryDB(String query) {  //stores the data returned
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
	
	
	public void CreateOrder(String sql) //creates a new customer order in the database
	{
		accessDB();// open connection
		try
		{	
		System.out.println("Inserting records into the table...");
		stmt= conn.createStatement();
		System.out.println(sql);
		stmt.executeUpdate(sql);
		System.out.println("Inserted Records into the table..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();//close connection
	}
	
	public void CreateSupplierOrder(String sql) //create in the database
	{
		accessDB();
		try
		{	
		System.out.println("Inserting records into the table...");
		stmt= conn.createStatement();
		System.out.println(sql);
		stmt.executeUpdate(sql);
		System.out.println("Inserted Records into the table..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	public ArrayList<SupplierOrder> readAllSupplierOrders()//Select all coloumn's from the Supplier Order Table stores in a arraylist
	{
		ArrayList<SupplierOrder> listOfOrders = new ArrayList<SupplierOrder>();
		String ReadSupplier = "SELECT * FROM supplierorder";
		accessDB(); 
		ResultSet rssupplier ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rssupplier = stmt.executeQuery(ReadSupplier);
			
		while (rssupplier.next()) {
			
			SupplierOrder supplierOrder = new SupplierOrder(); // creates a instance of the supplier order class

			int SID = rssupplier.getInt("supplierID"); //getters
			String SUN = rssupplier.getString("supplierName");
			int PID = rssupplier.getInt("productID");
			int QUA = rssupplier.getInt("quantity");
			int OID = rssupplier.getInt("orderID");
			
			
			supplierOrder.setSupplierID(SID); //setters
			supplierOrder.setSupplierName(SUN);
			supplierOrder.setProductID(PID);
			supplierOrder.setQuantity(QUA);
			supplierOrder.setOrderID(OID);
			
			listOfOrders.add(supplierOrder); //stores array list in supplier order object
		}
		rssupplier.close();
		return listOfOrders;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<CustomerOrder> readAllCustomerOrders() //Select all coloumn's from Customer Order Tables and stores in a arraylist
	{
		ArrayList<CustomerOrder> listOfOrders1 = new ArrayList<CustomerOrder>();
		String ReadCustomer = "SELECT * FROM customerorder"; //select statement 
		accessDB(); // opens connections
		ResultSet rscustomer ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rscustomer = stmt.executeQuery(ReadCustomer);
		while (rscustomer.next()) {
			
			CustomerOrder customerOrder = new CustomerOrder(); // creates an instance
			
			int OID = rscustomer.getInt("orderID"); //getter
			int PID = rscustomer.getInt("productID");
			String PRO = rscustomer.getString("progress");
			int PRI = rscustomer.getInt("price");
			int QTY = rscustomer.getInt("qty");
			
			customerOrder.setOrderID(OID); //setter
			customerOrder.setProductID(PID);
			customerOrder.setProgress(PRO);
			customerOrder.setPrice(PRI);
			customerOrder.setQty(QTY);
			
			listOfOrders1.add(customerOrder);// adds arraylist 
			
			
			//System.out.println("Product ID : " + PID + ", 		Order_ID : " + OID + ", 		Progress : " + pro);
		}
		rscustomer.close();
		return listOfOrders1;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<CustomerOrder> readPickedOrder() //Select all coloumn's from Customer Order Tables with the progress as picked and stores in a arraylist
	{
		ArrayList<CustomerOrder> listOfOrders2 = new ArrayList<CustomerOrder>();
		String ReadCustomerPicked = "SELECT * FROM customerorder WHERE progress = 'picked'"; //SQL statement
		accessDB(); //opens connection
		ResultSet rscustomerpicked ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rscustomerpicked = stmt.executeQuery(ReadCustomerPicked);
		while (rscustomerpicked.next()) {
			
			CustomerOrder customerOrderPicked = new CustomerOrder(); //creates a instance of the customer order class
			
			int OID = rscustomerpicked.getInt("orderID"); //getter
			int PID = rscustomerpicked.getInt("productID");
			String PRO = rscustomerpicked.getString("progress");
			int PRI = rscustomerpicked.getInt("price");
			int QTY = rscustomerpicked.getInt("qty");
			
			customerOrderPicked.setOrderID(OID); //setter
			customerOrderPicked.setProductID(PID);
			customerOrderPicked.setProgress(PRO);
			customerOrderPicked.setPrice(PRI);
			customerOrderPicked.setQty(QTY);
			
			listOfOrders2.add(customerOrderPicked); 
			
		}
		rscustomerpicked.close();
		return listOfOrders2;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<CustomerOrder> readPackedOrder() //Select all coloumns's from Customer Order Tables with the progress as packed and stores in a arraylist
	{
		ArrayList<CustomerOrder> listOfOrders3 = new ArrayList<CustomerOrder>(); // creation of arraylist
		String ReadCustomerPacked = "SELECT * FROM customerorder WHERE progress = 'packed'"; //select statement 
		accessDB(); //opens connection
		ResultSet rscustomerpacked ; 
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rscustomerpacked = stmt.executeQuery(ReadCustomerPacked);
			while (rscustomerpacked.next()) {
			
											CustomerOrder customerOrderPacked = new CustomerOrder(); //create instance of the class
											
											int OID = rscustomerpacked.getInt("orderID"); //getter
											int PID = rscustomerpacked.getInt("productID");
											String PRO = rscustomerpacked.getString("progress");
											int PRI = rscustomerpacked.getInt("price");
											int QTY = rscustomerpacked.getInt("qty");
											
											customerOrderPacked.setOrderID(OID); //setter
											customerOrderPacked.setProductID(PID);
											customerOrderPacked.setProgress(PRO);
											customerOrderPacked.setPrice(PRI);
											customerOrderPacked.setQty(QTY);
											
											listOfOrders3.add(customerOrderPacked); 
										}
		rscustomerpacked.close();
		return listOfOrders3;
		} catch (SQLException e){
				e.printStackTrace();
				return null;
			} 
	}
	
	public ArrayList<Product> readStock() //selects all coloums in the product DB
	{
		ArrayList<Product> listOfOrders4 = new ArrayList<Product>(); //creates a array list
		String ReadProduct = "SELECT * FROM product";
		accessDB();
		ResultSet rsstock;
		try
		{
				System.out.println("Creating Statement....");
				stmt= conn.createStatement();
				rsstock = stmt.executeQuery(ReadProduct);
						while (rsstock.next()) {
											Product product = new Product(); // creates instance of the class
											
											int PRID = rsstock.getInt("productID"); //getter
											int QTY = rsstock.getInt("quantity");
											String NAME = rsstock.getString("name");
											String LOC = rsstock.getString("location");
											int PRICE = rsstock.getInt("price");
											
											product.setProductID(PRID); //setter
											product.setQuantity(QTY);
											product.setName(NAME);
											product.setLocation(LOC);
											product.setPrice(PRICE);
											
											listOfOrders4.add(product);		
											}
						rsstock.close();
						return listOfOrders4;
						} catch (SQLException e){
								e.printStackTrace();
								return null;
							} 
					}
	
	public ArrayList<customerorderline> readOrders()
	{
		ArrayList<customerorderline> listOfOrders5 = new ArrayList<customerorderline>();
		String ReadOrders = "Select * from customerorderline";
		accessDB();
		ResultSet rsorders;
		try
		{
				System.out.println("Creating Statement....");
				stmt=conn.createStatement();
				rsorders = stmt.executeQuery(ReadOrders);
					while(rsorders.next()) {
												customerorderline CustomerOrderLine = new customerorderline();
												
												int OID = rsorders.getInt("orderID");
												int PID = rsorders.getInt("productID");
												int QUANTITY = rsorders.getInt("quantity");	
												
												CustomerOrderLine.setOrderID(OID);
												CustomerOrderLine.setProductID(PID);
												CustomerOrderLine.setQuantity(QUANTITY);
												
												listOfOrders5.add(CustomerOrderLine);
											}
						rsorders.close();
						return listOfOrders5;
		} catch (SQLException e){
				e.printStackTrace();
				return null;
		}
	}
			
	/*public void UpdateDatabase()
	{
		try
		{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sq13 = "UPDATE cus_order" + " SET Order_ID = 2 WHERE Product_ID = 1";
			System.out.println(sq13);
			stmt.executeUpdate(sq13);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteDatabase()
	{
		try
		{
			System.out.println("Creating Statement...");
			stmt = conn.createStatement();
			String sq14 = "DELETE FROM cus_order" + " WHERE Product_ID = 1";
			stmt.executeUpdate(sq14);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}

/*public void CreateProduct() //Enter product 
{

	try
	{	
	System.out.println("Inserting records into the table...");
	stmt= conn.createStatement();
	String sql = "INSERT INTO product" + " VALUES (, , '', '', )";
	System.out.println(sql);
	stmt.executeUpdate(sql);
	System.out.println("Inserted Records into the table..");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
*/

