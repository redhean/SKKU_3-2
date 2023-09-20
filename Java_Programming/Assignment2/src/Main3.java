import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // for storing input data
		int menu;	// for storing the case of shape
		double inputNumber1; // for storing first input
		double inputNumber2; // for storing second input
		double volume; // for storing calculated volume
		
		System.out.println("=== Welcome to TEACH MATH ===");
		System.out.println("1. Calculate volume of Square Pyrimid.");
		System.out.println("2. Calculate volume of Cone");
		System.out.println("3. Calculate volume of Cylinder.");
		
		System.out.print("Enter your choice: ");
		menu = scanner.nextInt(); // get input data
		
		// 1 for square pyramid, 2 for cone and 3 for cylinder
		if(menu == 1) {
			System.out.print("Enter edge of Square Pyramid: ");
			inputNumber1 = scanner.nextDouble(); // get first input number(edge)
			System.out.print("Enter height of Square Pyramid: ");
			inputNumber2 = scanner.nextDouble(); // get second input number(height)
			SquarePyramid squarepyramid = new SquarePyramid(inputNumber1,inputNumber2); // square pyramid object
			volume = squarepyramid.calculateVolume(); // calculate the volume by calculateVolume() method
			String str = String.format("Volume of Square Pyramid: %.2f",volume);
			System.out.println(str);
		}
		else if(menu == 2) {
			System.out.print("Enter radius of Cone: ");
			inputNumber1 = scanner.nextDouble(); // get first input number(radius)
			System.out.print("Enter height of Cone: ");
			inputNumber2 = scanner.nextDouble(); // get second input number(height)
			Cone cone = new Cone(inputNumber1,inputNumber2); // cone object 
			volume = cone.calculateVolume(); // calculate the volume by calculateVolume() method
			String str = String.format("Volume of Cone: %.2f",volume);
			System.out.println(str);
		}
		else {
			System.out.print("Enter radius of Cylinder: ");
			inputNumber1 = scanner.nextDouble(); // get first input number(radius)
			System.out.print("Enter height of Cylinder: ");
			inputNumber2 = scanner.nextDouble(); // get second input number(height)
			Cylinder cylinder = new Cylinder(inputNumber1,inputNumber2); // cylinder object
			volume = cylinder.calculateVolume(); // calculate the volume by calculateVolume() method
			String str = String.format("Volume of Cylinder: %.2f",volume);
			System.out.println(str);
		}
		

	}

}
