// Not implement calculatePayment() method so it should be abstract class
public abstract class PublicTransport implements Payable {
	private String model;		// storing model of the public transportation (train, bus, taxi)
	private double baseFare;	// storing base fare
	private double totalFare;	// storing total fare 
	
	// constructor
	public PublicTransport(String model, double baseFare) {
		this.setModel(model);
		this.setBaseFare(baseFare);
	}
	
	// set and get method
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	
	

}
