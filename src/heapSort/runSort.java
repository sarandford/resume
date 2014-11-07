package heapSort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * the RunSort class contains a main which generates random integers and an instance of the Sort class to call a heapSort on those random integers
 * @author sarahford
 * @since October 25, 2014
 * @status working properly
 */
public class runSort {
	/**
	 * 
	the main method uses user input to create a user specified length of randomm integers to pass into a heapSort method called by the Sort class
	@param String [] args an empty array of type String
	@return void
	*
	 */
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the sze of the list to generate: ");
		int size = input.nextInt();//put into arraylist
		ArrayList<Integer> toHeap = new ArrayList<Integer>();
		Random randomizer = new Random();
		for (int i=1;i<=size;i++){
			toHeap.add(randomizer.nextInt(100000000));//arbitraily chose large ranges
		}
		System.out.println("Unsorted list: "+toHeap.toString());
		Sort sorter = new Sort();
		long now = System.nanoTime();
		ArrayList<Integer> sorted = sorter.heapSort(toHeap);
		long later = System.nanoTime();
		System.out.println("Sorted List: "+sorted.toString());
		System.out.println("Time take to sort: "+(((later-now)/1000000))+" miliseconds");
	}
}
