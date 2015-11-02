import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;


public class mainGUI extends JFrame {
	
	private JPanel mainPanel = new JPanel();
	
	Container main = new Container();
	Container viewCustomer = new Container();
	JFrame frame = new JFrame("Warehouse Order Tracker");
	
	public mainGUI() {
		mainmenu();
		frame.setSize(1000,300);
		frame.setVisible(true);
	}
	
	public void mainmenu() {
		
		frame.add(main); //container is added to the frame
		main.add(mainPanel); //panel is added to the container
		
		main.setLayout(new FlowLayout());
		
		JButton newCustomerOrder = new JButton("Create New Customer Order");
		JButton newPurchaseOrder = new JButton("Create New Purchase Order");
		JButton viewOrders = new JButton("View Orders");
		JButton viewProducts = new JButton("View Products");
		JButton exit = new JButton("Exit");
		
		newCustomerOrder.setActionCommand("newCustomerOrder");
		newPurchaseOrder.setActionCommand("newPurchase");
		viewOrders.setActionCommand("viewOrder");
		viewProducts.setActionCommand("viewProduct");
		exit.setActionCommand("exit");
		
		newCustomerOrder.addActionListener(new BCL (frame));
		newPurchaseOrder.addActionListener(new BCL (frame));
		viewOrders.addActionListener(new BCL (frame));
		viewProducts.addActionListener(new BCL (frame));
		exit.addActionListener(new BCL (frame));
		
		mainPanel.add(newCustomerOrder);
		mainPanel.add(newPurchaseOrder);
		mainPanel.add(viewOrders);
		mainPanel.add(viewProducts);
		mainPanel.add(exit);
		
		main.setVisible(true);
		mainPanel.setVisible(true);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

