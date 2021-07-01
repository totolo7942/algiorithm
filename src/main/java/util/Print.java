package util;

import java.util.List;
import java.util.stream.Collectors;

public class Print {

	public static void printValue(List<?> items, final String delimeter) {
		System.out.println(items.stream().map(String::valueOf).collect(Collectors.joining(delimeter)));
	}

	public static void printStrValue(List<String> items, final String delimeter) {
		System.out.println(String.join(delimeter, items));
	}
}
