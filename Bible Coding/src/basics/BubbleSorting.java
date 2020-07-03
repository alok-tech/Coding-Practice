package basics;

public class BubbleSorting {

	
	static int [] array = {4,2,1,6,12,9};
	
	public static void main(String[] args) {
		
		for(int i= 0; i <array.length; i++) {
			for(int j = 0; j < (array.length - 1); j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for(int i= 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
}
