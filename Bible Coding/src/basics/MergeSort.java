package basics;

public class MergeSort {
	// In Merge Sort we say if there is a single element then we don't have to sort it.
	static int [] array = {4,2,1,6,12,9};
	
	public static void mergeSort(int low, int high) {
		if(low < high) {
			int mid = (low + high)/2;
			mergeSort(low, mid);
			mergeSort(mid+1, high);
			// Recursively Merge
			merge(low, mid, high);
		}
	}
	
	public static void merge(int low, int mid, int high) {
		// Find sizes of two subarrays to be merged 
		int n1 = mid - low +1;
		int n2 = high - mid;
		// Creating temp arrays
		int L[]= new int[n1];
		int R[] = new int[n2];
		/*Copy data to temp arrays*/
		for(int i = 0; i< n1; i++) {
			L[i] = array[low+i];
		}
		for(int j =0; j< n2; j++){
			R[j] = array[mid+1+j];
		}
		/* Merge the temp arrays */
		 // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
        // Initial index of merged subarry array 
        int k = low; 
        while (i < n1 && j < n2) {
        	if(L[i] <= R[j]) {
        		array[k] = L[i];
        		i++;
        	}else {
        		array[k] = R[j];
        		j++;
        	}
        	k++;
        }
        /* Copy remaining elements of L[] if any */        
        while (i < n1) {
          	array[k] = L[i];
        	i++;
        	k++;
        }
        
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
        	array[k] = R[j];
        	j++;
        	k++;
        }
	}

	public static void main(String[] args) {
		mergeSort(0, array.length - 1);
		
		for(int i= 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
}
