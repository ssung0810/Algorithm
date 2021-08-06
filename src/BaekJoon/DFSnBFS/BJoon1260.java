package BaekJoon.DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJoon1260 {
	static boolean[][] line;
	static boolean[] visit;
	static String dfsTxt = "";
	static String bfsTxt = "";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		line = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			line[a][b] = true;
			line[b][a] = true;
		}
		
		dfsTxt += V + " ";
		visit[V] = true;
		dfs(V, N+1);
		
		bfsTxt += V + " ";
		bfs(V, N+1);
		
		System.out.println(dfsTxt);
		System.out.println(bfsTxt);
	}
	
	static void bfs(int V, int len) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		visit[V] = false;
		
		while(q.size() > 0) {
			int start = q.poll();
			for(int i=1; i<len; i++) {
				if(line[start][i] && visit[i]) {
					visit[i] = false;
					
					q.offer(i);
					bfsTxt += i + " ";
				}
			}
		}
	}

	static void dfs(int d, int len) {
		for(int i=1; i<len; i++) {
			if(line[d][i] && visit[i] == false) {
				visit[i] = true;
				
				dfsTxt += i + " ";
				dfs(i, len);
			}
		}
	}
}
