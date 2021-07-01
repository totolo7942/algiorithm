package recursion;

public class Recursion3 {

	public static void main(String[] args) {
		int factoryValue = 3;

		int ret = factorial(factoryValue);
		System.out.println(ret);
	}

	public static int factorial(int n) {
		if( n <= 1 ) return 1;

		return n  * factorial(n-1);
	}
}
