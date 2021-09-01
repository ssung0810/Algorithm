package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 쉬운 계단 수
 * Date : 2021/09/01
 */
public class BJoon10844 {
    static Long[][] dp;
    final static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        dp = new Long[N+1][10];

        for(int i=0; i<10; i++) {
            dp[1][i] = 1L;
        }

        long answer = 0;

        for(int i=1; i<10; i++) {
            answer += stair(N, i);
        }

        System.out.println(answer % mod);
    }

    static long stair(int digit, int val) {
        if(digit == 1) {
            return dp[digit][val];
        }

        if(dp[digit][val] == null) {
            if(val == 0) {
                dp[digit][val] = stair(digit-1, 1);
            } else if(val == 9) {
                dp[digit][val] = stair(digit-1, 8);
            } else {
                dp[digit][val] = stair(digit-1, val-1) + stair(digit-1, val+1);
            }
        }

        return dp[digit][val] % mod;
    }
}
