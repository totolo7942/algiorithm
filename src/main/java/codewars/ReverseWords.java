package codewars;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWords {
    public static String reverseWords(final String original) {
        // Have at it

        if(original.isBlank())
            return original;

        String[] orgStrings = original.split(" ");
        StringBuilder sb = new StringBuilder();
        int endIdx = 0;
        for(String string : orgStrings){
            char[] attr = string.toCharArray();
            for( int i = attr .length-1; i >= 0; i-- ) {
                sb.append(attr[i]);
            }

            if( endIdx != orgStrings.length-1)
                sb.append(" ");

            endIdx++;
        }

        return sb.toString();
    }

    public static String reverseWordsAnother(final String original) {
        if(original.trim().isEmpty()) {
            return original;
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (String word : original.split(" ")) {
            joiner.add(new StringBuilder(word).reverse().toString());
        }
        return joiner.toString();
    }

    public static String reverseWords2(final String original) {
        return original.trim().isEmpty() ? original : Stream.of(original.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));
    }

    public static String reverseWords3(final String original) {
        String[] array = original.split(" ");
        if(array.length == 0)
            return original;

        int i = 0;
        for(String string : array){
            array[i] = new StringBuilder(string).reverse().toString();
            i++;
        }

        return String.join(" ",array);
    }

    //https://www.codewars.com/kata/5259b20d6021e9e14c0010d4/solutions/java/all/best_practices
    public static void main(String[] args) {
        String ret = reverseWords("a b c d e");
        System.out.println("a b c d e = " + "["+ret+"]");

        ret = reverseWords("The quick brown fox jumps over the lazy dog.");
        System.out.println("ehT kciuq nworb xof spmuj revo eht yzal .god = " + "["+ret+"]");

        ret = reverseWords("double  spaces");
        System.out.println("double  spaces = " + "["+ret+"]");

        ret = reverseWords("     ");
        System.out.println("all spaces = " + "["+ret+"]");
    }
}
