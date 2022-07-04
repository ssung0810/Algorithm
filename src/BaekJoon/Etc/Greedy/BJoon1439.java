package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 뒤집기
 * Date : 2022/07/03
 */
public class BJoon1439 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String S = bf.readLine();

        char startNum = S.charAt(0);

        int[] count = new int[2];
        count[startNum-'0'] = 1;

        for (int i = 1; i < S.length(); i++) {
            if (startNum != S.charAt(i)) {
                startNum = S.charAt(i);
                count[startNum-'0']++;
            }
        }

        System.out.println(Math.min(count[0], count[1]));
    }
}
