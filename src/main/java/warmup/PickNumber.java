package warmup;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/picking-numbers/problem
public class PickNumber {
    public static void main(String[] args) {
        int n = 6;
        int[] a = new int[100];
        int[] inNumbers = new int[]{ 1, 2, 2, 3, 1,2};
        for(int a_i=0; a_i < n; a_i++){
            a[inNumbers[a_i]]++; //?? 이걸왜 자릿수라 생각하지
        }

        //[0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        int max = 0;
        for(int i = 0; i < a.length - 1; i++){
            int nextMax = a[i] + a[i+1];
            if(nextMax > max){
                max = nextMax;
            }
        }

        System.out.println(max);
    }

    public static int pickingNumbers(List<Integer> a) {
        List<Integer> values = new ArrayList<Integer>();
        for (Integer item : a) {
            if (!values.contains(item)) {
                values.add(item);
            }
        }

        int max = 0;
        int maxTemp = 0;
        for (Integer sValue : values) {
            for (Integer inV : a) {
                if (Math.abs(sValue - inV) <= 1 && sValue >= inV) {
                    maxTemp++;
                }
            }

            if (maxTemp > max) {
                max = maxTemp;
            }
            maxTemp = 0;
        }

        return max;
    }
}
