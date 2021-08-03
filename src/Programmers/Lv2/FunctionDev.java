package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 기능개발
 * Date : 2021/08/03
 */
public class FunctionDev {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] progresses = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			progresses[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(bf.readLine());
		int[] speeds = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<M; i++) {
			speeds[i] = Integer.parseInt(st.nextToken());
		}
		
		////////////////////////////////////
		
		int[] answer = {};
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		
		for(int i=0; i<progresses.length; i++) {
			if(progresses[i] < 100) {
				q.offer(cnt);
				cnt = 0;
				
				while(progresses[i] < 100 && i<progresses.length-1) {
					for(int j=0; j<progresses.length; j++) {
						if(progresses[j] >= 100) continue;
						progresses[j] += speeds[j];
					}
				}
			}
			
			cnt++;
		}

		q.offer(cnt);
		q.poll();
		
		int len = q.size();
		answer = new int[len];
		
		for(int i=0; i<len; i++) {
			answer[i] = q.poll();
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
