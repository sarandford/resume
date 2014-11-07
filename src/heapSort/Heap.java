package heapSort;

import java.util.ArrayList;
/**
 * The Heap class creates a Heap adt and its assoiciated methods using a generic ArrayList
 * @author sarahford
 * @param <E> a generic type of the arrayList
 */
public class Heap<E> {
	private ArrayList<E> heap = new ArrayList<E>();

	public Heap(ArrayList<E> items) {
		for (int i = 0; i < items.size(); i++) {
			insert(items.get(i));
		}

	}

	/**
	 * 
	 the getEntry method returns the entry contained at the position in the
	 * tree
	 * 
	 * @param i
	 *            an int representing the position
	 * @return E a generic element contained in the postion
	 * 
	 */
	E getEntry(int i) {
		return heap.get(i);
	}

	/**
	 * 
	 The size method returns number of the elemnets in the heap including the
	 * null in the first postiion
	 * 
	 * @param void
	 * @return int representing the number of elements in heap
	 * 
	 */
	int size() {
		return heap.size();
	}

	/**
	 * 
	 the left method accepts a position and returns its left child
	 * 
	 * @param i
	 *            an int representing the parent position
	 * @return E a generic element
	 * 
	 */
	E left(int i) {
		return heap.get(2 * i);
	}

	/**
	 * 
	 The right method accepts a position and returns its right child
	 * 
	 * @param int i a position
	 * @return E an element
	 * 
	 */
	E right(int i) {
		return heap.get(2 * i + 1);
	}

	/**
	 * the parent method accepts an integer parameter position and returns the
	 * element of its parent
	 * 
	 * @param int i an integer parameter representing the position
	 * @return E a generic element that its parent
	 */
	E parent(int i) {
		return heap.get((int) Math.floor(i / 2));
	}

	/**
	 * 
	 the setEntry method accepts a position and a value and chages the value
	 * of the ArrayList at that position
	 * 
	 * @param j
	 *            an int of the position to be changed, E element the value to
	 *            which it will be changed
	 * @return void
	 * 
	 */
	void setEntry(int j, E element) {
		heap.set(j, element);

	}

	/**
	 * 
	 hasRight returns true if the position has a right child
	 * 
	 * @param int j an integer representing the position
	 * @return a boolean, true if the right child is not null false otherwise
	 * 
	 */
	boolean hasRight(int j) {
		try {
			if (right(j) != null)
				return true;
			else
				return false;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	/**
	 * 
	 hasLeft returns true if the position has a left child
	 * 
	 * @param int j an integer representing the position
	 * @return a boolean, true if the left child is not null false otherwise
	 * 
	 */
	boolean hasLeft(int j) {
		try {
			if (left(j) != null)
				return true;
			else
				return false;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	/**
	 * 
	 hasParent returns true if the position has a parnet child
	 * 
	 * @param int j an integer representing the position
	 * @return a boolean, true if the parent is not null false otherwise
	 * 
	 */
	boolean hasParent(int j) {
		if (parent(j) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 The swap methood accepts two posistions of the array and swaps their
	 * values in the array
	 * 
	 * @param oldFirst
	 *            int, newFirst int two different positons in the array
	 * @return void
	 * 
	 */
	void swap(int oldFirst, int newFirst) {
		E temp = heap.get(oldFirst);
		setEntry(oldFirst, heap.get(newFirst));
		setEntry(newFirst, temp);
	}

	/**
	 * 
	 the insert method accpets a generic value and inserts it into the
	 * ArrayList and then sorts it nto the correct position using the up method
	 * 
	 * @param E
	 *            a generic value to insert onto the heap
	 * @return void
	 * 
	 */
	void insert(E value) {
		if (isEmpty()) {
			heap.add(null);
		}
		heap.add(value);
		up(size() - 1);
	}

	/**
	 * 
	 removeMin method removes and returns the root of the tree which is the
	 * minimum value of the tree and then relies on the down method to resort
	 * the method
	 * 
	 * @param void
	 * @return E a generic element representing the root, min element
	 * 
	 */
	E removeMin() {// will only work if the arraylist is already sorted
					// correctly
		if (size() == 2) {

			heap.remove(0);// removes the null
			return heap.remove(0);
		}
		//this ensures that the list has proper heap orientation before the min is switched to the end
		for (int i = 1; i < size() - 1; i++) {
			up(size() - i);
		}
		swap(1, size() - 1);
		E min = heap.remove(size() - 1);
		down(1);//shiftig down based on the swap 
		return min;

	}

	/**
	 * 
	 Accepts an element in the tree and returns an integer of its position in
	 * the tree
	 * 
	 * @param E
	 *            a generic element of the tree
	 * @return an int representing the position of the element passed in
	 * 
	 */
	int position(E element) {
		return heap.indexOf(element);
	}

	/**
	 * 
	 the up method relies on the swp method to switch the elements of the tree
	 * if the parent is greater than the child
	 * 
	 * @param int j an int representing the postion to begin swaping the
	 *        elements up to resort the tree
	 * @return void
	 * 
	 */
	void up(int j) {
		int count = j;
		while (hasParent(count)) {// go up until j is the root
			if ((Integer) parent(count) > (Integer) getEntry(count)) {
				swap(count, position(parent(count)));
				count = position(parent(count));
			} else {
				break;
			}

		}
	}

	/**
	 * 
	 the isLeaf method accepts an element position and returns a boolean based
	 * on whether or not it has a right or left child
	 * 
	 * @param int j an ineger representing the position
	 * @return boolean true if the position has a right or left child and false
	 *         if it has no children
	 * 
	 */
	boolean isLeaf(int j) {
		if (!hasLeft(j) && !hasRight(j))
			return true;

		else
			return false;
	}

	/**
	 * 
	 the isEmpty method retrurns a boolean based on whether or not the array
	 * is empty
	 * 
	 * @param void
	 * @return boolean true if the size is 0 and false if not
	 * 
	 */
	boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 The down method acccepts an int of the position relies on the swap method
	 * to fix the sorting method
	 * 
	 * @param int j representing the position to start swaping the element down
	 * @return void
	 * 
	 */
	void down(int j) {
		while (hasLeft(j)) {
			Integer current = (Integer) getEntry(j);
			Integer left = (Integer) left(j);
			int small = j * 2;
			if (hasRight(j)) {
				Integer right = (Integer) right(j);
				if (right < left) {
					small = 2 * j + 1;
				}
			}
			if (current <= small) {
				break;

			}
			swap(j, small);
			j = small;
		}
	}

	/**
	 * the toString method overrides the toString object method to print out the
	 * heap as an array
	 * 
	 * @param void
	 * @return String
	 */
	public String toString() {
		return heap.toString();
	}

}
