package most_asked;

public class PrintLast10Lines {

	
	public static void main(String[] args) {
		String st = "\"str1\\nstr2\\nstr3\\nstr4\\nstr5\\nstr6\\nstr7\\nstr8\\nstr9\\nstr10\\nstr11\\nstr12\\nstr13\\nstr14\\nstr15\\nstr16\\nstr17\\nstr18\\nstr19\\nstr20\\nstr21\\nstr22\\nstr23\\nstr24\\nstr25\""; 
		String []arr = st.split("\\n");
		for (int i = arr.length -1 ; i < (arr.length - 11); i--) {
			System.out.println(arr[i]);
		}
	}
}
