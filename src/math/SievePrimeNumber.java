package math;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 1. Create a boolean array and mark all number upto N as Prime
 * 2. Iterate upto sqrt(N)
 * 3. For each prime number, mark its multiples as composite numbers.
 * 4. Numbers which are not marked as composite will be prime numbers.
 * 
 * @author Ankit
 *
 */
public class SievePrimeNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		System.out.println("Prime numbers upto "+n +" are :");
		for(int i=2;i<=n;i++){
			if(isPrime[i])
				System.out.println(i);
		}
	}
}
