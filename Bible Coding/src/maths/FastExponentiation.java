package maths;

public class FastExponentiation {
	//Divide and Conquer
	// a ^n
	// Recursive Approach
	static int fastExpo(int a, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return fastExpo(a * a, n / 2);
		return a * fastExpo(a, n - 1);
	}
	
	// Iterative Approach
	static int fastExpoIterative (int a, int n) {
		int ans =1;
		int value = 0;
		while(n >=1) {
			if(n% 2 == 0) {
				value = (int) (Math.pow(a, n/2));
				ans =  ans * (value)* (value);
				n /= 2;
			}else {
				value = (int)Math.pow(a, n-1);
				ans =  ans * (value);
				n = n-1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		//System.out.println(fastExpo(12, 2));
		System.out.println(fastExpoIterative(2, 3));
	}
}
