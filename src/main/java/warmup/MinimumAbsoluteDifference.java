package warmup;

import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_r=next-challenge&h_v=zen
//절대값 수와 수의 거리 -1  .. 0 .. 1 수는 방향과 거리를 나타낸다.
public class MinimumAbsoluteDifference {

	public static int minimumAbsoluteDifference(List<Integer> arr) {
		// Write your code here
		Arrays.sort(arr.toArray());

		int diff =Math.abs( arr.get(0) - arr.get(1));

		for (int i = 1; i < arr.size() - 1; i++) {
			int newDiff = Math.abs( arr.get(i) - arr.get(i+1));
			if( diff > newDiff)
				diff = newDiff;
		}

		return diff;
	}

	public static void main(String[] args) {
//		List<Integer> item = Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75);
		List<Integer> item = Arrays.asList(1, -3, 71, 68, 17);
		int absResult = minimumAbsoluteDifference(item);
		System.out.println(absResult);
	}
}
