package BaekJoon.Etc.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 카드 구매하기
 * Date : 2022/07/07
 */
public class BJoon11052 {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

//        dp = new int[1001];
//        dp[1] = P[0];

        int answer = 0;
        for (int i = 1; i <= N / 2; i++) {
            answer = Math.max(answer, P[i] + P[N - i]);
        }

        System.out.println(answer);
    }
}
