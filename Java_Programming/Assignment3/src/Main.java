import java.util.Scanner;  // for take user input.
import java.util.ArrayList; // for storing ingredients dynamically.

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int burgerType;		// for storing user's burger type.
		int cheeseType;		// for storing user's cheese type.
		int ingredientsType; // for storing user's ingredients type.
		ArrayList<Integer> ingredients = new ArrayList<Integer>(); // for storing all ingredients that user chose.
		int beverageType;	// for storing user's beverage type.
		int iceType;		// for storing user's ice type.
		int extraType;		// for storing user's extra type.
		
		// Polymorphism.
		// We declare burger, beverage, extra as Food type(Up casting).
		Food burger;
		Food beverage;
		Food extra;
		
		// Menu for burger(sandwiches).
		System.out.println("==============================");
		System.out.println("Welcome to SKKU-SUBWAY!");
		System.out.println("Choose burgers (sandwiches):");
		System.out.println("1. Egg Mayo - 4,000 won");
		System.out.println("2. Chicken Tikka - 5,000 won");
		System.out.println("3. Chicken Ham - 5,000 won");
		System.out.println("4. Roasted Chicken - 5,500 won");
		System.out.println("0. Cancel Order");
		System.out.print("Select Burger (1-5):");
		burgerType = scanner.nextInt();  // Storing user input.
		
		// If user choose "Cancel Order" then print out message and exit the program.
		if(burgerType == 0) {
			System.out.println("\nThe order is canceled.");
			System.exit(0);
		}
			
		// Menu for cheese.
		System.out.println("==============================");
		System.out.println("Select Cheese Type:");
		System.out.println("1. American Cheese - (+0 won)");
		System.out.println("2. Swiss - (+100 won)");
		System.out.println("3. Cheddar - (+0 won)");
		System.out.print("Select Cheese (1-3):");
		cheeseType = scanner.nextInt();	 // Storing user input.
		
		// We use do-while loop for taking ingredients input.
		do {
			// Menu for ingredients.
			System.out.println("==============================");
			System.out.println("Select Ingredients:");
			System.out.println("1. Lettuce - (+0 won)");
			System.out.println("2. Tomatoes - (+0 won)");
			System.out.println("3. Cucumbers - (+50 won)");
			System.out.println("4. Olives - (+50 won)");
			System.out.println("0. Skip");
			System.out.print("Select Ingredients (1-4):");
			ingredientsType = scanner.nextInt(); // Storing user input.
			
			// If user choose ingredient, then store in ArrayList ingredients.
			if(ingredientsType != 0) {
				ingredients.add(ingredientsType);
			}
			
		}while(ingredientsType != 0); // Stop the loop when the user choose "Skip".
		
		// Polymorphism, Upcasting.
		burger = new Burger(burgerType, cheeseType, ingredients);
		
		// Menu for beverage.
		System.out.println("==============================");
		System.out.println("Select Beverages:");
		System.out.println("1. Cola - 1,000 won");
		System.out.println("2. Fanta - 1,100 won");
		System.out.println("3. Chilsung Cider - 900 won");
		System.out.println("4. Zero Cola - 1,200 won");
		System.out.println("5. Coffee - 2,000 won");
		System.out.println("0. Skip");
		System.out.print("Select Beverage (1-5):");
		beverageType = scanner.nextInt();	// Storing user input. 
		
		// Asking about ice.
		System.out.println("==============================");
		System.out.print("With ice? (0 [no] or 1[yes]):");
		iceType = scanner.nextInt();	// Storing user input.
		
		
		// Polymorphism, Upcasting.
		// We declare the beverage according to the value of iceType.
		if(iceType == 1)
			beverage = new Beverage(true, beverageType);
		else
			beverage = new Beverage(false, beverageType);
		
		// Menu for extra.
		System.out.println("==============================");
		System.out.println("Select Extra:");
		System.out.println("1. Cookies - 1,500 won");
		System.out.println("2. French Fries - 1,300 won)");
		System.out.println("3. Chips - 1,700 won");
		System.out.println("0. Skip");
		System.out.print("Select Extra (1-3):");
		extraType = scanner.nextInt();	// Storing user input.
		
		// Polymorphism, Upcasting.
		extra = new Extra(extraType);
		
		// Print out the result.
		// We will also check about whether user chose beverage, extra and check about the ice.
		System.out.println("==============================");
		System.out.println("| Burger (with cheese and ingredients): " + burger.calculateCost());
		
		if(beverageType != 0)
			if(iceType == 1)
				System.out.println("| Beverage (with ice): " + beverage.calculateCost());
			else
				System.out.println("| Beverage (without ice): " + beverage.calculateCost());
		
		if(extraType != 0)
			System.out.println("| Extra: " + extra.calculateCost());
		
		// Total cost is sum of burger, beverage and extra.
		double total = burger.calculateCost() + beverage.calculateCost() + extra.calculateCost();
		System.out.println("| TOTAL: " + total);
		
		scanner.close(); // Close the scanner
	}

}
