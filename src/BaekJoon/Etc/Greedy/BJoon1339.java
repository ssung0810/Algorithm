package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 단어 수학
 * Date : 2021/11/17
 */
public class BJoon1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] words = new String[N];
        for(int i=0; i<N; i++) {
            words[i] = bf.readLine();
        }

        int[] alpha = new int[26];

        for(int i=0; i< words.length; i++) {
            int temp = (int) Math.pow(10, words[i].length()-1);

            for(int j=0; j<words[i].length(); j++) {
                alpha[words[i].charAt(j)-65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha);

        int num = 9;
        int answer = 0;
        for(int i=alpha.length-1; i>=0; i--) {
            if(alpha[i] == 0) break;
            answer += alpha[i]*num;
            num--;
        }

        System.out.println(answer);
    }
}
