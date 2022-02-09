package arrays;

/**
 * @author a1101381
 */
public class IntegerReverseMain {

    public static void main(String[] args) {
        int num = 12345678, reversed = 0;
        for(;num != 0; num /= 10) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
        }

//        System.out.println( 21 / 10); // 2
//        System.out.println( 21 % 10); // 1
        System.out.println(reversed);
        System.out.println(reverseInt(reversed));
    }

    private static int reverseInt(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        String reverseStr = stringBuilder.append(num).reverse().toString();
        return Integer.parseInt(reverseStr);
    }
}
