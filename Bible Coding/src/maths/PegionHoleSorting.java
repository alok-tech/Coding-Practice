package maths;

import java.util.Arrays;

//Pigeonhole Principle

//The Pigeonhole Principle (also known as the Dirichlet box principle, Dirichlet principle or box principle) states that if $n + 1$ or more pigeons are placed in $n$ holes, then one hole must contain two or more pigeons. Another definition could be phrased as among any $n$ integers, there are two with the same modulo-$n-1$ residue.

//Although this theorem seems obvious, many challenging olympiad problems can be solved by applying the Pigeonhole Principle. Often, a clever choice of box is necessary.


public class PegionHoleSorting {

	public static void pigeonhole_sort(int arr[], int n) {
		int min = arr[0];
		int max = arr[0];
		int range, i, j, index;

		for (int a = 0; a < n; a++) {
			if (arr[a] > max)
				max = arr[a];
			if (arr[a] < min)
				min = arr[a];
		}

		range = max - min + 1;
		int[] phole = new int[range];
		Arrays.fill(phole, 0);

		for (i = 0; i < n; i++)
			phole[arr[i] - min]++;

		index = 0;

		for (j = 0; j < range; j++)
			while (phole[j]-- > 0)
				arr[index++] = j + min;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 3, 2, 7, 4, 6, 8 };

		System.out.print("Sorted order is : ");

		pigeonhole_sort(arr, arr.length);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}