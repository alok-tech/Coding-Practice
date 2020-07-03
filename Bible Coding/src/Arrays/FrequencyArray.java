package Arrays;

public class FrequencyArray {

	// int fr[VMax] -- Vmax == Max Val in my set
	// fr[x] == How Many times we encountered value x
	static int [] array= {2,5,3,7,2,4, 5};
	static int fr[] = new int[8];
	
	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if (fr[array[i]] == 0)
				count++;
			fr[array[i]]++;
		}
		//System.out.println(count);
		System.out.println(fr[5]);
	}
}
