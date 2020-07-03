package basics;

public class HeapApplication {

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
	
	public static int [] kLargest (int k) {
		// One by one extract an element from heap
		// And and it to the end.. to the empty space
		// which is created.
		int []data = new int[k];
		int n = array.length;
		int count = 0;
		for (int i = n - 1; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			data[count] = temp;
			count++;
			if (count == k) {
				break;
			}
			// call heapify on the reduced heap
			heapifyFunction(i, 0);
		}
		return data;
	}

	public static int kthLargest(int k) {
		// One by one extract an element from heap
		// And and it to the end.. to the empty space
		// which is created.
		int value = array[0];
		int n = array.length;
		int count = 0;
		for (int i = n - 1; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			count++;
			if (count == k) {
				value = temp;
				break;
			}
			// call heapify on the reduced heap
			heapifyFunction(i, 0);
		}
		return value;

	}

	public static void main(String[] args) {
		
		// Applications
		// k largest(or smallest) elements in an array
		// K’th Largest Element in an array
		// O(n) to heapify and O(log n) to delete
		buildHeap();
		
		System.out.println(kthLargest(3));
		
		System.out.println("K Largest Elements");
		
		int []result = kLargest(3);
		for(int i = 0; i <result.length; i++) {
			System.out.println(result[i]);
		}
		
		// Max Heap -- Elements will be sorted in Ascending Order.
		// Min Heap -- Elements will be sorted in Descending Order.
		
	}
}
