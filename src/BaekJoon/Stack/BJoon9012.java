package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 괄호
 * Created by qkrtjdcjf124
 * Date : 2021/06/10
 */
public class BJoon9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<Integer>();
		
		int N = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<N; i++) {
			String result = "YES";
			String[] arr = bf.readLine().split("");
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j].equals("(")) {
					s.push(1);
				} else if(arr[j].equals(")") && s.size() > 0) {
					s.pop();
				} else if(arr[j].equals(")") && s.size() == 0) {
					result = "NO";
					break;
				}
			}
			if(s.size() > 0) result = "NO";
			sb.append(result + "\n");
			s.clear();
		}
		
		System.out.println(sb);
	}

}
