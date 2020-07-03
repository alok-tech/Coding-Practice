package maths;

public class Prefix_Postfix_Max_Array {

	public static void main(String[] args) {
		int arr[] = { 10, 4, 16, 20 };
		int n = arr.length;
		int prefixSum[] = new int[n];
		int postSum[] = new int[n];

		fillPrefixSum(arr, n, prefixSum, postSum);
		
		for (int i =0; i<prefixSum.length; i++) {
			System.out.print(prefixSum[i] + "**");
		}
		System.out.println();
		for (int i =0; i<prefixSum.length; i++) {
			System.out.print(postSum[i] + "**");
		}
	}

	private static void fillPrefixSum(int[] arr, int n, int[] prefixSum, int[]postSum) {
		prefixSum[0] = arr[0];
		postSum[n-1] = arr[n-1];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] >= arr[i] ? prefixSum[i - 1]: arr[i];
		}

		for(int i =n-2; i >=0; i--) {
			postSum[i] = postSum[i + 1] >= arr[i] ? postSum[i + 1]: arr[i];
		}
		
		
	}
}
