package assessment;

import java.util.Scanner;

public class DogGenetics {

	public static final String[] BREEDS = {"Lab", "Chihuahua", "Demon", "Akita", "Husky"};
	
	public static void main(String[] args) {
		
		// receive name from input
		Scanner in = new Scanner(System.in);
		System.out.print("What is your dog's name? ");
		
		String name = "yer dawg";
		if (in.hasNext()) {
			name = in.next();
		}
		
		System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.\n");

		System.out.println(name + " is: \n");
		getGenes();
		System.out.println("\nWow, that's QUITE the dog!");
	}
	
	public static void getGenes() {
		int remainingPercent = 99;
		
		for (int i = 0; i < 5; i++) {
			int percent = (int)(Math.random() * remainingPercent) + 1;
			System.out.println(percent + "% " + BREEDS[i]); 
			remainingPercent -= percent;
		}
	}
	

}
