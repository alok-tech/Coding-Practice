package string;

public class Test {
	public static void main(String[] args) {
		/*  String.substring(start, end)
			Parameter Values Parameter	Description start Required. 
			The position where to start the extraction. First character is at index 0
            end	Optional. The position (up to, but not including) where to end the extraction.
            If omitted, it extracts the rest of the string*/
		
			//StringBuffer test = "Alok"; // Index starts with zero only.. 0
			//System.out.println(test.length());
			//System.out.println(test.substring(0, 3));
			
			//String"AlAq");
		
			String test = "AllA";
			StringBuffer sb = new StringBuffer(test);
			System.out.println(sb.reverse());
			if(sb.equals(sb.reverse())) {
				System.out.println("Palindrome");
			}
	}
	
	
}