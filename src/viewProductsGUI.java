import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class viewProductsGUI {

	private JPanel productPanel = new JPanel();
	
	
	Container viewProduct = new Container();
	JFrame productframe = new JFrame("View Products");
	
	
	
	public viewProductsGUI() {
		mainmenu();
		productframe.setSize(1000,300);
		productframe.setVisible(true);
	}
	
	public void mainmenu() {
		
		productframe.add(viewProduct); //container is added to the frame
		viewProduct.add(productPanel); //panel is added to the container
		
		viewProduct.setLayout(new FlowLayout());
		
		JButton newCustomerOrder = new JButton("Create New Customer Order");
		JButton newPurchaseOrder = new JButton("Create New Purchase Order");
		JButton viewOrders = new JButton("View Orders");
		JButton exit = new JButton("Exit");
		
		newCustomerOrder.setActionCommand("newCustomerOrder");
		newPurchaseOrder.setActionCommand("newPurchase");
		viewOrders.setActionCommand("viewOrder");
		exit.setActionCommand("exit");
		
		newCustomerOrder.addActionListener(new BCL (productframe));
		newPurchaseOrder.addActionListener(new BCL (productframe));
		viewOrders.addActionListener(new BCL (productframe));
		exit.addActionListener(new BCL (productframe));
		
		productPanel.add(newCustomerOrder);
		productPanel.add(newPurchaseOrder);
		productPanel.add(viewOrders);
		productPanel.add(exit);
		
		viewProduct.setVisible(true);
		productPanel.setVisible(true);
	}
		
		
	}


