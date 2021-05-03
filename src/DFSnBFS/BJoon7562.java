package DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 나이트의 이동
 * Created by qkrtjdcjf124
 * Date : 2021/05/01
 */
public class BJoon7562 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] start = new int[2];
		int[] finish = new int[2];
		
		for(int i=0; i<N; i++) {
			int map = Integer.parseInt(bf.readLine());
			
			st = new StringTokenizer(bf.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			finish[0] = Integer.parseInt(st.nextToken());
			finish[1] = Integer.parseInt(st.nextToken());

			if(start[0] == finish[0] && start[1] == finish[1]) sb.append(0 + "\n");
			else bfs(map, start, finish);
		}
		
		System.out.println(sb);
	}
	
	public static void bfs(int map, int[] start, int[] finish) {
		Queue<moving> q = new LinkedList<moving>();
		q.add(new moving(start[0], start[1], 0));
		int[] mx = {-1, 1, 2, 2, 1, -1, -2, -2};
		int[] my = {-2, -2, -1, 1, 2, 2, 1, -1};
		boolean[][] visit = new boolean[map][map];
		int x, y, cnt;
		
		while(!q.isEmpty()) {
			moving m = q.poll();
			
			for(int i=0; i<8; i++) {
				x = m.x + mx[i];
				y = m.y + my[i];
				cnt = m.cnt;
				
				if(x < 0 || y < 0 || x >= map || y >= map) continue;
				
				cnt++;
				if(x == finish[0] && y == finish[1]) {
					sb.append(cnt + "\n");
					return;
				}
				
				if(visit[x][y] == false) {
					visit[x][y] = true;
					q.add(new moving(x, y, cnt));
				}
			}
		}
	}
}

class moving {
	int x, y, cnt;
	
	moving(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
