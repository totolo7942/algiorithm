package arrays;

import util.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayList {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1,4,3,2);

		List<Integer> result = reverArray(arr, arr.size());
		Print.printValue(result, " ");

		List<String> strArr = Arrays.asList("Ashish","Yadav ","Abhishek","Rajput","Sunil","Pundir","Prem");
		Print.printValue(reverseStrArray(strArr), " ");

	}


	static List<Integer> reverArray(List<Integer> items, int N) {
			List<Integer> revArray = new ArrayList<>();
			for( int idx = items.size()-1; idx >= 0 ; idx --) {
				revArray.add(items.get(idx));
			}

			return revArray;
	}

	static List<String> reverseStrArray(List<String> items){
		List<String> ret = new ArrayList<>();
		for(String item : items) {

			StringBuilder retBuilder = new StringBuilder();
			for( int idx = item.length()-1; idx >= 0 ; idx --) {
				retBuilder.append(item.charAt(idx));
			}
			ret.add(retBuilder.toString());
		}

		return ret;
	}
}
