package Arrays;

public class MaximumSubArrayPartialSum {
	
	static int[]array = {2, -6, 3, 4, -2, 3, -3};
	public static int []sum = new int[array.length];
	public static void preComputeSum() {
		sum[0] = array[0];
		for(int i=1; i< array.length; i++) {
			sum[i]= sum[i-1] + array[i];  // 0(n) time for Pre Computation
		}
	}

	public static int maxSumSubArray() {
		int minSum = 0, ans = array[0];
		for(int i =0; i< sum.length; i++) {
			if(sum[i] - minSum > ans) {
				ans = sum[i] - minSum;
			}
			if(sum[i] < minSum) {
				minSum = sum[i];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		preComputeSum();
		System.out.println(maxSumSubArray());
	}
}
