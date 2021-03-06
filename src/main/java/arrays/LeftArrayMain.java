package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftArrayMain {

    //		print , input 5, 4 / result : 5 1 2 3 4
    //https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
	///Users/a1101381/Developer/git/algiorithm/src/main/java/warmup/ArrayLeftRotationMain.java 참고
    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5);
        int d = 4;
        List<Integer> result1 = rotLeft(items, d);
        extracted(result1);

        List<Integer> result2 = rotLeftArrayCopy(items, d);
        extracted(result2);

        int[] ints = rotLeft2(items.stream().mapToInt(i -> i).toArray(), d);
        System.out.println(Arrays.toString(ints));

    }

    private static void extracted(List<Integer> result) {
        String strResult = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(strResult);
    }

    static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> l1 = a;

        int tmp = 0;
        for (int rindex = 0; rindex < d; rindex++) {

            for (int idx = 0; idx < a.size(); idx++) {
                if (idx == 0) {
                    tmp = a.get(idx);
                } else {
                    l1.set(Math.max(idx - 1, 0), a.get(idx));
                }
            }

            l1.set(a.size() - 1, tmp);
        }

        return l1;
    }

    static List<Integer> rotLeftArrayCopy(List<Integer> a, int d) {

        List<Integer> tmp = Arrays.asList(0, 0, 0, 0, 0);
        int n = a.size();

        for (int oldIndex = 0; oldIndex < n; oldIndex++) {
            int newIndex = (oldIndex + n - d) % n;
            tmp.set(newIndex, a.get(oldIndex));
        }

        return tmp;
    }

    static int[] rotLeft2(int[] a, int d) {
        int n = a.length;
        int[] rotArray = new int[n];

        for (int oldIndex = 0; oldIndex < n; oldIndex++) {
            int newIndex = (oldIndex + n - d) % n;
            rotArray[newIndex] = a[oldIndex];
        }

        return rotArray;
    }

}
