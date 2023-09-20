// It's superclass is Shape3D class
public class SquarePyramid extends Shape3D {
	
	private double edge; // for storing edge 
	private double height; // for storing height
	private Square square; // for underside square of squarePyramid
	
	// constructor that initializes edge and height instances
	// also initializes square instance
	public SquarePyramid(double edge,double height) {
		this.edge = edge;
		this.height = height;
		this.square = new Square(edge);
	}
	
	// Override the calculateVolume method in Shape3D class
	@Override
	public double calculateVolume() {
		return square.calculateArea() * height / 3; // calculate the volume of square pyramid
	}
	
	// set and get method for all instance variables
	public double getEdge() {
		return edge;
	}

	public void setEdge(double edge) {
		this.edge = edge;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}
}
