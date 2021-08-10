package BaekJoon.DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 벽 부수고 이동하기
 * Created by qkrtjdcjf124
 * Date : 2021/08/06
 */
public class BJoon2206 {
	static long startTime = System.currentTimeMillis();
	
	static int N, M, maze[][];
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String txt = bf.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = Integer.parseInt(txt.split("")[j]);
			}
		}
		
		bfs();
		
		if(maze[N-1][M-1] == 0) System.out.println(-1);
		else System.out.println(maze[N-1][M-1]);
		
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
	}

	public static void bfs() {
		Queue<MAP> q = new LinkedList<MAP>();
		q.add(new MAP(0, 0, 0));
		int[] mx = {1, 0, -1, 0};
		int[] my = {0, 1, 0, -1};
		maze[0][0] = 1;
		int a,b,c;
		
		while(!q.isEmpty()) {
			MAP m = q.poll();
			
			for(int i=0; i<4; i++) {
				if(m.x == N-1 && m.y == M-1) return;
				
				a = m.x + mx[i];
				b = m.y + my[i];
				c = m.crash;
				
				if(a < 0 || b < 0 || a >= N || b >= M) continue;
				
				int ck = maze[a][b];
				if(c == 0 && (ck == 0 || ck == 1)) {
					if(ck == 1) {
						q.add(new MAP(a, b, 1));
						maze[a][b] = maze[m.x][m.y] + 1;
					} else {
						q.add(new MAP(a, b, 0));
						maze[a][b] = maze[m.x][m.y] + 1;
					}
				} else if(c == 1 && ck == 0) {
					q.add(new MAP(a, b, 1));
					maze[a][b] = maze[m.x][m.y] + 1;
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