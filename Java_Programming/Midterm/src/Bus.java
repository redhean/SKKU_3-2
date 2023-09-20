// It's super class is PublicTransport class
public class Bus extends PublicTransport {
	private Station station;	// Composition, bus has stations
	
	// constructor
	public Bus(String model, double baseFare, double farePerStation, int nStations) {
		super(model, baseFare);
		this.setStation(farePerStation, nStations);
		calculatePayment();		// when object generates, calculate the total fare
	}

	// set and get method
	public Station getStation() {
		return station;
	}

	public void setStation(double farePerStation, int nStations) {
		this.station = new Station(farePerStation, nStations);
	}
	
	// It implement calculatePayment() method
	/*
	 * If the number of stations is less than 5 : total fare = (base fare)
	 * If the number of stations is more than 5 : total fare = (base fare) + ((number of station) - 5) * (fare per station)
	 */
	@Override
	public void calculatePayment() {
		double totalFare;
		if(this.station.getnStations() < 5) {
			totalFare = this.getBaseFare();
		}
		else {
			totalFare = this.getBaseFare() + (this.station.getnStations() - 5) * this.station.getFarePerStation();
		}
		
		this.setTotalFare(totalFare);
	}
	

}
