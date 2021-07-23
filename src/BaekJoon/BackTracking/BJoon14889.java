package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJoon14889 {
	static int[][] team;
	static int min = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int M = N/2;
		team = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0; j<N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(N, M, 0);
		
		System.out.println(min);
	}

	static void dfs(int N, int M, int D) {
		if(M == D) {
			power(N);
			return;
		}
		
		for(int i=D; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(N, M, D+1);
				visit[i] = false;
			}
		}
	}
	
	static void power(int N) {
		int start_sum = 0;
		int link_sum = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visit[i] == true && visit[j] == true) {
					start_sum += team[i][j];
					start_sum += team[j][i];
				} else if(visit[i] == false && visit[j] == false) {
					link_sum += team[i][j];
					link_sum += team[j][i];
				}
			}
		}

		int result = Math.abs(start_sum - link_sum);
		if(result == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		min = Math.min(min, result);
	}
}
