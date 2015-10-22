import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class LoginScreen {
 
	DBConnect DB = new DBConnect();
	Scanner input = new Scanner(System.in);
	Statement stmt = null;
		
	public void menu() { 
		
						System.out.println("*****************************");
						System.out.println("         MAIN MENU");
						System.out.println("Press 1 to create a new customer order");
						System.out.println("Press 2 to view customer orders");
						System.out.println("Press 3 to view stocklist");
						System.out.println("Press 4 to create a new supplier order");
						System.out.println("Press 5 to view order line");
						System.out.println("Press 6 to quit");
							int choice = input.nextInt();
							switch (choice) {
												case 1: System.out.println("You selected to create a new customer order");
																newOrder();
														break;
												case 2: System.out.println("You selected to view customer orders");
																readOrder();
														break;
												case 3: System.out.println("You selected to view the stocklist");
																readStock();
														break;
												case 4: System.out.println("You selected to create a new supplier order");
																newSupplierOrder();
														break;
												case 5: System.out.println("You select to view the customer orders line");
																customerorderline.CustomerOrderLine();
												case 6: System.out.println("Bye!!");
																System.exit(0);
														break;
											}
						}
			
	private void newOrder()
	{
		System.out.println("Enter ProductID:");
		int productID = input.nextInt();
		
		System.out.println("Enter progress:");
		String progress = input.next();
		
		System.out.println("Enter price:");
		int price = input.nextInt();
		
		System.out.println("Enter qty:");
		int qty = input.nextInt();
		
		String sql = "INSERT INTO customerorder (productID, progress, price, qty) VALUES ("+productID+", '"+progress+"', "+price+", "+qty+")"; //string concatination
		DB.CreateOrder(sql);
		
		
	}
	
	private void newSupplierOrder()
	{
		System.out.println("Enter Supplier ID:");
		int supplierID = input.nextInt();
		
		System.out.println("Enter Supplier Name:");
		String supplierName = input.next();
		
		System.out.println("Enter Product ID:");
		int productID = input.nextInt();
		
		System.out.println("Enter Quantity:");
		int quantity = input.nextInt();
		
		System.out.println("Enter OrderID:");
		int orderID = input.nextInt();
		
		String sql = "INSERT INTO supplierorder (supplierID, supplierName, productID, quantity, orderID) VALUES ("+supplierID+", '"+supplierName+"', "+productID+", "+quantity+", "+orderID+")"; //string concatination
		DB.CreateSupplierOrder(sql);
	}
	
	private void readOrder()
	{
		System.out.println("Press 1 to view Supplier orders");
		System.out.println("Press 2 to view Customer orders");
		System.out.println("Press 3 to view Picked orders");
		System.out.println("Press 4 to view Packed orders");
		System.out.println("Press 5 to return");
		
		int choice = input.nextInt();
		
			switch (choice) {
							case 1: System.out.println("View Supplier Orders");
										ArrayList<SupplierOrder> listOfOrders =	DB.readAllSupplierOrders();
										for(int i = 0; i < listOfOrders.size(); i++) {
											System.out.println(
													"Supplier ID : " + listOfOrders.get(i).getSupplierID() +
													",Supplier Name : " + listOfOrders.get(i).getSupplierName() +
													",Product ID : " + listOfOrders.get(i).getProductID() +
													",Quantity : " + listOfOrders.get(i).getQuantity() +
													",Order ID : " + listOfOrders.get(i).getOrderID()
													);
											readOrder();
											}
										break;
							case 2: System.out.println("View Customer Orders");
										ArrayList<CustomerOrder> listOfOrders1 = DB.readAllCustomerOrders();
										for (int i= 0; i<listOfOrders1.size(); i++){
											System.out.println(
													"Product ID : " + listOfOrders1.get(i).getProductID() +
													", Order ID : " + listOfOrders1.get(i).getOrderID() +
													", Progress : " + listOfOrders1.get(i).getProgress() +
													", Price : " + listOfOrders1.get(i).getPrice() +
													", Qty : " + listOfOrders1.get(i).getQty()									
													);
											readOrder();
										}
										break;
							case 3: System.out.println("View Picked Orders");							
										ArrayList<CustomerOrder> listOfOrders2 = DB.readPickedOrder();
										for (int i= 0; i<listOfOrders2.size(); i++){
											System.out.println(
													"Product ID : " + listOfOrders2.get(i).getProductID() +
													", Order ID : " + listOfOrders2.get(i).getOrderID() +
													", Progress : " + listOfOrders2.get(i).getProgress() +
													", Price : " + listOfOrders2.get(i).getPrice() +
													", Qty : " + listOfOrders2.get(i).getQty()									
													);
											readOrder();
										}
									break;	
							case 4: System.out.println("View Packed Orders");
										ArrayList<CustomerOrder> listOfOrders3 = DB.readPickedOrder();
										for (int i= 0; i<listOfOrders3.size(); i++){
											System.out.println(
												"Product ID : " + listOfOrders3.get(i).getProductID() +
													", Order ID : " + listOfOrders3.get(i).getOrderID() +
													", Progress : " + listOfOrders3.get(i).getProgress() +
													", Price : " + listOfOrders3.get(i).getPrice() +
													", Qty : " + listOfOrders3.get(i).getQty()									
													);
											readOrder();
										}
										break;
							case 5: System.out.println("Return");
										menu();
								
			}		
	}
	
	private void readStock() // method gets stock sheet from database
		{
			ArrayList<Product> listOfOrders4 = DB.readStock();
				for (int i= 0; i<listOfOrders4.size(); i++){
				System.out.println("Product ID : " + listOfOrders4.get(i).getProductID()
								+ ", Quantity : " + listOfOrders4.get(i).getQuantity() +
									", Name : " + listOfOrders4.get(i).getName() +
									", Location : " + listOfOrders4.get(i).getLocation() +
									",Price : " + listOfOrders4.get(i).getPrice()
									);
		}
	}

	
	}

