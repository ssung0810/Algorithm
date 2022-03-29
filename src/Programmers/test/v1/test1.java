package Programmers.test.v1;

import java.util.Stack;

/* 다트 게임
 * Date : 2022/03/28
 */
public class test1 {

    public static void main(String[] args) {
        String dartResult = "1D2S#10S";

        int answer = solution(dartResult);

        System.out.println(answer);
    }

    public static int solution(String dartResult) {
        int answer = 0;

        int[] num = new int[3];
        int flag = -1;

        for (int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if(c == 'S' || c == 'D' || c == 'T') {
                num[flag] = bonusScore(num[flag], c);
            } else if(c == '*' || c == '#') {
                num[flag] = optionScore(num[flag], c);

                if (c == '*' && flag > 0) num[flag-1] = num[flag-1] * 2;
            } else {
                flag++;

                if(dartResult.charAt(i+1) == '0') {
                    String n = String.valueOf(c) + "0";
                    num[flag] = Integer.parseInt(n);
                    i++;
                    continue;
                }

                num[flag] = c-'0';
            }
        }

        for (int i : num) {
            answer += i;
        }

        return answer;
    }

    static int bonusScore(int score, char bonus) {
        if (bonus == 'S') {
            return score;
        } else if (bonus == 'D') {
            return (int) Math.pow(score, 2);
        } else if (bonus == 'T') {
            return (int) Math.pow(score, 3);
        }

        return 0;
    }

    static int optionScore(int score, char option) {
        if (option == '*') {
            return score * 2;
        } else if (option == '#') {
            return score * -1;
        }

        return 0;
    }
}
