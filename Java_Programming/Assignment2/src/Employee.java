
public class Employee {
	private String name;	
	private double salary;  
	private double tax;
	private double insurance;
	
	public Employee(String name, double salary){
		this.name = name;
		this.salary = salary;
		this.tax = salary * 0.088;  // Initialize the tax in the constructor by salary * 0.088(8.8%)
		this.insurance = salary * 0.065; // Initialize the insurance in the constructor by salary * 0.065(6.5%)
	}

	// These are the set and get methods for instance variables
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	
	// In this increaseSalary method, we update three variables
	public void increaseSalary(double salaryIncreasePercentage) {
		this.salary = this.salary * (1 + salaryIncreasePercentage / 100);	// update salary
		this.tax = salary * 0.088;	// update tax
		this.insurance = salary * 0.065;	// update insurance
	}
	
	public void getInformation() {
		System.out.println("=================================");
		System.out.println("Employ Info");
		// To make print out one digit in under zero
		String info = String.format("Name: " + getName() + "\n"
				+ "Salary: %.1f" + "\n"
				+ "Tax: %.1f" + "\n"
				+ "Insurance: %.1f",getSalary(),getTax(),getInsurance());
		System.out.println(info);
	}
}
