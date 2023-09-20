import java.util.Scanner; // for take the data from users
import java.util.Random;  // for take the computer choices

public class Main2 {
	
	//function that change the integer choice to String choice
	// 1 is Scissors, 2 is Rock, 3 is Paper
	public static String transformer(int choice) {
		if(choice == 1)
			return "Scissors";
		else if(choice == 2)
			return "Rock";
		else return "Paper";
		
	}
	
	//function that decide who is the winner 
	//return type is String
	public static String result(int you, int computer) {
		if((you == 1 && computer == 3) || (you == 3 && computer == 1)) { // only these case smaller one is winner
			if(you < computer) 
				return "you";
			else
				return "computer";	
		}else { // other cases are winner who has bigger value
			if(you > computer)
				return "you";
			else if(you < computer)
				return "computer";
			else return "draw"; // if the values are same then draw
		}	
	}
	
	public static void main(String[] args) {
		int youChoice; // your choice about Kai-Bai-Bo
		int computerChoice; // computer choice about Kai-Bai-Bo
		int youWin = 0; // count the number of your win point
		int computerWin = 0; // count the number of computer's win point
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Let's play Kai-Bai-Bo (scissors, rock, paper)");
		
		//loop for 3 games
		for(int i = 0; i < 3; i++) {
			System.out.println("Round " + (i + 1));
			System.out.println("Kai-Bai-Bo!");
			System.out.println("1. Kai (scissors)");
			System.out.println("2. Bai (rock)");
			System.out.println("3. Bo (paper)");
			
			// use random class for generating computer choices randomly
			Random randomGenerator = new Random();
			computerChoice = randomGenerator.nextInt(3) + 1; // to make only 1,2,3
			
			System.out.print("Your choice: ");
			youChoice = sc.nextInt();
			System.out.println("You: " + transformer(youChoice));
			System.out.println("Computer: " + transformer(computerChoice));
			System.out.println("Winner: " + result(youChoice, computerChoice));
			System.out.println("===========================");
			
			if(result(youChoice, computerChoice) == "you")
				youWin++;
			else if(result(youChoice, computerChoice) == "computer")
				computerWin++;
			else continue; // draw then just continue	
		}
		sc.close();
		
	
		System.out.println("You " + youWin + " : " + computerWin + " Computer");
		if(youWin > computerWin)
			System.out.println("Final Winner: You!");
		else if(youWin < computerWin)
			System.out.println("Final Winner: Computer!");
		else
			System.out.println("Draw!");

	}

}
