package warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class ArrayLeftRotationMain {

    public static void main(String[] args) {
        int shift = 3;
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5); //ListOf를 사용하지 말자 UnImmutable 객체로 생성되 값을 추출할수 없음
//        rotLeft(items, shift).forEach(System.out::println);

        System.out.println(" ");
//        rotRight(items, shift).forEach(System.out::println);

        reverseArray(items, shift).forEach(System.out::println);
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {

        for (int i = 0; i < d; i++) {
            int j;

            int firstValue = a.get(0); //항상 left값을 뒤로 보내기 위해 항상 0인것을 가져온다.
            for (j = 0; j < a.size()-1; j++) {
                a.set(j, a.get(j + 1));
            }

            a.set(j, firstValue);
        }

        return a;
    }

    //1 ,2 ,3, 4,5 --> 5,1,2,3,4 --> 4,5,1,2,3 -> 3,4,5,1,2
    public static List<Integer> rotRight(List<Integer> a, int d) {
        for (int i = 0; i < d; i++) {
            List<Integer> dummy = new ArrayList<>(a); //변하지 않는값을 가지고 있어야 되나?

            int lastValue = a.get(a.size()-1); //항상 left값을 뒤로 보내기 위해 항상 0인것을 가져온다.
            for( int j = 0; j < a.size() -1; j ++) {
                int tmp = dummy.get(j);
                a.set(j+1, tmp);
            }

            a.set(0, lastValue);
        }
        return a;
    }

    private static List<Integer> reverseArray(List<Integer> arr, int n) {
        //Rotate the given array by n times toward right
        for(int i = 0; i < n; i++){
            int j, last;
            //Stores the last element of array
            last = arr.get(arr.size()-1);

            for(j = arr.size()-1; j > 0; j--){
                //Shift element of array by one
                arr.set(j, arr.get(j-1));
            }
            //Last element of array will be added to the start of array.
            arr.set(0, last);
        }
        return arr;
    }
}



