import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		int bookNum; // to storing order number of book
		int rate; 	 // to storing rate
		int menu;	 // to storing the yes or no value
		Scanner scanner = new Scanner(System.in);
		Book firstBook = new Book(2343, "Harry Pottter", 0);
		Book secondBook = new Book(4434, "Deep Learning", 0);
		
		// to use while loop, we can make keep review the books or stop
		while(true) {
			System.out.println("===========================");
			System.out.println(firstBook); // print out information and order number by toString()
			System.out.println("=========");
			System.out.println(secondBook); // print out information and order number by toString()
			System.out.println("===========================");
			
			System.out.print("Please select book (order number): ");
			bookNum = scanner.nextInt();
			
			// if the bookNum is 1 go for firstBook else go for secondBook
			if(bookNum == 1) {
				System.out.println("You selected Book: " + firstBook.getBookTitle());
				System.out.print("Please enter your rate: ");
				rate = scanner.nextInt();
				// after we get the input rate, update averageRate and reviewCount
				firstBook.updateRate(rate);
				firstBook.updateReviewCount();
			}
			else {
				System.out.println("You selected Book: " + secondBook.getBookTitle());
				System.out.print("Please enter your rate: ");
				rate = scanner.nextInt();
				// after we get the input rate, update averageRate and reviewCount
				secondBook.updateRate(rate);
				secondBook.updateReviewCount();
			}
			
			System.out.print("Would you like to rate more (1: yes, 0: no): ");
			menu = scanner.nextInt();
			
			// if input is 0(no) break the loop, or continue
			if(menu == 0)
				break;
			else 
				continue;
				
		}
		

	}

}
