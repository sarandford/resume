package searchAlgorithms;

/**
 * The Search class impelements an iterative and recursive version of both
 * linear and binary searches
 * 
 * @author Sarah Ford
 * @since Sepetmeber 23,2014
 */

public class Search {
	/**
	 * 
	 The binaryRecursion method uses binary search recursively to find an
	 * integer in an array
	 * 
	 * @param data
	 *            an array of type int, x int, high int, low int
	 * @return boolean
	 * 
	 */
	static boolean binaryRecursion(int[] data, int x, int high, int low) {
		if (low > high) {
			return false;
		} else {
			int mid = (high + low) / 2;
			if (data[mid] == x) {
				return true;
			} else if (x < data[mid]) {
				return binaryRecursion(data, x, mid - 1, low);
			} else {
				return binaryRecursion(data, x, high, mid + 1);
			}
		}
	}

	/**
	 * 
	 the linearRecurison method implements a linear search recursivley. It
	 * will throw a stack overflow error if overwhelmed with too large an
	 * integer
	 * 
	 * @param data
	 *            an array of type int, x int, index x
	 * @return boolean
	 * 
	 */
	static boolean linearRecursion(int[] data, int x, int index) {
		if (data[index] == x) {
			return true;
		} else {
			return linearRecursion(data, x, index + 1);
		}

	}

	/**
	 * 
	 linearIterative method implements a traditional iterative linear search
	 * 
	 * @param data
	 *            an array of type int, x int
	 * @return void
	 * 
	 */
	static void linearIterative(int[] data, int x) {
		for (int item : data) {
			if (item == x) {
				return;
			}
		}
	}

	/**
	 * 
	 the binaryIterative method implements a binary search iteratively
	 * 
	 * @param data
	 *            an array of type int, x int
	 * @return void
	 * 
	 */
	static void binaryIterative(int[] data, int x) {
		int high = data.length - 1;
		int low = 0;
		int mid = (high + low) / 2;
		while (low < high) {
			// System.out.println(mid);
			if (data[mid] == x) {
				return;
			} else if (x < data[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			mid = (high + low) / 2;
		}
		return;

	}

}
