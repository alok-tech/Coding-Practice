package maths;

public class SieveErantosthenes {

	static boolean[] isPrime = new boolean[1000];

	public static void sieveOfErantoshnes(int limit) {
		for (int i = 2; i <= limit; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i <= (limit) / 2; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= limit; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		sieveOfErantoshnes(17);
		for (int i = 2; i <= 17; i++) {
			if (isPrime[i])
				System.out.println(i);
		}
	}

}
