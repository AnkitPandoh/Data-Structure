package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Totient function or phi(n) gives us the count of numbers
 * which are less than N and co-prime with N. In other
 * words, GCD(N,X) = 1 where 1<=X<=N.
 * 1. Generate all the primes upto N.
 * 2. Check which primes p exactly divides N
 * 3. Use formula phi(N) = N*(1-1/p1)*(1-1/p2).. so on
 * 
 * @author Ankit
 *
 */

public class EulerTotientFunction {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int tf = n;
		for (int p : getPrimes(n)) {
			if (n % p == 0) {
				tf *= (1.0 - (1.0 / (float) p));
			}
		}
		System.out.println(tf);
	}

	private static List<Integer> getPrimes(int n) {
		int[] arr = new int[n + 1];
		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i * i <= n; i++) {
			if (arr[i] == 0) {
				for (int j = i * i; j <= n; j += i) {
					arr[j] = 1;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				primes.add(i);
			}
		}
		return primes;
	}
}
