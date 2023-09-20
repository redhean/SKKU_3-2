
public class Cheese extends Food { // It's superclass is Food.
	
	// Constructor, we will set the type of cheese by using user input.
	public Cheese(int type) {
		super(type);
	}
	
	// We implement the calculateCost() method.
	// We set the cost of Cheese type by type.
	@Override
	public double calculateCost() {
		if(this.getType() == 1 || this.getType() == 3 || this.getType() == 0 )
			this.setCost(0.0);
		else
			this.setCost(100.0);
		
		return this.getCost(); // return cost by using getCost() method.
	}
	

}
