package warmup;

public class yaksuMain {
    public static void solution(int n) {
        int answer = 0;

        //약수를 구하는 알고리즘
        for(int i=1; i<= n ; i ++) {
            if( n % i == 0) {
                System.out.println(i);
                answer +=i;
            }
        }

        System.out.println("result " + answer);
    }

    public static void stringToInt(String s) {
        int answer = 0;

        int i=0;
        int result =0;
        boolean negative = false;
        int radix = 10;
        char firstChar = s.charAt(0);

        if( firstChar < '0') {
            negative = true;
            i++; //음수의 경우 한칸 부호 다음부터 계산한다.
        }

        while (i < s.length()) {
            int digit = Character.digit(s.charAt(i++), radix);
            result *= 10; //자릿수를 이동한다.
            result -= digit; //이 값을 모르겠음.
        }

        answer = negative ? result : -result;
        System.out.println(answer);
    }


    public static void main(String[] args) {
        stringToInt("-1234");
        solution(5);//약수의 합을 구하는 방식
    }
}

