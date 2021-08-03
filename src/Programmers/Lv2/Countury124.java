package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 124 나라의 숫자
 * Date : 2021/08/03
 */
public class Countury124 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		////////////////////////////
		
		String answer = "";
		
		while(n > 0) {
			switch(n % 3) {
				case 1: 
					answer = 1 + answer;
					n /= 3;
				break;
				case 2: 
					answer = 2 + answer;
					n /= 3;
				break;
				case 0: 
					answer = 4 + answer;
					n = n / 3 - 1 ;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
