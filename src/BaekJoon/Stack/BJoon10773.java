package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 제로
 * Created by qkrtjdcjf124
 * Date : 2021/06/10
 */
public class BJoon10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		Stack<String> s = new Stack<String>();
		for(int i=0; i<N; i++) {
			String num = bf.readLine();
			
			if(num.equals("0")) {
				s.pop();
			} else {
				s.push(num);
			}
		}
		
		int sum = 0;
		if(s.size() > 0) {
			int size = s.size();
			for(int i=0; i<size; i++) {
				sum += Integer.parseInt(s.pop());
			}
		}
		
		System.out.println(sum);
	}
}
