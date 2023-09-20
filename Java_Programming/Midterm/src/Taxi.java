// It's super class is PublicTransport class
public class Taxi extends PublicTransport {
	private double farePerKm; 	// taxi fare will change by the distance 
	private double distance;
	
	// constructor
	public Taxi(String model, double baseFare, double farePerKm, double distance) {
		super(model, baseFare);
		this.setFarePerKm(farePerKm);
		this.setDistance(distance);
		calculatePayment();		// when object generates, calculate the total fare 
	}
	
	// set and get method
	public double getFarePerKm() {
		return farePerKm;
	}
	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	// It implement calculatePayment() method
	@Override
	public void calculatePayment() {
		double totalFare;
		totalFare = this.getBaseFare() + this.getDistance() * this.getFarePerKm();	// total fare = (base fare) + distance * (fare per km)
		this.setTotalFare(totalFare);	// set the total fare
	}
	
}
