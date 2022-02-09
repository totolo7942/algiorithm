package codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VowelCountMain {

    public static void main(String[] args) {
        int count = getCount("abracadabra");

        System.out.println(count);
    }

    public static int getCount(String str) {
        int vowelsCount = 0;
        final String baseSet = "aeiou";

        HashSet<Character> hashSet = new HashSet<>();
        for(char s : baseSet.toCharArray()) {
            hashSet.add(s);
        }

        for( char c : str.toCharArray()) {
            if(hashSet.contains(c)) {
                vowelsCount++;
            }
        }

        // your code here
        return vowelsCount;
    }
}
