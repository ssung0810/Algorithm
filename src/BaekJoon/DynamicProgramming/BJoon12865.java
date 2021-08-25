package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 평범한 배낭
 * Created by qkrtjdcjf124
 * Date : 2021/08/25
 */
public class BJoon12865 {
	static int[][] bag;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		bag = new int[N][2];
		dp = new Integer[N][max+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = 0;



//		System.out.println(BestValue(N-1, max));
	}
	
//	static int BestValue(int i, int k) {
//		if(i < 0) return 0;
//
//		if(dp[i][k] == null) {
//			if(bag[i][0] > k) dp[i][k] = BestValue(i-1, k);
//			else dp[i][k] = Math.max(BestValue(i-1, k), BestValue(i-1, k-bag[i][0]) + bag[i][1]);
//		}
//
//		return dp[i][k];
//	}
}
