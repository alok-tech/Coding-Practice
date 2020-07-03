package basics;

public class QuickSort {

	static int[] array = { 4, 2, 1, 6, 12, 9 };

	static int partiton(int low, int high) {
		int pivot = array[low];
		int i = low, j = high;

		while (i < j) {
			do {
				i++;
			} while (array[i] <= pivot);

			do {
				j--;
			} while (array[j] > pivot);

			if (i < j) {
				int temp = array[j];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		// Determining the right position of Pivot
		int temp = array[low];
		array[low] = array[j];
		array[j] = temp;
		return j;
	}
	
	public static void quickSort(int low, int high) {
		if(low < high) {
			int j = partiton(low, high);
			quickSort(low, j);
			quickSort(j+1, high);
		}
	}

	public static void main(String[] args) {

		quickSort(0, (array.length -1));
		for(int i= 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
