package assessment;

public class SummativeSums {
	
	/*
	 * Write a static method that takes in an array of ints, adds them together, and returns the result.
	 * Call your new method inside a main method and print out the result for the following three example arrays (see main).
	 */

	public static void main(String[] args) {
		int[] test1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
		int[] test2 = {999, -60, -77, 14, 160, 301};
		int[] test3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};
		
		System.out.println(addArray(test1));
		System.out.println(addArray(test2));
		System.out.println(addArray(test3));
	}
	
	/**
	 * Sums the contents of an input int array.
	 * @param nums: an array of ints
	 * @return the sum of the integers in nums
	 */
	public static int addArray(int[] nums) {
		int sum = 0;
		
		for (int i: nums) {
			sum += i;
		}
		
		return sum;
	}
}
