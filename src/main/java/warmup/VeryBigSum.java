package warmup;

import java.util.Arrays;
import java.util.List;

public class VeryBigSum {

	public static long aVeryBigSum(List<Long> ar) {
		// Write your code here

		long sum = 0L;
		for (Long i : ar) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
//		List<Long> items = Arrays.asList(1000000001L,1000000002L,1000000003L,1000000004L,1000000005L);
		List<Long> items = Arrays.asList(1001458909L,
		                                 1004570889L,
		                                 1007019111L,
		                                 1003302837L,
		                                 1002514638L,
		                                 1006431461L,
		                                 1002575010L,
		                                 1007514041L,
		                                 1007548981L,
		                                 1004402249L);
		long bigSum = aVeryBigSum(items);
		System.out.println(bigSum);
	}
}
