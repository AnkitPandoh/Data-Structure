package math;

import java.util.Stack;

/**
 * <p>
 * Every GCD(A,B) can be expressed in term of a linear equation such as
 * GCD(A,B)= Ax+By for e.g. GCD(16,10) = 16(2)+10(-3) where x and y are
 * coefficients. and GCD(A,B) = GCD(B, A%B) ) Solving above two equations will
 * give:
 * </p>
 * <ul>
 * <li>x = y1</li>
 * <li>y = x1-floor[A/B]*y1</li>
 * </ul>
 * <p>
 * This is an iterative approach where first GCD is calculated using Euclid
 * Algo. coefficients are calculated using above formula for x and y.
 * </p>
 * 
 * @author Ankit
 *
 */
public class ExtendedEuclid {
	public static void main(String[] args) {
		int a = 1180, b = 482;
		Stack<Integer> sta = new Stack<Integer>();
		Stack<Integer> stb = new Stack<Integer>();
		while (b != 0) {
			sta.push(a);
			stb.push(b);
			int rem = a % b;
			a = b;
			b = rem;
		}
		int ans = a;
		int x = 1, y = 0;

		while (!sta.isEmpty()) {
			int temp = x;
			x = y;
			y = (int) (temp - Math.floor(sta.pop() / stb.pop()) * y);
		}
		System.out.println("GCD is :" + ans);
		System.out.println("Coefficients are :" + x + "," + y);
	}

}
