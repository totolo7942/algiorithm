package hackerrank;

import java.util.List;

public class SubarrayDivision {

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int ret = 0;

        for( int i = 0; i < s.size(); i ++) {
            int sum =0;
            for(int k = i; k < i+m; k ++ ){
                if( i+m <= s.size()) {
                    sum +=s.get(k);
                }
            }

            if(sum == d ) ret ++;

        }

        System.out.println("result : " + ret);
        return ret;
    }

    public static void main(String[] args) {
        birthday(List.of(1, 2, 1, 3, 2), 3, 2);
        birthday(List.of(4), 4, 1);
    }
}
