package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 전깃줄
 * Created by qkrtjdcjf124
 * Date : 2021/05/26
 */
public class BJoon2565 {
	static int[][] line;
	static Integer[] dp;
	static int max=0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		line = new int[N][2];
		dp = new Integer[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				return e1[0] - e2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			LIS(i);
		}
		
		System.out.println(N-max);
	}

	static int LIS(int N) {
		if(dp[N] == null) {
			dp[N] = 1;

			for(int i=N-1; i>=0; i--) {
				if(line[N][1] > line[i][1]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
			
			max = Math.max(max, dp[N]);
		}
		
		return dp[N];
	}
}
