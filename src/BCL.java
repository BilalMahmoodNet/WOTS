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
					case "newCustomerOrder":
						System.out.println("Opening window");
						frameToDestroy.dispose();
						NCG = new newCustomerGUI();
					break;
					case "newPurchase": 
						frameToDestroy.dispose();
						NPG = new newPurchaseOrderGUI();
					break;
					case "viewOrder": 
						frameToDestroy.dispose();
						VO = new viewOrdersGUI();
					break;
					case "viewProduct": 
						frameToDestroy.dispose();
						VP = new viewProductsGUI();
					break;
					case "exit": 
						frameToDestroy.dispose();
					break;
				}	
		}
}