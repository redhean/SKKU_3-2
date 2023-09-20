// It's superclass is Shape3D class
public class Cone extends Shape3D {
	
	private double radius; // for storing radius
	private double height; // for storing height
	private Circle circle; // for underside circle of Cone
	
	// constructor that initializes the radius and height instances
	// also initializes circle instance
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
		this.circle = new Circle(radius);
	}
	
	// Override the calculateVolume method in Shape3D class
	@Override
	public double calculateVolume() {
		return circle.calculateArea() * height / 3; // calculate the volume of Cone
	}

	// get and set method for all instance variables
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
