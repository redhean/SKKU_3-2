import java.util.ArrayList; 
// We will use ArrayList to store the ingredients dynamically.
// Cause user can choose ingredients many times.

public class Burger extends Food { // It's superclass is Food.
	
	// Class Burger has Cheese and Ingredients(Composition).
	private Cheese cheeseObject;
	private Ingredient ingredients[]; // User can choose many ingredients So, declare as array type.
	
	// Constructor.
	public Burger(int type, int cheese, ArrayList<Integer>ingredients) {
		super(type);						// Using super.
		this.setCheeseObject(cheese);		// Using setCheeseObject() method.
		this.setIngredients(ingredients);	// Using setIngredients() method.
	}
	
	// getter and setter method.
	public Cheese getCheeseObject() {
		return cheeseObject;
	}
	
	public void setCheeseObject(int cheese) {
		// Argument cheese is the type of Cheese that user chose.
		this.cheeseObject = new Cheese(cheese); 
	}
	
	public Ingredient[] getIngredients() {
		return ingredients;
	}
	
	// We use ArrayList of ingredients as argument.
	// Assign the value to this.ingredients by using for loop.
	public void setIngredients(ArrayList<Integer>ingredients) {
		this.ingredients = new Ingredient[ingredients.size()];
		for(int i = 0; i < ingredients.size(); i++) {
			this.ingredients[i] = new Ingredient(ingredients.get(i));
		}
	}
	
	
	// We implement the calculateCost() method.
	// We set the cost of Burger type by type.
	// Also sum up the cost of Cheese and Ingredients.
	@Override
	public double calculateCost() {
		double sum = 0.0; // for storing the final cost of burger.
		
		// Add the cost of burger type by type.
		if(this.getType() == 1)
			sum += 4000.0;
		else if(this.getType() == 4)
			sum += 5500.0;
		else if(this.getType() == 2 || this.getType() == 3)
			sum += 5000.0;
		else
			sum += 0.0;
		
		// Add the cost of Cheese by using cheeseObject.calculateCost() method.
		sum += this.cheeseObject.calculateCost();
		
		// Add the cost of Ingredients by using  ingredients[].calculateCost() method.
		// Using for loop.
		for(int i = 0; i < this.ingredients.length; i++) {
			sum += this.ingredients[i].calculateCost();
		}
		
		this.setCost(sum);	// set the cost by using setCost() method.
		return this.getCost(); //  return using getCost() method.
	}
	
	

}
