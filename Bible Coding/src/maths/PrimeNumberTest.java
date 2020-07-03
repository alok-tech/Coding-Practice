package maths;

public class PrimeNumberTest {

	public static boolean isPrime(int number) {
		// Since zero and one are not prime numbers.
		// Code is efficient.
		if(number == 0 || number == 1)
			return false;
		for(int i =2; i<= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		if (isPrime(16)) {
			System.out.println("Prime Number");
		}else {
			System.out.println("Not a Prime Number");
		}
		
	}
}
