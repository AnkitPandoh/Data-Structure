package math;
/**
 * Program to find the power of any number
 * using concept of modular arithmetic
 * @author ankpando
 *
 */
public class ModularExponentiation {
	public static void main(String[] args){
		int n = 3;
		int p = 10;
		int result = 1;
		while(p != 0){
			if((p & 1) != 0){
				result *= n;
			}
			n *= n;
			p /= 2;
		}
		System.out.println(result);
	}
}
