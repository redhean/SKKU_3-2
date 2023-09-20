// It's superclass is Shape2D class
public class Circle extends Shape2D {
	
	private double radius; // for storing radius 
	
	// constructor that initializes radius instance
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// Override the calculateArea() Method in Shape2D class
	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2); // calculate the area of circle
	}

	// set and get method for all instance variables
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
}
