package Arrays;

public class LongestConsecutiveNumberSubAarray {

	// Use ofFrequency Array Here.
	//static int[] array = {4, 1, 2, 3, 7, 6};
	static int[] array = {1, 1, 1, 4, 5};
	static boolean[] fr = new boolean[10];

	static int longestConsecutiveNumsSubArray() {
		int ans = 0;
		for (int left = 0; left < array.length; left++) {
			for (int i = 0; i < array.length; i++) {
				fr[i] = false;
			}
			int min = array[left], max = array[left]; // This is the way of declaring and saving loops
			for(int right = left; right < array.length; right++) {
				if (fr[array[right]]) {
					break;
				}
				fr[array[right]] = true;
				min = Math.min(min, array[right]);
				max = Math.max(max, array[right]);
				
				if ((right - left) == (max -min)) {
					ans = Math.max(ans, (right -left + 1));
				}
			}

		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutiveNumsSubArray());
	}
}
