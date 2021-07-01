package util;

import java.util.List;
import java.util.stream.Collectors;

public class Print {

	public static <T> void printValue(List<T> items, final String delimeter) {
		System.out.println(
		  items.stream()
		       .map(String::valueOf)
		       .collect(Collectors.joining(delimeter))
		);
	}
}
