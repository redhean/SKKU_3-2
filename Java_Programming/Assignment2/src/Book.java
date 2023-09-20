
public class Book {
	private static int BOOK_COUNT = 0;  // to count the all number of books, It's static value
	private int bookNum = 0;	// the order number of books
	private int bookID;		// storing bookID;
	private String bookTitle; // storing bookTitle
	private int reviewCount;  // storing reviewCount
	private double averageRate; // storing averageRate
	
	public Book(int id, String title, int count) {
		this.bookID = id;
		this.bookTitle = title;
		this.reviewCount = count;
		this.averageRate = 5.0; // default is 5.0
		BOOK_COUNT++;		// when the new object generate, BOOK_COUNT increases 1
		this.bookNum = BOOK_COUNT;  // the new book's order is same as BOOK_COUNT
	}
	
	// We don't need to make setBookNum and setBOOK_COUNT
	public int getBookNum() {
		return bookNum;
	}
	
	public static int getBOOK_COUNT() {
		return BOOK_COUNT;
	}

	// These are the set and get method of instance variable
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public double getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(double averageRate) {
		this.averageRate = averageRate;
	}
	
	// updateRate() method get the new averageRate
	// if the input rate is bigger than 5, throw error message (the maximum is 5)
	public void updateRate(int rate) {
		if(rate <= 5) {
			if(this.reviewCount == 0)	// first rate will be the averageRate itself
				this.averageRate = rate;
			else {
				this.averageRate = (this.averageRate*this.reviewCount + rate) / (this.reviewCount + 1);
			}
		}else {
			throw new IllegalArgumentException("The Maximum rate is 5!");
		}
	}
	
	// after the review, reviewCount increase 1
	public void updateReviewCount() {
		this.reviewCount++;
	}
	
	// to print out information and order number of book
	public String toString() {
		return String.format("Book " + getBookNum() + ": " + getBookTitle() + "\n"
				+ "Book ID: " + getBookID() + "\n"
				+ "Book rate: %.2f" + "\n"
				+ "Number of reviews: " + getReviewCount(),getAverageRate());
	}

	

}
