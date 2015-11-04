import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BCL implements ActionListener {
		
	private JFrame frameToDestroy;
	
	public BCL() {
		
	}
	
	public BCL(JFrame frameToDestroy) {
		this.frameToDestroy = frameToDestroy;
	}
	
		@Override	
		public void actionPerformed(ActionEvent ae){
			newCustomerGUI NCG;
			newPurchaseOrderGUI NPG;
			viewProductsGUI VP;
			viewOrdersGUI VO;
			
			String command = ae.getActionCommand();
				switch (command) {
					case "newCustomerOrder": // when user clicks the new Customer Order Button
						System.out.println("Opening window"); // system console prints 
						frameToDestroy.dispose(); // destroys the frame 
						NCG = new newCustomerGUI(); // creates new frame
					break;
					case "newPurchase":	//when user clicks new purchase button
						frameToDestroy.dispose();
						NPG = new newPurchaseOrderGUI();
					break;
					case "viewOrder": // when user clicks view order button
						frameToDestroy.dispose();
						VO = new viewOrdersGUI();
					break;
					case "viewProduct":  // when user clicks view product button
						frameToDestroy.dispose();
						VP = new viewProductsGUI();
					break;
					case "exit": 		// when user click on the exit button
						frameToDestroy.dispose(); //deletes frame
					break;
				}	
		}
}