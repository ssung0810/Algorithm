package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 오큰수
 * Created by qkrtjdcjf124
 * Date : 2021/06/14
 */
public class BJoon17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Integer> s = new Stack<>();
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		s.push(0);
		for(int i=1; i<N; i++) {
			if(arr[s.peek()] >= arr[i]) {
				s.push(i);
			} else {
				while(!s.empty() && arr[s.peek()] < arr[i]) {
					arr[s.pop()] = arr[i];
				}
				
				s.push(i);
			}
		}
		
		while(!s.empty()) {
			arr[s.pop()] = -1;
		}
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
	}

}
