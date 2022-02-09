package problem;

//https://www.hackerrank.com/challenges/drawing-book/problem
public class DrawingBook {

	static int solution(int n, int p ) {
//			int totalN = n /2;
//			int totalP = p /2;
//			return Math.min(totalN, totalP);
		int totalN = n / 2; //total page size
		int totalP = p / 2; // target page
		int backTotal = totalN - totalP;

		return Math.min(totalP, backTotal);
	}

	public static void main(String[] args) {
		int n = 5;
		int p = 3;

		int result = solution(n, p);
		System.out.println(result);

	}

}
