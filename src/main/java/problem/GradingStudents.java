package problem;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/grading/problem
/*
80
96
18
75
80
60
60
15
45
15
10
5
46
87
33
60
14
71
65
2
[80, 96, 18, 75, 80, 60, 60, 15, 45, 15, 10, 5, 46, 87, 33, 60, 14, 71, 65, 2, 5, 97, 0]

 */
public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> result = new ArrayList<>();
        //다음 5의 배수 값을 찾아냄
        for( Integer v1 : grades) {

            int modVal = 0;
            if( v1 % 5 > 0)
                modVal = ((v1 % 5) - 5) * -1 + v1;
            else
                modVal = v1 + 3;

            if( v1 < 38)  {
                result.add(v1);
                continue;
            }

            if( modVal - v1  < 3 )
                result.add(modVal);
            else if ( modVal - v1 == 3 )
                result.add(v1);
            else
                result.add(v1);
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> students = List.of(
                80,
                96,
                18,
                73,
                78,
                60,
                60,
                15,
                45,
                15,
                10,
                5,
                46,
                87,
                33,
                60,
                14,
                71,
                65,
                2,
                5,
                97,
                0);

        List<Integer> gradls = gradingStudents(students);
        System.out.println(gradls);

    }
}
