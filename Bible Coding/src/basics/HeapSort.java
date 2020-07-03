package basics;

public class HeapSort {

	static int[] array = { 12, 11, 13, 5, 6, 7 };

	public static void heapifyFunction(int n, int i) {
		// i is the index of the node, where we currently are
		int currentNode = i;
		int leftChild = (2 * i);
		int rightChild = (2 * i + 1);

		if (leftChild < n && array[leftChild] > array[currentNode]) {
			currentNode = leftChild;
		}

		if (rightChild < n && array[rightChild] > array[currentNode]) {
			currentNode = rightChild;
		}
		if (currentNode != i) {
			// Do the Swapping of Nodes
			int swap = array[i];
			array[i] = array[currentNode];
			array[currentNode] = swap;
			// Recursively heapify the affected Sub-Tree
			heapifyFunction(n, currentNode);
		}
	}

	public static void buildHeap() {
		// Start with the middle position of the array..
		// (2 * i position will be automatically covered)
		int n = array.length;
		for (int i = (n / 2 - 1); i >= 0; i--) {
			heapifyFunction(n, i);
		}
	}

	public static void heapSort() {
		// One by one extract an element from heap
		// And and it to the end.. to the empty space
		// which is created.
		int n = array.length;
		for (int i = n - 1; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			// call heapify on the reduced heap
			heapifyFunction(i, 0);
		}

	}

	public static void main(String[] args) {
		buildHeap();
		heapSort();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		// Applications
		
		// k largest(or smallest) elements in an array
		// K’th Largest Element in an array
	}
}
