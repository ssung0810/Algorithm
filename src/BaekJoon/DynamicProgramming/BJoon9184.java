package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJoon9184 {
	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int a,b,c;
		while(true) {
			st = new StringTokenizer(bf.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c==-1) {
				break;
			}
			
			sb.append("w("+a+", "+b+", "+c+") = " + dfs(a, b, c) + "\n");
		}
		
		System.out.println(sb);
	}

	public static int dfs(int a, int b, int c) {
		if(inRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}else if(a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = dfs(20, 20, 20);
		}else if(a < b && b < c) {
			return dp[a][b][c] = dfs(a, b, c-1) + dfs(a, b-1, c-1) - dfs(a, b-1, c);
		} else {
			return dp[a][b][c] = dfs(a-1, b, c) + dfs(a-1, b-1, c) + dfs(a-1, b, c-1) - dfs(a-1, b-1, c-1);
		}
	}
	
	public static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}
}
