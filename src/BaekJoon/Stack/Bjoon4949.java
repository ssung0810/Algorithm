package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bjoon4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<Character>();
		
		String txt;
		while( !(txt = bf.readLine()).equals(".") ) {
			String result = "yes";
			
			for(char c : txt.toCharArray()) {
				if(c == '[' || c == '(') {
					s.push(c);
				} else if(c == ']') {
					if(s.empty() || s.pop() != '[') {
						result = "no";
						break;
					}
				} else if(c == ')') {
					if(s.empty() || s.pop() != '(') {
						result = "no";
						break;
					}
				}
			}
			if(!s.empty()) result = "no";
			sb.append(result + "\n");
			s.clear();
		}
		
		System.out.println(sb);
	}

}
