package assessment;

import java.util.Scanner;

public class RockPaperScissors {
	
	/*
	 * The program first asks the user how many rounds he/she wants to play.
	 * 		Maximum number of rounds = 10, minimum number of rounds = 1.  If the user asks for something outside this range, the program prints an error message and quits.
	 * 		If the number of rounds is in range, the program plays that number of rounds.  Each round is played according to the requirements below.
	 * For each round of Rock, Paper, Scissors, the program does the following:
	 * 		The computer asks the user for his/her choice (Rock, Paper, or Scissors).
	 * 			Hint: 1 = Rock, 2 = Paper, 3 = Scissors
	 * 		After the computer asks for the user’s input, the computer randomly chooses Rock, Paper, or Scissors and displays the result of the round (tie, user win, or computer win).
	 * 			Hint: use the Random class.
	 * The program must keep track of how many rounds are ties, user wins, or computer wins.
	 * 		Hint: Create three variables to keep track of these items and update them correctly after each round.
	 * The program must print out the number of ties, user wins, and computer wins and declare the overall winner based on who won more rounds.
	 * After all rounds have been played and the winner declared, the program must ask the user if he/she wants to play again.
	 * 		If the user says No, the program prints out a message saying, “Thanks for playing!” and then exits.
	 * 		If the user says Yes, the program starts over, asking the user how many rounds he/she would like to play.

	 */
	public static final String[] OPTIONS = {"", "ROCK", "PAPER", "SCISSORS"};
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean playAgain = true;
		
		// flow of play loop
		while (playAgain) {
			System.out.println("Welcome to rock paper scissors!");
			
			// ask for rounds
			System.out.print("How many rounds would you like to play? (1-10) ");
			if (!in.hasNextInt()) {
				System.out.println("That was not a valid entry, please try again.");
				break;
			}

			int rounds = in.nextInt();
			
			// check validity
			if (rounds < 1 || rounds > 10) {
				System.out.println("That was not a valid entry, please try again.");
				break;
			}
			
			// the actual game starts here!
			int wins = 0;
			int losses = 0;
			int draws = 0;
			int currentRound = 1;
			
			while (currentRound <= rounds) {
				System.out.println("Round " + currentRound + ", start!");
				System.out.print("Rock, paper, or scissors? (R = 1, P = 2, S = 3) ");
				int choice = 0;
				if (in.hasNextInt()) {
					choice = in.nextInt();
				} 
				
				// check validity of entry
				if (choice < 1 || choice > 3) {
					System.out.println("That was not a valid entry. You have lost all remaining rounds.");
					losses+= (rounds - currentRound) + 1;
					break;
				}
				
				// if valid, proceed normally. 
				// computer randomly picks 
				int comp = (int)(Math.random() * (3-0)) + 1;
				
				// logic dealing with player and computer choices 
				// draw
				if (choice == comp) {
					draws++;
					System.out.println(OPTIONS[choice] + " vs. " + OPTIONS[comp]+"! It's a tie!");				
				} else if (comp == 1 && choice == 3) {
					// scissors vs rock case, where comp picks rock 
					losses++;
					System.out.println(OPTIONS[choice] + " vs. " + OPTIONS[comp]+"! Computer wins this round!");
				} else if (choice == 1 && comp == 3){
					// scissors vs rock case, where player picks rock 
					wins++;
					System.out.println(OPTIONS[choice] + " vs. " + OPTIONS[comp]+"! Player wins this round!");
				} else if (comp < choice) { 
					// unless scissor vs. rock, loser will have lower number
					wins++;
					System.out.println(OPTIONS[choice] + " vs. " + OPTIONS[comp]+"! Player wins this round!");
				} else { 
					// in all other cases, it's a computer victory
					losses++;
					System.out.println(OPTIONS[choice] + " vs. " + OPTIONS[comp]+"! Computer wins this round!");
				}
				currentRound++;
			}
			// after last round is finished, see who won 
			System.out.println("Wins: "+ wins +" Losses: "+ losses + " Draws: " + draws);
			if (losses == wins) {
				System.out.println("It's a tie!");
			} else if (wins > losses) {
				System.out.println("Player wins!");
			} else {
				System.out.println("Computer wins!");
			}
			
		
			// check if player wants to go another round
			System.out.print("Would you like to play again? (yes/no) ");
			if (in.hasNext()) {
				String answer = in.next().toLowerCase();
				if (answer.equals("no")) {
					System.out.println("Thanks for playing!");
					playAgain = false;
				}
				else if (answer.equals("yes")){
					continue;
				} else {
					System.out.println("Uh... ok... bye!");
					playAgain = false;
				}
			}
		}
		
	}
}