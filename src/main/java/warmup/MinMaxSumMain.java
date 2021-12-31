package warmup;

import java.util.List;

//https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
public class MinMaxSumMain {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long max = 0, min = 0, sum =0;
        for( int i=0; i < arr.size(); i ++) {
            sum =0;
            for (int k =0; k < arr.size(); k++) {
                if ( i != k) {
                    sum += arr.get(k);
                }
            }

            if(i == 0) {
                min = sum;
                max = sum;
            } else {
                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }
        }
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        List<Integer> items = List.of(5,5,5,5,5);

        miniMaxSum(items);
    }
}
