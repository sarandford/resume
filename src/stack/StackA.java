package stack;

/**
 * The stackA class implements the stack interface using an array data structure
 * 
 * @author Sarah Ford
 * @since Septmeber 15, 2014
 * 
 */
public class StackA implements StackInterface<Integer> {

	Integer[] array;
	int size;

	public StackA() {
		array = new Integer[1000];
		size = 0;
	}

	public boolean isEmpty() {
		if (array[0] == null) {
			return true;
		} else {
			return false;
		}
	}

	public Integer peak() {
		return array[size];

	}

	public void push(Integer x) {
		if (size != array.length - 1 && size != array.length) {
			array[size + 1] = x;
			size += 1;
		} else {
			Integer[] tempArray = new Integer[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				tempArray[i] = array[i];
			}
			tempArray[array.length + 1] = x;
			array = tempArray;

		}

	}

	public Integer pop() {
		if (size <= .25 * array.length) {
			Integer[] newArray = new Integer[size];
			array = newArray;
			return array[size - 1];
		} else {
			return array[size];
		}
	}

	public void makeEmpty() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}

}
