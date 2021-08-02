package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 짝지어 제거하기
 * Date : 2021/08/02
 */
public class PairRemove {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		
		/////////////////////////////////
		
		int answer = 0;
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			if(st.isEmpty()) {
				st.push(s.charAt(i));
			} else {
				if(st.peek() == s.charAt(i)) {
					st.pop();
				} else {
					st.push(s.charAt(i));
				}
			}
		}
		
		answer = st.isEmpty() ? 1 : 0;
		
		System.out.println(answer);
	}

}
