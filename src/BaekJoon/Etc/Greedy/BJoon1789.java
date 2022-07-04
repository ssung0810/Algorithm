package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 수들의 합
 * Date : 2022/07/02
 */
public class BJoon1789 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(bf.readLine());

        long answer = 0;
        for (long i = 1; i <= S; i++) {
            long N = (i*i+i)/2;
            if(N == S) {
                answer = i;
                break;
            } else if(N > S) {
                answer = i-1;
                break;
            }
        }

        System.out.println(answer);
    }
}
