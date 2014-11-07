package searchAlgorithms;

import java.util.Date;
import java.util.Scanner;

/**
 * The searchTest class contains a main method which tests different
 * implementations of search methods from the Search class
 * 
 * @author Sarah Ford
 * @since September 23, 2014
 * @status working properly
 */
public class searchTest {
	/**
	 * 
	 the main method creates an array on which the static Search methods can
	 * be tested
	 * 
	 * @param agrs
	 *            an empty String array
	 * @return void
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] testArray = new int[1000000];
		for (int i = 0; i < 100000; i++) {
			testArray[i] = i + 1;
		}
		System.out.println("Pick a number between 1 and 100,000: ");
		int x = in.nextInt();
		if (x > 100000 || x < 1) {
			System.out.println("invalid number, please pick a different one");
			return;
		}
		Search.binaryRecursion(testArray, x, testArray.length - 1, 0);
		long startTime = new Date().getTime();
		System.out.println(startTime);
		System.out.println(System.nanoTime());
		
		Search.linearIterative(testArray, x);
		System.out.println("Found it in " + (new Date().getTime() - startTime)
				/ 1000 + "  seconds using iterative linerar search");
		Search.binaryIterative(testArray, x);
		System.out.println("Found it in " + (new Date().getTime() - startTime)
				/ 1000 + " seconds using binary iterative search");
		startTime = new Date().getTime();
		Search.binaryRecursion(testArray, x, testArray.length - 1, 0);
		System.out.println("Foud it in " + (new Date().getTime() - startTime)
				/ 1000 + " seconds using binary recursive search");
		startTime = new Date().getTime();
		Search.linearRecursion(testArray, x, 0);
		System.out.println("Found it in " + (new Date().getTime() - startTime)
				/ 1000 + " seconds using linear recursive search");

	}

}
