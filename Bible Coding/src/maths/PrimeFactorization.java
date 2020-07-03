package maths;

import java.util.ArrayList;

public class PrimeFactorization {

	static ArrayList<Integer>factors = new ArrayList<>();
	static ArrayList<Integer>exponents = new ArrayList<>();
	
	public static void primeFact(int number) {
		if(number == 1) {
			factors.add(2);
			exponents.add(0);
		}
		int d =2;
		while (number > 1 && number >= Math.sqrt(d)) {
			int k =0;
			while (number % d == 0) {
				number = number/d;
				k++;
			}
			if(k >0) {
				factors.add(d);
				exponents.add(k);
			}
			d++;
		}
		if (number > 1) {
			factors.add(number);
			exponents.add(1);
		}
	}
	public static void main(String[] args) {
		primeFact(210);
		System.out.println(factors);
		System.out.println(exponents);
	}
}
