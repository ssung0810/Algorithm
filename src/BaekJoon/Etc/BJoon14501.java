package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 퇴사(다이나믹프로그래밍)
 * Date : 2021/09/02
 */
public class BJoon14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());

        int[][] work = new int[N+10][2];
        int[] dp = new int[N+10];
        int max = 0;

        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(bf.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N+1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[i+work[i][0]] = Math.max(dp[i+work[i][0]], dp[i] + work[i][1]);
            max = dp[i];
        }

        System.out.println(max);
    }
}
