package java_collections_uses;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetImpl {
	
	public static void main(String[] args) {
		// int []arr = new int[10];
		
		int[]arr = {2,4,2,7,6};
		int[] arr2 = new int[10];
		HashSet<Integer> set = new HashSet<Integer>();
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
