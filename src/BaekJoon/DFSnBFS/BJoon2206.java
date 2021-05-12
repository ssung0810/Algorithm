package BaekJoon.DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 벽 부수고 이동하기
 * Created by qkrtjdcjf124
 * Date : 2021/05/03
 * State : Fail..
 */
public class BJoon2206 {
	static int N, M, maze[][];
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String txt = bf.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = Integer.parseInt(txt.split("")[j]);
			}
		}
		
		bfs(0, 0);
		
		if(maze[N-1][M-1] == 0) System.out.println(-1);
		else System.out.println(maze[N-1][M-1]);
	}

	public static void bfs(int x, int y) {
		Queue<MAP> q = new LinkedList<MAP>();
		q.add(new MAP(x, y, 0));
		int[] mx = {1, 0, -1, 0};
		int[] my = {0, 1, 0, -1};
		visit[0][0] = true;
		maze[0][0] = 1;
		int a,b,c;
		
		while(!q.isEmpty()) {
			MAP m = q.poll();
			
			for(int i=0; i<4; i++) {
				a = m.x + mx[i];
				b = m.y + my[i];
				c = m.crash;
				
				if(a < 0 || b < 0 || a >= N || b >= M) continue;
				
				if(a == N-1 && b == M-1) return;
				
				if(visit[a][b] == false) {
					if(maze[a][b] == 1) {
						if(c == 0) {
							q.add(new MAP(a,b,1));
							visit[a][b] = true;
							maze[a][b] = maze[m.x][m.y] + 1;
						}
					} else {
						q.add(new MAP(a,b,0));
						visit[a][b] = true;
						maze[a][b] = maze[m.x][m.y] + 1;
					}
				}
			}
		}
	}
}

class MAP {
	int x, y, crash;
	
	MAP(int x, int y, int crash) {
		this.x = x;
		this.y = y;
		this.crash = crash;
	}
}