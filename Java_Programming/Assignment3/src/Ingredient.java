
public class Ingredient extends Food { // It's superclass is Food.
	
	// Constructor, we will set the type of ingredients by using user input.
	public Ingredient(int type) {
		super(type);
	}
	
	// We implement the calculateCost() method.
	// We set the cost of Ingredients type by type.
	@Override
	public double calculateCost() {
		if(this.getType() == 1 || this.getType() == 2)
			this.setCost(0.0);
		else
			this.setCost(50.0);
		
		return this.getCost(); // return cost by using getCost() method.
	}
	
	
}
