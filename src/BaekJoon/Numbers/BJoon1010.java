package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 다리 놓기
 * Created by qkrtjdcjt124
 * Date : 2021/07/13
 */
public class BJoon1010 {
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int n,k;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			k = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			sb.append(bridge(n, k) + "\n");
		}
				
		System.out.println(sb);
	}

	static int bridge(int n, int k) {
		if(n == k) return 1;
		else if(k == 1) return n;
		
		if(dp[n][k] == 0) {
			dp[n][k] = bridge(n-1, k) + bridge(n-1, k-1);
		}
		
		return dp[n][k];
	}
}
