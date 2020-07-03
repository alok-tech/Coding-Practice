package basics;

public class SelectionSorting {
	
	static int [] array = {4,2,1,6,12,9};
	
	public static void main(String[] args) {
		for(int i = 0 ; i < array.length ; i++) {
			int min = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			// Swap the current index with the 
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		for(int i= 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
