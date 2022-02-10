package codewars;


public class RemoveFirstAndListCharacter {

    public static String remove(String str) {
        // your code here
        return (str != null && str.length()> 0) ? str.substring(1, str.length()-1) : "";
    }

    public static void main(String[] args) {
        System.out.println(remove("eloquent"));

        System.out.println(remove(""));
    }
}
