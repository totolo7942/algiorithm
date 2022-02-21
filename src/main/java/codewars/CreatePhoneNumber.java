package codewars;

import java.util.Arrays;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");
        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }


        StringBuilder sNumber = new StringBuilder();
        for (int i : numbers) {
            sNumber.append(i);
        }
        phoneNumber = sNumber.toString().replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "($1) $2-$3");
        return phoneNumber;
    }

    public static void main(String[] args) {
        String number = createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}); // => returns "(123) 456-7890"
        System.out.println(number);
    }

}
