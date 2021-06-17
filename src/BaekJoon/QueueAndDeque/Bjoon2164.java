package BaekJoon.QueueAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 카드 2
 * Created by qkrtjdcjf124
 * Date : 2021/06/17
 */
public class Bjoon2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(q.size() > 1) {
			q.remove();
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
	}

}
