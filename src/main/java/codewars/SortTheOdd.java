package codewars;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 당신은 숫자의 배열을 받게 될 것입니다. 홀수는 오름차순으로 정렬하고 짝수는 원래 위치에 그대로 두어야 합니다.
 * [7, 1]  =>  [1, 7]
 * [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
 * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */
public class SortTheOdd {

    public static int[] sortArray1(int[] array) {

        int[] odd = new int[array.length];

        Arrays.sort(array);

        int s = 0;
        int w = 0;
        for( int i =0; i < array.length; i ++ ) {
            if( array[i] % 2 != 0 ) {
                odd[i] = array[i];
            }
        }

        return array;
    }


    public static int[] sortArray(int[] array) {
        List<Integer> resArray = Arrays.stream(array).boxed().collect(Collectors.toList());
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : array) {
            if (j % 2 == 1) {
                list.add(j);
            }
        }


        Collections.sort(list);
        int count=0;
        for (int i = 0; i < resArray.size(); i++) {
            if (resArray.get(i) % 2 != 0) {
                resArray.set(i,list.get(count));
                count++;
            }
        }
        return resArray.stream().mapToInt(i->i).toArray();

    }

    public static void main(String[] args) {
        int[] ret = sortArray1(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        Arrays.stream(ret).forEach(System.out::print);
    }
}
