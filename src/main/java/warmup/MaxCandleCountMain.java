package warmup;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
public class MaxCandleCountMain {

    public static void main(String[] args) {
        List<Integer> candles = List.of(44,53,31,27,77,60,66,77,26,36);

        int maxNumber =0;
        List<Integer> maxCandleCount = new ArrayList<>();

        maxNumber = candles.parallelStream().mapToInt( x -> x).max().getAsInt();
        int finalMaxNumber = maxNumber;

        int count = Math.toIntExact(candles.stream().filter(i -> i == finalMaxNumber).count());
        System.out.println(count);
    }
}
