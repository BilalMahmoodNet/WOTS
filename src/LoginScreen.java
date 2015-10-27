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
						System.out.println("Press 2 to create a new purchase order");
						System.out.println("Press 3 to view orders");
						System.out.println("Press 4 to view products");
						System.out.println("Press 5 to edit the status of a order");
						System.out.println("Press 6 to quit");
							int choice = input.nextInt();
							switch (choice) {
												case 1: System.out.println("You selected to create a new customer order");
																newCustomerOrder();
														break;
												case 2: System.out.println("You selected to create a new supplier order");
																newPurchaseOrder();
														break;
												case 3: System.out.println("You selected to view orders");
																readOrder();
														break;
												case 4: System.out.println("You selected to view the products");
																readStock();
														break;
												case 5: System.out.println("You selected status update");
												System.out.println("Not Ready YET!!");
														break;
												case 6: System.out.println("Bye!!");
																System.exit(0);
														break;
											}
						}
			
	private void newCustomerOrder()
	{
		System.out.println("Enter Customer OrderID:");
		int customerOrderID = input.nextInt();
		
		System.out.println("Enter Customer Name:");
		String customerName = input.next();
		
		System.out.println("Enter Employee Name:");
		String employeeWorking = input.next();
		
		System.out.println("Enter Checked Out:");
		String checkedOut = input.next();
		
		String sql = "INSERT INTO customerorder (customerOrderID, customerName, employeeWorking, checkedOut) VALUES ("+customerOrderID+", '"+customerName+"', '"+employeeWorking+"', '"+checkedOut+"')"; //string concatination
		DB.CreateOrder(sql);
		newCustomerOrderLine();
		
	}
	
	private void updateOrderStatus()//update
	{
		System.out.println("Enter the number of the order you would like to edit");
		int x = input.nextInt();
		System.out.println("Enter the employees name working on the order");
		String y = input.next();
		System.out.println("Is the order being checked out");
		String z = input.next();
		DB.UpdateWorking(x,y,z);
	}
	
	private void DeleteProduct()//update
	{
		System.out.println("Enter the number of the order you would like to delete");
		int x = input.nextInt();
		DB.DeleteProduct(x);
	}
	
	private void newCustomerOrderLine()
	{
		System.out.println("Enter Customer OrderID:");
		int customerOrderID = input.nextInt();
		
		System.out.println("Enter Product Name:");
		String productName = input.next();
		
		System.out.println("Enter Quantity:");
		int quantity = input.nextInt();
		
		String sql = "INSERT INTO customerorderline (customerOrderID, productName, quantity) VALUES ("+customerOrderID+", '"+productName+"', "+quantity+")"; //string concatination
		DB.CreateOrder(sql);
		
		System.out.println("Press 1 to add to the order");
		System.out.println("Press 2 to go to the main menu");
		
		int x = input.nextInt();
		switch (x) {
		case 1: System.out.println("You chose to add to the order");
											newCustomerOrderLine();
											break;
		case 2: System.out.println("You chose main menu");
											menu();
											break;
		}
				
		
	}
	
	private void newPurchaseOrder()
	{
		System.out.println("Enter Purchase ID:");
		int purchaseOrderID = input.nextInt();
		
		System.out.println("Enter Purchase Name:");
		String purchaseName = input.next();
		
		System.out.println("Enter Employee Name:");
		String employeeWorking = input.next();
		
		System.out.println("Is the Order Checked Out?:");
		String checkedOut = input.next();
		
		String sql = "INSERT INTO purchaseOrder (purchaseOrderID, purchaseName, employeeWorking, checkedOut) VALUES ("+purchaseOrderID+", '"+purchaseName+"', '"+employeeWorking+"', '"+checkedOut+"')"; //string concatination
		DB.CreatePurchaseOrder(sql);
		newPurchaseOrderLine();
	}
	
	private void newPurchaseOrderLine()
	{
		System.out.println("Enter Purchase ID:");
		int purchaseID = input.nextInt();
		
		System.out.println("Enter Product Name:");
		String productName = input.next();
		
		System.out.println("Enter Quantity:");
		String quantity = input.next();
				
		String sql = "INSERT INTO purchaseOrderLine (purchaseOrderID, productName, quantity) VALUES ("+purchaseID+", '"+productName+"', "+quantity+")"; //string concatination
		DB.CreatePurchaseOrder(sql);
		
		System.out.println("Press 1 to add to the order");
		System.out.println("Press 2 to go to the main menu");
		
		int x = input.nextInt();
		switch (x) {
		case 1: System.out.println("You chose to add to the order");
											newPurchaseOrderLine();
											break;
		case 2: System.out.println("You chose main menu");
											menu();
											break;
		}
	}
	
	private void readOrder()
	{
		System.out.println("Press 1 to view Supplier orders");
		System.out.println("Press 2 to view Customer orders");
		System.out.println("Press 3 to view Picked orders");
		System.out.println("Press 4 to view Packed orders");
		System.out.println("Press 5 to view PorousWear Orders");
		System.out.println("Press 6 to return");
		
		int choice = input.nextInt();
		
			switch (choice) {
							case 1: System.out.println("View Purchase Orders");
										ArrayList<purchaseorder> listOfOrders =	DB.readAllPurchaseOrders();
										for(int i = 0; i < listOfOrders.size(); i++) {
											System.out.println(
													"Purchase ID : " + listOfOrders.get(i).getPurchaseOrderID() +
													",Purchase Name : " + listOfOrders.get(i).getPurchaseName()
													);
											}
										selectPurchaseOrderLine();
										break;
							case 2: System.out.println("View Customer Orders");
										ArrayList<customerorder> listOfOrders1 = DB.readAllCustomerOrders();
										for (int i= 0; i<listOfOrders1.size(); i++){
											System.out.println(
													"Customer ID : " + listOfOrders1.get(i).getCustomerOrderID() +
													", Customer Name : " + listOfOrders1.get(i).getCustomerName() +
													", Employee Working is : " + listOfOrders1.get(i).getEmployeeWorking() +
													", Checked Out : " + listOfOrders1.get(i).getCheckedOut()									
													);
											}
										System.out.println("If you would like to change order status press 1");
										System.out.println("If you would like to view purchase order line press 2");
										int chance = input.nextInt();
										
											switch (chance) {
											case 1: System.out.println("Change order status");
											updateOrderStatus();
											break;
											case 2: System.out.println("View Order ");
											newCustomerOrderLine();
											}
										break;
							case 3: System.out.println("View Picked Orders");							
										ArrayList<customerorder> listOfOrders2 = DB.readPickedOrder();
										for (int i= 0; i<listOfOrders2.size(); i++){
											System.out.println(
													"Customer ID : " + listOfOrders2.get(i).getCustomerOrderID() +
													", Order ID : " + listOfOrders2.get(i).getCustomerName() +
													", Employee Working is : " + listOfOrders2.get(i).getEmployeeWorking() +
													", Checked Out : " + listOfOrders2.get(i).getCheckedOut()									
													);
											}
										readOrder();
									break;	
							case 4: System.out.println("View Packed Orders");
										ArrayList<customerorder> listOfOrders3 = DB.readPickedOrder();
										for (int i= 0; i<listOfOrders3.size(); i++){
											System.out.println(
													"Customer ID : " + listOfOrders3.get(i).getCustomerOrderID() +
													", Order ID : " + listOfOrders3.get(i).getCustomerName() +
													", Employee Working is : " + listOfOrders3.get(i).getEmployeeWorking() +
													", Checked Out : " + listOfOrders3.get(i).getCheckedOut()									
													);
										}
										readOrder();
										break;
							case 5: System.out.println("View Porous Orders");
							ArrayList<customerorderline> listOfOrders10 = DB.readPorous();
							for (int i= 0; i<listOfOrders10.size(); i++){
								System.out.println("Purchase ID: " + listOfOrders10.get(i).getCustomerOrderID() +
										",Product Name:" + listOfOrders10.get(i).getProductName() +
										",Quantity: " + listOfOrders10.get(i).getQuantity() 									
										);
							}
							readOrder();
							break;			
							case 6: System.out.println("Return");
										menu();
								
			}		
	}
	
	private void selectPurchaseOrderLine()
	{	
		System.out.println("Enter the number of the order you would like to view");
		int x = input.nextInt();
		ArrayList<purchaseorderline> listOfOrders = DB.readPurchaseOrderByID(x);
		for(int i = 0; i<listOfOrders.size(); i++){
			System.out.println("Purchase ID: " + listOfOrders.get(i).getPurchaseOrderID() +
					",Product Name:" + listOfOrders.get(i).getProductName() +
					",Quantity: " + listOfOrders.get(i).getQuantity() 
					);
		}		
		menu();
		}
	
	private void selectCustomerOrderLine()
	{
		System.out.println("Enter the number of the order you would like to view");
		int x = input.nextInt();
		ArrayList<customerorderline> listOfOrders = DB.readCustomerOrderByID(x);
		for(int i = 0; i<listOfOrders.size(); i++){
			System.out.println("Purchase ID: " + listOfOrders.get(i).getCustomerOrderID() +
					",Product Name:" + listOfOrders.get(i).getProductName() +
					",Quantity: " + listOfOrders.get(i).getQuantity() 
					);
		}	
		menu();
	}
	
	private void readStock() // method gets stock sheet from database
		{
			ArrayList<product> listOfOrders4 = DB.readStock();
				for (int i= 0; i<listOfOrders4.size(); i++){
				System.out.println("Product ID : " + listOfOrders4.get(i).getProductID()
								+ ", Product Name : " + listOfOrders4.get(i).getProductName() +
									", Product Description : " + listOfOrders4.get(i).getProductDescription() +
									", Quantity : " + listOfOrders4.get(i).getQuantity() +
									",Location : " + listOfOrders4.get(i).getLocation()
									);
				
		}
				DeleteProduct();
	}

	
	}

