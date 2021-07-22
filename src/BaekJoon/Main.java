package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[] result;
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		result = new int[M];
		
		dfs(N, 0, M, 0);
		
		System.out.println(sb);
	}
	
	static void dfs(int N, int D, int M, int s) {
		if(M == D) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=s; i<N; i++) {
//			if(!visit[i]) {
				result[D] = i+1;
				visit[i] = true;
				dfs(N, D+1, M, i);
				visit[i] = false;
//			}
		}
	}
}
