
public class Beverage extends Food { // It's superclass is Food.
	private boolean ice; // Instance ice is boolean type (yes or no).
	
	// Constructor.
	public Beverage(boolean ice, int type) {
		super(type);
		this.setIce(ice);
	}

	// getter and setter method.
	public boolean isIce() {
		return ice;
	}

	public void setIce(boolean ice) {
		this.ice = ice;
	}

	// We implement the calculateCost() method.
	// We set the cost of Beverage type by type.
	@Override
	public double calculateCost() {
		if(this.getType() == 1)
			this.setCost(1000.0);
		else if(this.getType() == 2)
			this.setCost(1100.0);
		else if(this.getType() == 3)
			this.setCost(900.0);
		else if(this.getType() == 4)
			this.setCost(1200.0);
		else if(this.getType() == 5)
			this.setCost(2000.0);
		else 
			this.setCost(0.0);
		
		return this.getCost(); // return by using getCost();
	}
	
}
