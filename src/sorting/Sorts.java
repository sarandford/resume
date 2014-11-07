package sorting;
public class Sorts {

	private void quickSort(int[] inputArray, int startIndex, int endIndex) {

		int i = startIndex;
		int j = endIndex;

		if (startIndex < endIndex) {
			
			//pick pivot value as middle value
			int pivot = inputArray[startIndex + (endIndex - startIndex) / 2]; 
			
			// partition
			while (i < j) {
				while (inputArray[i] < pivot)
					i++;
				while (inputArray[j] > pivot)
					j--;

				if (i <= j) {
					// swap
					int temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
					// prepare for next iteration of outer loop
					i++;
					j--;
				}
			}
			//now sort each subarray
			quickSort(inputArray, startIndex, j);
			quickSort(inputArray, i, endIndex);
		}
	}

	public static void main(String a[]) {

		Sorts sorter = new Sorts();
		int[] intArray = { 43, 45, 65, 23, 8, 2, 12, 11, 93, 20, 2, 100, 1, 54,
				62 };
		for (int i : intArray) {
			System.out.print(i + " ");
		}
		System.out.println();

		sorter.quickSort(intArray, 0, intArray.length - 1);

		for (int i : intArray) {
			System.out.print(i + " ");
		}
	}
}