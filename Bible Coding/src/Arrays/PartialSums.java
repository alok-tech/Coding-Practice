package Arrays;

public class PartialSums {

	public static int []array = {2, 4, -3, 6, 10, -10};
	
	public static int []sum = new int[array.length];
	
	public static void preComputeSum() {
		sum[0] = array[0];
		for(int i=1; i< array.length; i++) {
			sum[i]= sum[i-1] + array[i];  // 0(n) time for Pre Computation
		}
	}
	
	public static int query (int x, int y) {
		return (sum[y] - sum[x-1]);  // Returns result in constant time
	}
	public static void main(String[] args) {
		preComputeSum();
		for(int i = 0; i <sum.length; i++) {
			System.out.print(sum[i] + " ");
		}
		//System.out.println(query(2, 4));
	}
}
