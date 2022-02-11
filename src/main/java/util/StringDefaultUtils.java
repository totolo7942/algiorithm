package util;

public class StringDefaultUtils {
    public static void main(String[] args) {
        boolean  v = checkEmptyValue( " " , "d");
        System.out.println(v); //true

        v = checkEmptyValue( "a" , "");
        System.out.println(v); //true

        v = checkEmptyValue( "a" , "b");
        System.out.println(v); // false

        v = checkEmptyValue( "a" , "b", "");
        System.out.println(v); //true

    }

    private static boolean checkEmptyValue(String ... strings){
        for( String s : strings) {
            if( s.isBlank())
                return true;
        }
        return false;
    }
}
