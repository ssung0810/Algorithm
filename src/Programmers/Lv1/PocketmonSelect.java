package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 폰켓몬
 * Date : 2021/07/13
 */
public class PocketmonSelect {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Queue<Integer> q = new LinkedList<>();
		int num = 0;
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			num = Integer.parseInt(st.nextToken());
			
			if(!q.contains(num)) q.offer(num);
			cnt++;
		}
		
		System.out.println(Math.min(cnt/2, q.size()));
	}

}
