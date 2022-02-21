package warmup;

import java.util.ArrayList;
import java.util.Arrays;

public class MiddleExamTestMain {
    public static int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        int[] scores = {0,0,0}; // 수포자들 답 맞은 개수
        // 비교
        for(int i = 0; i < answers.length; i++){
            if(first[i % 5] == answers[i]){ scores[0]++;}
            if(second[i % 8] == answers[i]){ scores[1]++;}
            if(third[i % 10] == answers[i]){ scores[2]++;}
        }

        int[] arr = new int[scores.length];
        System.arraycopy(scores, 0, arr, 0, scores.length);

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(scores[i] == arr[2]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = new int[] { 1,2,3,4,5};
        int[] ret = solution(answer);
        System.out.println(Arrays.toString(ret));
    }
}
