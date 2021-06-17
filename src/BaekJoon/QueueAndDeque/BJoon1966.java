package BaekJoon.QueueAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 프린터 큐
 * Created by qkrtjdcjf124
 * Date : 2021/06/17
 */
public class BJoon1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			int len = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			if(len == 1) sb.append(1 + "\n");
			else {
				for(int j=0; j<len; j++) {
					q.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
	}

}
