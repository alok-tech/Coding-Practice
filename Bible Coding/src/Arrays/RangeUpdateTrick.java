package Arrays;

public class RangeUpdateTrick {

	public static int []array = {2, -7, 10, 3, -1, 19, -20, 23, 17};
	public static int []subarray = new int[array.length];
	public static int []sum = new int[array.length];
	
	public static void update(int x, int y, int val) {
		subarray[x] +=val;
		subarray[y] -= val; 
	}
	// Pre Computation Worst Case 0(n)
	// This is best when all updates first like 100s of Updates
	// Update - Build Array - Update ---> Segment Tree Problem
	public static void buildFinalArray() {
		sum[0] = array[0] +  subarray[0];
		array[0] +=sum[0]; 
		for(int i=1; i < sum.length; i++) {
			sum[i] = sum[i-1] + subarray[i];
			array[i] += sum[i];
		}
	}
	public static void main(String[] args) {
		update(3, 7, 5);
		update(4, 8, 2);
		update(2, 6, -1);
		for(int i=0; i< array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
