package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 조이스틱
 * Date : 2021/08/10
 */
public class JoyStick {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String name = bf.readLine();
		
		///////////////////////////
		
		int answer = 0;
		int[] dp = new int[name.length()+1];
		int cnt = 0;
		
		// 맨 앞에서부터 맨 뒤까지
		for(int i=0; i<name.length(); i++) {
			int num = name.charAt(i) - 65;
			
			if(num == 1) {
				
			} else if(num <= 13) {
				answer += num + cnt;
				dp[i] = num;
				cnt = 0;
			} else {
				answer += (26-num) + cnt;
				dp[i] = 26-num;
				cnt = 0;
			}
			
			cnt++;
		}
		
		// 맨 뒤에서부터 맨 앞까지
		for(int i=name.length()-1; i>=0; i++) {
			
		}
		
		System.out.println(answer);
	}

}
