package maths;


public class PrefixSumArray {

	static int [] array = {10, -2, 11, 43, 15};
	static int [] prefixSumArray = new int [array.length];
	
	public static void main(String[] args) {
		prefixSumArray[0] = array[0];
		
		// 0(n) is the complexity to find Prefix Sum Array
		for(int i = 1; i< array.length; i++) {
			prefixSumArray[i] = prefixSumArray[i-1] + array[i]; 
		}
		
		// Print the Prefix Sum Array
		for (int i = 0; i < prefixSumArray.length; i++) {
			System.out.println(prefixSumArray[i]);
		}
	}
}
