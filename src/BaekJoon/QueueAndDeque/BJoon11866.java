package BaekJoon.QueueAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 요세푸스 문제 0
 * Created by qkrtjdcjf124
 * Date : 2021/06/17
 */
public class BJoon11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int end = Integer.parseInt(st.nextToken());
		for(int i=1; i<=end; i++) {
			q.offer(i);
		}
		
		int loop = Integer.parseInt(st.nextToken())-1;
		sb.append("<");
		while(q.size() > 0) {
			for(int i=0; i<loop; i++) {
				q.offer(q.poll());
			}
			
			if(q.size() == 1) {
				sb.append(q.poll() + ">");
			} else {
				sb.append(q.poll() + ", ");
			}
		}
				
		System.out.println(sb);
	}

}
