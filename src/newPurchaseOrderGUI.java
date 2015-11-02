import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class newPurchaseOrderGUI 
{
	
	private JPanel purchasePanel;
	
	Container newPurchase = new Container();
	
	JFrame purchaseFrame = new JFrame("New Purchase Order");
 
	public newPurchaseOrderGUI() 
	{
		newPurchase();
		purchaseFrame.setSize(1000,300);
		purchaseFrame.setVisible(true);
	}
		
	public void newPurchase()
	{

		newPurchase.setLayout(new FlowLayout());
		
		purchasePanel = new JPanel();
		
		JButton newCustomerOrder = new JButton("Add New Customer Order");
		JButton viewOrders = new JButton("View Orders");
		JButton viewProducts = new JButton("View Products");
		JButton exit = new JButton("Exit");
		
		newCustomerOrder.setActionCommand("newCustomerOrder");
		viewOrders.setActionCommand("viewOrder");
		viewProducts.setActionCommand("viewProduct");
		exit.setActionCommand("exit");
		
		newCustomerOrder.addActionListener(new BCL (purchaseFrame));
		viewOrders.addActionListener(new BCL (purchaseFrame));
		viewProducts.addActionListener(new BCL (purchaseFrame));
		exit.addActionListener(new BCL (purchaseFrame));
		
		purchasePanel.add(newCustomerOrder);
		purchasePanel.add(viewOrders);
		purchasePanel.add(viewProducts);
		purchasePanel.add(exit);
			
		newPurchase.add(purchasePanel); //panel is added to the container
		purchaseFrame.add(newPurchase); //container is added to the frame
		purchasePanel.setVisible(true);
		newPurchase.setVisible(true);
	}
}

