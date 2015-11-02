
public class customerorder {
	private int customerOrderID;
	private String customerName;
	private  String employeeWorking;
	private String checkedOut;
	
	
	public int getCustomerOrderID() {
		return customerOrderID;
	}
	public void setCustomerOrderID(int customerID) {
		this.customerOrderID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmployeeWorking() {
		return employeeWorking;
	}
	public void setEmployeeWorking(String employeeWorking) {
		this.employeeWorking = employeeWorking;
	}
	public String getCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(String checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	
}
