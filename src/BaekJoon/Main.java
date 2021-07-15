package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] stair;
	static Integer[][] dp;
	static int N;
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		stair = new int[N][N];
		dp = new Integer[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			int cnt = 0;
			while(st.hasMoreTokens()) {
				stair[i][cnt] = Integer.parseInt(st.nextToken());
				cnt++;
			}
		}
		
		dp[0][0] = stair[0][0];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, maximum(N-1, i));
		}
		
		System.out.println(max);
	}
	
	static int maximum(int row, int col) {
		if(dp[row][col] == null) {
			if(col == 0) {
				dp[row][col] = stair[row][col] + maximum(row-1, col);
			} else if(row == col) {
				dp[row][col] = stair[row][col] + maximum(row-1, col-1);
			} else {
				dp[row][col] = stair[row][col] + Math.max(maximum(row-1, col-1), maximum(row-1, col));
			}
		}
		
		return dp[row][col];
	}
}
