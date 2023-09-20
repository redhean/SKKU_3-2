// It's superclass is Shape3D class
public class Cylinder extends Shape3D {

	private double radius; // for storing radius
	private double height; // for storing height
	private Circle circle; // for underside circle of cylinder
	
	// constructor that initializes the radius and height instances
	// also initializes circle instance
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
		this.circle = new Circle(radius);
	}
	
	// Override the calculateVolume method in Shape3D class
	@Override
	public double calculateVolume() {
		return circle.calculateArea() * height; // calculate the volume of Cylinder
	}

	// set and get method for all instance variables
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
}
