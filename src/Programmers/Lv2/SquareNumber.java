package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 멀쩡한 사각형
 * Date : 2021/08/03
 */
public class SquareNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int w = Integer.parseInt(bf.readLine());
		int h = Integer.parseInt(bf.readLine());
		
		///////////////////////////
		
		long answer = 1;
		
		int w_even = 0;
		int h_even = 0;
		
		if(w % 2 == 0) {
			w_even = 1;
			w -= 1;
		}
		if(h % 2 == 0) {
			h_even = 1;
			h -= 1;
		}
		
//		int result = split(w/2, h/2);
	}

//	static int split(int w, int h) {
//		
//	}
}
