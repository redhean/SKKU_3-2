// Station class for Bus and Train class
public class Station {
	private double farePerStation;		// both bus and train has the stations
	private int nStations;				// the total fare will change by the number of stations
	
	// constructor
	public Station(double farePerStation, int nStations) {
		this.setFarePerStation(farePerStation);
		this.setnStations(nStations);
	}
	
	// set and get method
	public double getFarePerStation() {
		return farePerStation;
	}

	public void setFarePerStation(double farePerStation) {
		this.farePerStation = farePerStation;
	}

	public int getnStations() {
		return nStations;
	}

	public void setnStations(int nStations) {
		this.nStations = nStations;
	}
}	
