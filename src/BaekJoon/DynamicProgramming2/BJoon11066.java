package BaekJoon.DynamicProgramming2;

import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 파일 합치기
 * Date : 2021/08/28
 */
public class BJoon11066 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());

        for(int i=0; i<N; i++) {
            int M = Integer.parseInt(bf.readLine());

            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr = new int[M];
            dp = new int[M];

            for(int j=0; j<M; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];

            sb.append(file(M-1) + "\n");
        }

        System.out.println(sb);
    }

    static int file(int N) {
        if(dp[N] == 0) {
            if(N % 2 == 0) {
                dp[N] = file(N-1) + arr[N];
            } else {
                dp[N] = 2 * (file(N-2) + arr[N-1] + arr[N]);
            }
        }

        return dp[N];
    }
}
