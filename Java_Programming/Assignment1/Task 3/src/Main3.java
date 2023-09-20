import java.util.Scanner; // for take the data from users

public class Main3 {

	public static void main(String[] args) {
		int firstNumber; // base number
		int secondNumber; // possible power of the first number
		int countPower = 0; // for get the power
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		firstNumber = sc.nextInt();
		System.out.print("Enter your guessed power of above number: ");
		secondNumber = sc.nextInt();
		sc.close();
		System.out.println("===========================================");
		
		
		if(firstNumber > secondNumber) { // if the base number is bigger than the second number, raise error message
			System.out.println("Error: We only cover possible power >= 1. Please retry the program.");
		}else if(firstNumber <= 0 || secondNumber <= 0) { // if the base number and the second number is negative, raise error message
			System.out.println("Error: We only cover positive numbers. Please retry the program.");
		}
		else {
			while(secondNumber > 1) {
				if(secondNumber % firstNumber == 0)
					secondNumber = secondNumber / firstNumber;
				else break; // if second number didn't divided by first number, ouput will always be false. So terminate the loop
				
				countPower++;
			}
			
			if(secondNumber == 1) { // only the case that the secondNumber is 1, it is true
				System.out.println("power = " + countPower);
				System.out.println("Output: true");
			}else {
				System.out.println("Output: false");
			}
		}
		
		
		
	}

}
