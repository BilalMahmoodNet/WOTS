import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class orderTypeBCL implements ActionListener {
	
	@Override	
	public void actionPerformed(ActionEvent ae){
		DBConnect DB = new DBConnect();
		String command = ae.getActionCommand();
			switch (command) {
				case "viewSupplier":
					ArrayList<purchaseorder> listOfOrders =	DB.readAllPurchaseOrders();
					for(int i = 0; i < listOfOrders.size(); i++) {
						System.out.println(
								"Purchase ID : " + listOfOrders.get(i).getPurchaseOrderID() +
								",Purchase Name : " + listOfOrders.get(i).getPurchaseName()
								);
						}
				break;
				case "viewCustomer": 
					ArrayList<customerorder> listOfOrders1 = DB.readAllCustomerOrders();
					for (int i= 0; i<listOfOrders1.size(); i++){
						System.out.println(
								"Customer ID : " + listOfOrders1.get(i).getCustomerOrderID() +
								", Customer Name : " + listOfOrders1.get(i).getCustomerName() +
								", Employee Working is : " + listOfOrders1.get(i).getEmployeeWorking() +
								", Checked Out : " + listOfOrders1.get(i).getCheckedOut()									
								);
						}
				break;
				case "viewPicked": 
					ArrayList<customerorder> listOfOrders2 = DB.readPickedOrder();
					for (int i= 0; i<listOfOrders2.size(); i++){
						System.out.println(
								"Customer ID : " + listOfOrders2.get(i).getCustomerOrderID() +
								", Order ID : " + listOfOrders2.get(i).getCustomerName() +
								", Employee Working is : " + listOfOrders2.get(i).getEmployeeWorking() +
								", Checked Out : " + listOfOrders2.get(i).getCheckedOut()									
								);
					}
				break;
				case "viewPacked": 
					ArrayList<customerorder> listOfOrders3 = DB.readPickedOrder();
					for (int i= 0; i<listOfOrders3.size(); i++){
						System.out.println(
								"Customer ID : " + listOfOrders3.get(i).getCustomerOrderID() +
								", Order ID : " + listOfOrders3.get(i).getCustomerName() +
								", Employee Working is : " + listOfOrders3.get(i).getEmployeeWorking() +
								", Checked Out : " + listOfOrders3.get(i).getCheckedOut()									
								);
					}
				break;
				case "viewPorouswear": 
					ArrayList<customerorderline> listOfOrders10 = DB.readPorous();
					for (int i= 0; i<listOfOrders10.size(); i++){
						System.out.println("Purchase ID: " + listOfOrders10.get(i).getCustomerOrderID() +
								",Product Name:" + listOfOrders10.get(i).getProductName() +
								",Quantity: " + listOfOrders10.get(i).getQuantity() 									
								);
					}
				break;
					}
			}
}
			



