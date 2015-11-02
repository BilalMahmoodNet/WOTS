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
	
	public void CreatePurchaseOrder(String sql) //create in the database
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
	
	public ArrayList<purchaseorder> readAllPurchaseOrders()//Select all coloumn's from the Supplier Order Table stores in a arraylist
	{
		ArrayList<purchaseorder> listOfOrders = new ArrayList<purchaseorder>();
		String readpurchase = "SELECT * FROM purchaseorder";
		accessDB(); 
		ResultSet rspurchase ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rspurchase = stmt.executeQuery(readpurchase);
			
		while (rspurchase.next()) {
			
			purchaseorder po = new purchaseorder(); // creates a instance of the supplier order class

			int PID = rspurchase.getInt("purchaseOrderID"); //getters
			String PN = rspurchase.getString("purchaseName");
			String EW = rspurchase.getString("employeeWorking");
			String CO = rspurchase.getString("checkedOut");
			
			
			
			po.setPurchaseOrderID(PID); //setters
			po.setPurchaseName(PN);
			po.setEmployeeWorking(EW);
			po.setCheckedOut(CO);
			
			
			listOfOrders.add(po); //stores array list in supplier order object
		}
		rspurchase.close();
		return listOfOrders;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<purchaseorderline> readPurchaseOrderByID(int purchaseOrderID)//Select all coloumn's from the Supplier Order Table stores in a arraylist
	{
		ArrayList<purchaseorderline> listOfOrders = new ArrayList<purchaseorderline>();
		String readpurchase = "SELECT * FROM purchaseorderline WHERE purchaseOrderID = " + purchaseOrderID;
		accessDB(); 
		ResultSet rspurchase ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rspurchase = stmt.executeQuery(readpurchase);
			
		while (rspurchase.next()) {
			
			purchaseorderline pol = new purchaseorderline(); // creates a instance of the supplier order class

			int PID = rspurchase.getInt("purchaseOrderID"); //getters
			String PN = rspurchase.getString("productName");
			int QTY = rspurchase.getInt("quantity");
			
			pol.setPurchaseOrderID(PID); //setters
			pol.setProductName(PN);
			pol.setQuantity(QTY);
			
			listOfOrders.add(pol); //stores array list in supplier order object
		}
		rspurchase.close();
		return listOfOrders;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<customerorderline> readCustomerOrderByID(int CustomerOrderID)
	{
		ArrayList<customerorderline> listOfOrders = new ArrayList<customerorderline>();
		String readpurchase = "SELECT * FROM customerorderline WHERE customerOrderID = " + CustomerOrderID;
		accessDB(); 
		ResultSet rspurchase ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rspurchase = stmt.executeQuery(readpurchase);
			
		while (rspurchase.next()) {
			
			customerorderline col = new customerorderline(); // creates a instance of the supplier order class

			int PID = rspurchase.getInt("customerOrderID"); //getters
			String PN = rspurchase.getString("productName");
			int QTY = rspurchase.getInt("quantity");
			
			col.setCustomerOrderID(PID); //setters
			col.setProductName(PN);
			col.setQuantity(QTY);
			
			listOfOrders.add(col); //stores array list in supplier order object
		}
		rspurchase.close();
		return listOfOrders;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
		
	}
	
	public ArrayList<customerorder> readAllCustomerOrders() //Select all coloumn's from Customer Order Tables and stores in a arraylist
	{
		ArrayList<customerorder> listOfOrders1 = new ArrayList<customerorder>();
		String readcustomer = "SELECT * FROM customerorder"; //select statement 
		accessDB(); // opens connections
		ResultSet rscustomer ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rscustomer = stmt.executeQuery(readcustomer);
		while (rscustomer.next()) {
			
			customerorder co = new customerorder(); // creates an instance
			
			int COID = rscustomer.getInt("customerOrderID"); //getter
			String CN= rscustomer.getString("customerName");
			String EW = rscustomer.getString("employeeWorking");
			String CO = rscustomer.getString("checkedOut");
						
			co.setCustomerOrderID(COID); //setter
			co.setCustomerName(CN);
			co.setEmployeeWorking(EW);
			co.setCheckedOut(CO);
			
			listOfOrders1.add(co);// adds arraylist 
			
			
			//System.out.println("Product ID : " + PID + ", 		Order_ID : " + OID + ", 		Progress : " + pro);
		}
		rscustomer.close();
		return listOfOrders1;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
		
	public ArrayList<customerorder> readPickedOrder() //Select all coloumn's from Customer Order Tables with the progress as picked and stores in a arraylist
	{
		ArrayList<customerorder> listOfOrders2 = new ArrayList<customerorder>();
		String ReadCustomerPicked = "SELECT * FROM customerorder WHERE progress = 'picked'"; //SQL statement
		accessDB(); //opens connection
		ResultSet rscustomerpicked ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rscustomerpicked = stmt.executeQuery(ReadCustomerPicked);
		while (rscustomerpicked.next()) {
			
customerorder co = new customerorder(); // creates an instance
			
			int COID = rscustomerpicked.getInt("customerOrderID"); //getter
			String CN= rscustomerpicked.getString("customerName");
			String EW = rscustomerpicked.getString("employeeWorking");
			String CO = rscustomerpicked.getString("checkedOut");
						
			co.setCustomerOrderID(COID); //setter
			co.setCustomerName(CN);
			co.setEmployeeWorking(EW);
			co.setCheckedOut(CO);
			
			listOfOrders2.add(co);// adds arraylist 
			
		}
		rscustomerpicked.close();
		return listOfOrders2;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<customerorderline> readPorous() //Select all coloumn's from Customer Order Tables and stores in a arraylist
	{
		ArrayList<customerorderline> listOfOrders10 = new ArrayList<customerorderline>();
		String readcustomer = "SELECT * FROM customerorderline WHERE productName LIKE '%Porous%'"; //select statement 
		accessDB(); // opens connections
		ResultSet rsporous ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rsporous= stmt.executeQuery(readcustomer);
			
		while (rsporous.next()) {
			
			customerorderline col = new customerorderline(); // creates a instance of the supplier order class

			int PID = rsporous.getInt("customerOrderID"); //getters
			String PN = rsporous.getString("productName");
			int QTY = rsporous.getInt("quantity");
			
			col.setCustomerOrderID(PID); //setters
			col.setProductName(PN);
			col.setQuantity(QTY);
			
			listOfOrders10.add(col); //stores array list in supplier order object
		}
		rsporous.close();
		return listOfOrders10;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
		
	public ArrayList<customerorder> readPackedOrder() //Select all coloumns's from Customer Order Tables with the progress as packed and stores in a arraylist
	{
		ArrayList<customerorder> listOfOrders3 = new ArrayList<customerorder>(); // creation of arraylist
		String ReadCustomerPacked = "SELECT * FROM customerorder WHERE progress = 'packed'"; //select statement 
		accessDB(); //opens connection
		ResultSet rscustomer ; 
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rscustomer = stmt.executeQuery(ReadCustomerPacked);
			while (rscustomer.next()) {
			
				customerorder co = new customerorder(); // creates an instance
				
				int COID = rscustomer.getInt("customerOrderID"); //getter
				String CN= rscustomer.getString("customerName");
				String EW = rscustomer.getString("employeeWorking");
				String CO = rscustomer.getString("checkedOut");
							
				co.setCustomerOrderID(COID); //setter
				co.setCustomerName(CN);
				co.setEmployeeWorking(EW);
				co.setCheckedOut(CO);
				
				listOfOrders3.add(co);// adds arraylist 
										}
		rscustomer.close();
		return listOfOrders3;
		} catch (SQLException e){
				e.printStackTrace();
				return null;
			} 
	}
	
	public ArrayList<product> readStock() //selects all coloumns in the product DB
	{
		ArrayList<product> listOfOrders4 = new ArrayList<product>(); //creates a array list
		String ReadProduct = "SELECT * FROM product";
		accessDB();
		ResultSet rsstock;
		try
		{
				System.out.println("Creating Statement....");
				stmt= conn.createStatement();
				rsstock = stmt.executeQuery(ReadProduct);
						while (rsstock.next()) {
											product product = new product(); // creates instance of the class
											
											int PRID = rsstock.getInt("productID"); //getter
											String PN = rsstock.getString("productName");
											String PD = rsstock.getString("productDescription");
											int QTY = rsstock.getInt("quantity");
											String LOC = rsstock.getString("location");
											
											product.setProductID(PRID); //setter
											product.setProductName(PN);
											product.setProductDescription(PD);
											product.setQuantity(QTY);
											product.setLocation(LOC);
											
											listOfOrders4.add(product);		
											}
						rsstock.close();
						return listOfOrders4;
						} catch (SQLException e){
								e.printStackTrace();
								return null;
							} 
					}
	
	public void UpdateWorking(int ID, String working, String checked)//UPDATE
	{
		String updateorder = "UPDATE customerorder " + "SET employeeWorking = '" + working + "', checkedout = '"+ checked + "' WHERE customerorderID = " + ID;
		System.out.println(updateorder);
		accessDB(); 
		
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			stmt.executeUpdate(updateorder);
		
		} catch (SQLException e){
				e.printStackTrace();
			
		} 
	}
	
	public void DeleteProduct(int ID)//UPDATE
	{
		String deleteProduct = "DELETE FROM product " + " WHERE productID = " + ID;
		System.out.println(deleteProduct);
		accessDB(); 
		
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			stmt.executeUpdate(deleteProduct);
		
		} catch (SQLException e){
				e.printStackTrace();
			
		} 
	}
	
	
	
	
	
	
	
	
	
	/*public ArrayList<customerorderline> readOrders()
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
	}*/
			
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

