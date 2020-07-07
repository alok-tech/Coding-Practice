package Arrays;

public class MaximumSumSubArray {
	
	// Greedy Approach and Partial Sum Approach
	
	// (1) Greedy Approach..
	// (a) Observation (a) If all the elements in the array are positive then the
	// (b) Solution will be the whole.

	//static int[]array = {2, -6, 3, 4, -2, 3, -3};
	static int[]array = {-6, -2, -3, -4, -2, -3, -3};
	
	// This is the Greedy Approach
	static int maxSumSubArray(int a[]) {
		int ans= array[0], sum =0;
		for(int i=0; i < a.length; i++) {
			sum += a[i];
			if(sum > ans)
				ans = sum;
			if(sum < 0)
				sum = 0;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(maxSumSubArray(array));
	}

}
