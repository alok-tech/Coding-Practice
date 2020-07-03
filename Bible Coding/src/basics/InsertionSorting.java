package basics;

public class InsertionSorting {

	static int [] array = {4,2,1,6,12,9};
	
	public static void main(String[] args) {
		
		for(int i = 1; i < array.length; i++) {
			
			int element = array[i];
			int j = i;
			while ((j>=1) && (array[j-1] > element)) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = element;
		}
		
		// Print the elements
		for(int i= 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
}
