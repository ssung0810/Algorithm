package BaekJoon.DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 토마토
 * Date : 2021/08/06
 */
public class BJoon7576 {
	static int[][] farm;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Queue<Tomato> q = new LinkedList<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		farm = new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				farm[i][j] = tomato;
				
				if(tomato == 1) q.offer(new Tomato(i, j));
			}
		}
		
		bfs(q);
		
		int max = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(farm[i][j] > 0) {
					max = Math.max(max, farm[i][j]);
				} else if(farm[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(max - 1);
	}

	static void bfs(Queue<Tomato> q) {
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			int x = t.x;
			int y = t.y;
			
			// 위쪽 체크
			if(x-1 >= 0 && farm[x-1][y] == 0) {
				farm[x-1][y] = farm[x][y] + 1;
				q.offer(new Tomato(x-1, y));
			}
			
			// 오른쪽 체크
			if(y+1 < N && farm[x][y+1] == 0) {
				farm[x][y+1] = farm[x][y] + 1;
				q.offer(new Tomato(x, y+1));
			}
			
			// 아래쪽 체크
			if(x+1 < M && farm[x+1][y] == 0) {
				farm[x+1][y] = farm[x][y] + 1;
				q.offer(new Tomato(x+1, y));
			}
			
			// 왼쪽 체크
			if(y-1 >= 0 && farm[x][y-1] == 0) {
				farm[x][y-1] = farm[x][y] + 1;
				q.offer(new Tomato(x, y-1));
			}
		}
	}
	
}

class Tomato {
	int x;
	int y;
	
	Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
