package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 카쳇
 * Date : 2021/10/06
 */
public class Carpet {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int brown = Integer.parseInt(st.nextToken());
        int yellow = Integer.parseInt(st.nextToken());

        ////////////////////////////////////////////////

        int[] answer = new int[2];

        for(int i=1; i<=yellow; i++) {
            if(yellow%i == 0 && (yellow/i)+i+2 == brown/2) {
                int a = yellow/i+2;
                int b = i+2;
                answer[0] = Math.max(a, b);
                answer[1] = Math.min(a, b);

                break;
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
