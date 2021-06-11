package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 스택 수열
 * Created by qkrtjdcjf124
 * Date : 2021/06/11
 */
public class BJoon1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<Integer>();
		
		int N = Integer.parseInt(bf.readLine());
		int num = Integer.parseInt(bf.readLine());
		int cnt = 0;
		
		for(int i=1; i<=N; i++) {
			s.push(i);
			sb.append("+" + "\n");
			
			while(!s.empty() && s.peek() == num) {
				s.pop();
				sb.append("-" + "\n");
				cnt++;
				
				if(cnt != N) num = Integer.parseInt(bf.readLine());
			}
		}
		
		if(s.empty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}

}
