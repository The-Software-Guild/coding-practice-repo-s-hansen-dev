package assessment;

import java.util.Scanner;

public class DogGenetics {

	public static final String[] BREEDS = {"Lab", "Mutt", "Goose", "Pug", "Straight Up Wolf", "Chihuahua", "Demon", "Akita", "Husky", "Adorable"};
	
	public static void main(String[] args) {
		
		// receive name from input
		Scanner in = new Scanner(System.in);
		System.out.print("What is your dog's name? ");
		
		String name = "yer dawg";
		if (in.hasNext()) {
			name = in.next();
		}
		
		System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");
		
	}
	
	public static void getGenes() {
		
	}
	

}
