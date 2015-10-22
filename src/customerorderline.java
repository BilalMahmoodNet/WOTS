import java.util.ArrayList;


public class customerorderline {
	
	protected int productID; 
	protected int orderID;
	protected int quantity;
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	protected static void CustomerOrderLine()
	{	DBConnect DB = new DBConnect();
		ArrayList<customerorderline> listOfOrders5 = DB.readOrders();
			for (int i= 0; i<listOfOrders5.size(); i++){
			System.out.println("Product ID : " + listOfOrders5.get(i).getProductID());
			}
	}
}
	
	

