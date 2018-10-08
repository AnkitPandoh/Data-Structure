package math;
/**
 * Euclid Algorithm to find the GCD of two numbers
 * @author ankpando
 *
 */
public class EuclidGcd {
	public static void main(String[] args){
		int a = 1180, b = 482;
		while(b != 0){
			int rem = a%b;
			a = b;
			b = rem;
		}
		System.out.println("GCD is : "+a);
	}
}
