package BaekJoon.Etc.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2xn 타일링 2
 * Date : 2022/07/07
 */
public class BJoon11727 {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        dp = new int[n+1];
        dp[1] = 1;
        if(n > 1) dp[2] = 3;


        System.out.println(getResult(n));
    }

    private static int getResult(int n) {
        if (dp[n] == 0) {
            dp[n] = (getResult(n-1) + getResult(n-2) * 2) % 10007;
        }

        return dp[n];
    }
}
