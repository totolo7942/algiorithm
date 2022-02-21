package recursion;

/**
 * Problem: https://www.hackerrank.com/challenges/30-binary-numbers/problem
 */
public class DecimalSearch {
    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static void main(String[] args) {
        int value = 19111;

        int ret = decimalBinarySearch(value);
        System.out.println(ret);

        int ret1 = orderBinarySearch(value);
        System.out.println(ret1);
    }

    //정답
    static int decimalBinarySearch(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        int maxcount = 0;
        for (char c : binary.toCharArray()) {
            count = (c == '1') ? count + 1 : 0;
            if (count > maxcount)
                maxcount = count;

        }


        return maxcount;
    }

    //에러가 발생함
    static int orderBinarySearch(int n) {
        int count = 0;
        int maxcount = 0;

        while (n > 0) {
            count = (n % 2) == 1 ? count + 1 : (count > maxcount) ? count : 0;
            n /= 2;
        }

        if (count > maxcount)
            maxcount = count;

        return maxcount;
    }

    private static String toUnsignedString0(int val, int shift) {
        // assert shift > 0 && shift <=5 : "Illegal shift value";
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];

        formatUnsignedInt(val, shift, buf, 0, chars);

        // Use special constructor which takes over "buf".
        return new String(buf);
    }

    private static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = digits[val & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }


}
