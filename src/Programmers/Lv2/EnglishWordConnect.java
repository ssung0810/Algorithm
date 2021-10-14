package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/* 영어 끝말잇기
 * Date : 2021/10/14
 */
public class EnglishWordConnect {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String[] words = new String[m];
        for(int i=0; i<m; i++) {
            words[i] = st.nextToken();
        }

        /////////////////////////////////////////////////

        int[] answer = {0, 0};

        HashSet<String> s = new HashSet<>();
        s.add(words[0]);
        char line = words[0].charAt(words[0].length()-1);
        for(int i=1; i<words.length; i++) {
            if(!s.add(words[i]) || line != words[i].charAt(0)) {
                answer[0] = (i+1) % n == 0 ? n : (i+1) % n;
                answer[1] = (i+1) % n == 0 ? (i+1)/n : (i+1)/n + 1;

                break;
            }

            line = words[i].charAt(words[i].length()-1);
        }

        System.out.println(Arrays.toString(answer));
    }
}
