package codewars;

import java.util.stream.IntStream;

/**
 * 3 또는 5의 배수인 10 미만의 모든 자연수를 나열하면 3, 5, 6, 9가 됩니다. 이 배수의 합은 23입니다.
 *
 * 전달된 숫자 아래 의 3 또는 5의 모든 배수의 합계를 반환하도록 솔루션을 완료합니다 . 또한 숫자가 음수이면 0을 반환합니다(이가 있는 언어의 경우).
 *
 * 참고: 숫자가 3 과 5 의 배수 이면 한 번만 계산합니다 .
 */
public class MultiplesOf3Or5 {

        public static int solution(int number) {
            //TODO: Code stuff here

            int sum = 0;
            for(int i =1; i < number; i ++) {
                if( i % 3 == 0 || i % 5 == 0) {
                    sum += i;
                }
            }

            sum = IntStream.range(0, number)
                    .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                    .sum();

            return sum;
        }

    public static void main(String[] args) {
        int ret = solution(10);
        System.out.println(ret != 23 ? "Fails " + ret : "Success");

        ret = solution(20);
        System.out.println(ret != 78 ? "Fails " + ret : "Success");


        ret = solution(200);
        System.out.println(ret != 9168 ? "Fails " + ret : "Success");

    }
}
