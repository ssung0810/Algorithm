package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 1로 만들기
 * Created by qkrtjdcjf124
 * Date : 2021/05/04
 */
public class BJoon1463 {
	static boolean[] visit;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		visit = new boolean[N+1];
		
		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<one> q = new LinkedList<one>();
		q.add(new one(N, 0));
		visit[N] = true;
		
		while(!q.isEmpty()) {
			one o = q.poll();
			int n = o.num;
			int c = o.count;
			
			if(n < 1) continue;
			else if(n == 1) {
				return c;
			}
			
			for(int i=0; i<3; i++) {
				if(i == 0) {
					if(n % 3 == 0 && visit[n/3] == false) {
						visit[n/3] = true;
						q.add(new one(n/3, c+1));
					}
				} else if(i == 1 && visit[n/2] == false) {
					if(n % 2 == 0) {
						visit[n/2] = true;
						q.add(new one(n/2, c+1));
					}
				} else if(i == 2 && visit[n-1] == false) {
					visit[n-1] = true;
					q.add(new one(n-1, c+1));
				}
			}
		}
		
		return -1;
	}
}

class one {
	int num, count;
	
	one(int num, int count) {
		this.num = num;
		this.count = count;
	}
}