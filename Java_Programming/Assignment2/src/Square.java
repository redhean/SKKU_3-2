// It's superclass is Shape2D class
public class Square extends Shape2D {
	
	private double edge; // for storing edge 
	
	// constructor that initializes edge instance
	public Square(double edge) {
		this.edge = edge;
	}
	
	// Override the calculateArea() Method in Shape2D class
	@Override
	public double calculateArea() {
		return Math.pow(edge, 2); // calculate the area of square
	}

	// set and get method for all instance variables
	public double getEdge() {
		return edge;
	}

	public void setEdge(double edge) {
		this.edge = edge;
	}

}
