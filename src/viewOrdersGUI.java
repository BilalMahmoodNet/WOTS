import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class viewOrdersGUI 
{
	private JPanel orderPanel = new JPanel();
	private JPanel viewOrderPanel = new JPanel();
	Container viewOrderView = new Container();
	Container viewOrder = new Container();
	JFrame orderframe = new JFrame("View Orders");
	
	public viewOrdersGUI()
	{
		viewOrders();
		orders();
		orderframe.setSize(1000,300);
		orderframe.setVisible(true);
	}
	
	public void viewOrders() 
	{
		orderframe.add(viewOrder); //container is added to the frame
		orderframe.setLayout(new GridLayout(4, 1));
		viewOrder.add(orderPanel); //panel is added to the container
		viewOrder.setLayout(new FlowLayout());
		
		JButton newCustomerOrder = new JButton("Create New Customer Order");
		JButton newPurchaseOrder = new JButton("Create New Purchase Order");
		JButton viewProducts = new JButton("View Products");
		JButton exit = new JButton("Exit");
		
		newCustomerOrder.setActionCommand("newCustomerOrder");
		newPurchaseOrder.setActionCommand("newPurchase");
		viewProducts.setActionCommand("viewProduct");
		exit.setActionCommand("exit");
			
		newCustomerOrder.addActionListener(new BCL (orderframe));
		newPurchaseOrder.addActionListener(new BCL (orderframe));
		viewProducts.addActionListener(new BCL (orderframe));
		exit.addActionListener(new BCL (orderframe));
		
		orderPanel.add(newCustomerOrder);
		orderPanel.add(newPurchaseOrder);
		orderPanel.add(viewProducts);
		orderPanel.add(exit);
		
		viewOrder.setVisible(true);
		orderPanel.setVisible(true);
	}
	
	public void orders() 
	{
		orderframe.add(viewOrderPanel);
		viewOrderPanel.add(viewOrderView);	
		viewOrderPanel.setLayout(new FlowLayout());
		
		JButton viewSupplierOrders = new JButton("View Supplier");
		JButton viewCustomerOrders = new JButton("View Customer");
		JButton viewPickedOrders = new JButton("View Checked Out");
		JButton viewPackedOrders = new JButton("View Unchecked Out");
		JButton viewPorousWearOrders = new JButton("View Porouswear");

		viewSupplierOrders.setActionCommand("viewSupplier");
		viewCustomerOrders.setActionCommand("viewCustomer");
		viewPickedOrders.setActionCommand("viewPicked");
		viewPackedOrders.setActionCommand("viewPacked");
		viewPorousWearOrders.setActionCommand("viewPorouswear");

		viewSupplierOrders.addActionListener(new orderTypeBCL ());
		viewCustomerOrders.addActionListener(new orderTypeBCL ());
		viewPickedOrders.addActionListener(new orderTypeBCL ());
		viewPackedOrders.addActionListener(new orderTypeBCL ());
		viewPorousWearOrders.addActionListener(new orderTypeBCL ());

		viewOrderPanel.add(viewSupplierOrders);
		viewOrderPanel.add(viewCustomerOrders);
		viewOrderPanel.add(viewPickedOrders);
		viewOrderPanel.add(viewPackedOrders);
		viewOrderPanel.add(viewPorousWearOrders);
		
		viewOrder.setVisible(true);
		orderPanel.setVisible(true);
		viewOrderPanel.setVisible(true);
		orderframe.revalidate();
	}
}

