
public abstract class Food implements Payment { // class Food implements interface Payment
	private int type;  // We will set the type instance as Integer (Use user input itself)
	private double cost; // It store the cost of Food. We will set the cost in calculateCost() method.
	
	// Construct.
	public Food(int type) {
		setType(type);
	}
	
	// Getter and Setter method
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * We do not implement Payment method calculateCost() here.
	 * So this class must be declared abstract.
	 */
	
}
