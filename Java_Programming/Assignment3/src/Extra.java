
public class Extra extends Food { // It's superclass is Food.
	
	// Constructor.
	public Extra(int type) {
		super(type);
	}

	// We implement the calculateCost() method.
	// We set the cost of Extra type by type.
	@Override
	public double calculateCost() {
		if(this.getType() == 1)
			this.setCost(1500.0);
		else if(this.getType() == 2)
			this.setCost(1300.0);
		else if(this.getType() == 3)
			this.setCost(1700.0);
		else
			this.setCost(0.0);
		
		return this.getCost(); // return by using getCost() method.
					
	}

}
