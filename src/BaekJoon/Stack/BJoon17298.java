package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

/* 오큰수
 * Created by qkrtjdcjf124
 * Date : 2021/06/11
 */
public class BJoon17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Integer> s = new Stack<>();
		
		int N = Integer.parseInt(bf.readLine());
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			s.push(Integer.parseInt(st.nextToken()));
		}
		
		
		
		System.out.println(sb);
	}

}
