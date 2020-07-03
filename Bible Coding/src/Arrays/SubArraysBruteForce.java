package Arrays;

public class SubArraysBruteForce {

	static int []array = {2, 3, 7, 6, 8};
	public static void main(String[] args) {
		
		// 0(n3)
		
		for(int left = 0 ; left < array.length; left++) {
			for(int right = left; right < array.length; right++) {
				for(int k = left; k <= right; k++) {
					System.out.print(array[k]);
				}
				System.out.println();
			}
		}
		
	}
}
