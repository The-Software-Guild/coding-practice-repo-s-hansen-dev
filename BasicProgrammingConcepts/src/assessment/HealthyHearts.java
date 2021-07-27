package assessment;

import java.util.Scanner;

public class HealthyHearts {
	
	/*
	 * Make a simple calculator that asks the user for their age. Then calculate the healthy heart rate range for that age, and display it.
	 * 		Their maximum heart rate should be 220 - their age.
	 * 		The target heart rate zone is the 50 - 85% of the maximum.
	 */
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("What is your age? ");
		
		if (in.hasNextInt()) {
			int age = in.nextInt();
			int heartRate = 220 - age;
			int zoneMin = (int) (heartRate * 0.5);
			int zoneMax = (int) Math.ceil(heartRate * 0.85);
			System.out.println("Your maximum heart rate should be " + heartRate + " beats per minute.");
			System.out.println("Your target HR Zone is " + zoneMin + " - " + zoneMax + " beats per minute.");
			
		} else {
			System.out.println("Try entering a valid age next time, dummy.");
		}
		
			
		
	}
}
