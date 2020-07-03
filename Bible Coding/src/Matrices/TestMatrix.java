package Matrices;

import java.util.Arrays;

public class TestMatrix {
	
	static int [][]matrix = {{3,2,1},{6,4,2}};
	
	public static void main(String[] args) {
		//System.out.println(matrix.length);
		for(int i=0; i< matrix.length; i++) {
			Arrays.sort(matrix[i]);
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}