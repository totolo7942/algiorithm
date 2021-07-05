package problem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BillDivision {
	static List<Integer> item = Arrays.asList(3, 10, 2, 9);
	int n = 4;
	static int k = 1;
	static int b = 12;

	static void bonAppetit(List<Integer> bill, int k, int b){

		int sum =0;
		for( Integer cost : bill) {
			if(!cost.equals(bill.get(k))) //느림 cost != bill.get(k) 로 고체 해야 빠름
 			    sum += cost;
		}


		final int result = sum / 2;
		if (result >= b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println( b - result);
		}
	}

	public static void main(String[] args) {
		bonAppetit(item, k, b);
	}
}
