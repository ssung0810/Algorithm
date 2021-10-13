package Programmers.WeeklyChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 모음사전
 * Date : 2021/10/10
 */
public class week5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();

        ////////////////////////////////////////////////

        int answer = 1;
        int[] result = new int[6];

        String problem = "";
        for(int i=0; i<word.length(); i++) {
            switch(word.charAt(i)) {
                case 'A': problem += 1; break;
                case 'E': problem += 2; break;
                case 'I': problem += 3; break;
                case 'O': problem += 4; break;
                case 'U': problem += 5; break;
            }
        }

        result[0] = 1;
        int focus = 0;
        while(ck(problem, result)) {
            // focus가 마지막일 때
            if(focus == 4) {
                // 번호가 마지막일 때
                if(result[focus] == 5) {
                    result[focus] = 0;
                    focus--;
                    result[focus]++;
                    while(result[focus] == 6) {
                        result[focus] = 0;
                        focus--;
                        result[focus]++;
                    }
                } else {
                    result[focus]++;
                }
            }
            // focus가 마지막이 아닐 때
            else {
                focus++;
                result[focus]++;
            }

            answer++;
        }

        System.out.println(answer);
    }

    static boolean ck(String word, int[] result) {
        String txt = "";
        for(int i=0; i<result.length-1; i++) {
            if(result[i] == 0) break;

            txt += result[i];
        }

        return !word.equals(txt);
    }
}