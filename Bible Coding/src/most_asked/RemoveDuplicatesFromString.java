package most_asked;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromString {

	
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		LinkedHashSet<Character> hs = new LinkedHashSet<>();
		
		for(int i = 0; i < s.length(); i++) {
			hs.add(s.charAt(i));
		}
		
		System.out.println(hs.toString());
	}
}
