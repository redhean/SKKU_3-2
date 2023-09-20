import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		double salaryIncreasePercentage = 0; // variable for storing increasing percentage
		Scanner scanner = new Scanner(System.in); // scanner for getting input data
		
		Employee firstEmployee = new Employee("John",600000); // first employee object
		Employee secondEmployee = new Employee("Mark",900000); // second employee object
		
		// getInformation() method is for getting information about employee
		// name, salary, tax amount and insurance amount
		firstEmployee.getInformation();
		secondEmployee.getInformation();
		
		System.out.println("=========================");
		System.out.print("Increase salary (in percentage): ");
		salaryIncreasePercentage = scanner.nextDouble(); // getting input for percentage of increasing salary
		
		// increaseSalary() method increases the salary by the given percentage
		// also update tax and insurance amount
		firstEmployee.increaseSalary(salaryIncreasePercentage);
		secondEmployee.increaseSalary(salaryIncreasePercentage);
		
		System.out.println("After Salary Increase");
		// print out after salary increase
		firstEmployee.getInformation();
		secondEmployee.getInformation();
		
	}

}
