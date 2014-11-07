package heapSort;

import java.util.ArrayList;
/**
 * the sort class contains a heapSort method to sort an arraylist of integers by creating a heap and storing and removing the smallest value from it
 * @author Sarah Ford
 * @since October 25, 2014
 */
public class Sort {
	/**
	 * 
	 the heap sort method in accpea an arrayList of integerrs, and by creating
	 * an Instace of a Heap, uses removeMin to create and retrun an ordered
	 * array
	 * 
	 * @param items an ArrayList of unsorted integers
	 * @return minList an ArrayList of sorted integers
	 * 
	 */
	ArrayList<Integer> heapSort(ArrayList<Integer> items) {
		Heap heap = new Heap(items);
		ArrayList<Integer> minList = new ArrayList<Integer>(); 
		while (!(heap.isEmpty())) {
			minList.add((Integer) heap.removeMin());
		}
		return minList;
	}
	quickSort(int [] intArray, int startIndex, int endIndex())
}
