package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1, 2, 3 더하기
 * Date : 2021/08/30
 */
public class BJoon9095 {
    static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=0; i<N; i++) {
            int M = Integer.parseInt(bf.readLine());

            sb.append(sum(M) + "\n");
        }

        System.out.println(sb);
    }

    static int sum(int N) {
        if(dp[N] == 0) {
            dp[N] = sum(N-1) + sum(N-2) + sum(N-3);
        }

        return dp[N];
    }
}
