import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;

public class newCustomerGUI 
{
	
	private JPanel CustomerPanel;
	
	Container newCustomer = new Container();
	
	JFrame customerFrame = new JFrame("New Customer Order");
 
	public newCustomerGUI() 
	{
		newCustomer();
		customerFrame.setSize(1000,300);
		customerFrame.setVisible(true);
	}
		
	public void newCustomer()
	{

		newCustomer.setLayout(new FlowLayout());
		
		CustomerPanel = new JPanel();
		
		JButton newPurchaseOrder = new JButton("Create New Purchase Order");
		JButton viewOrders = new JButton("View Orders");
		JButton viewProducts = new JButton("View Products");
		JButton exit = new JButton("Exit");
		
		newPurchaseOrder.setActionCommand("newPurchase");
		viewOrders.setActionCommand("viewOrder");
		viewProducts.setActionCommand("viewProduct");
		exit.setActionCommand("exit");
		
		newPurchaseOrder.addActionListener(new BCL (customerFrame));
		viewOrders.addActionListener(new BCL (customerFrame));
		viewProducts.addActionListener(new BCL (customerFrame));
		exit.addActionListener(new BCL (customerFrame));
		
		CustomerPanel.add(newPurchaseOrder);
		CustomerPanel.add(viewOrders);
		CustomerPanel.add(viewProducts);
		CustomerPanel.add(exit);
			
		newCustomer.add(CustomerPanel); //panel is added to the container
		customerFrame.add(newCustomer); //container is added to the frame
		CustomerPanel.setVisible(true);
		newCustomer.setVisible(true);
	}
}

