package Arrays;

// Only used for consecutive..adjacent element{array, string}

public class SlidingWindowAlgorithm {
	
	static int []array = {1, 4, 2, 10, 23, 3, 1, 0, 20};
	
	static int maxSumOfKConscutiveNumbers(int k) {
		int window_sum = 0;
		for(int i=0; i < k; i++) {
			window_sum += array[i];
		}
		int maxSum = window_sum;
		for(int i = k; i < (array.length-k+1); i++) {
			window_sum = window_sum + array[i] - array[i-k];
			maxSum = Math.max(window_sum, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(maxSumOfKConscutiveNumbers(4));
	}
}
