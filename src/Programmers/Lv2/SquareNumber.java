package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 멀쩡한 사각형
 * Date : 2021/09/08
 */
public class SquareNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int w = Integer.parseInt(bf.readLine());
		int h = Integer.parseInt(bf.readLine());
		
		///////////////////////////

		int black = 0;
		if(w == h) {
			black = w;
		} else {
			int a = Math.max(w, h);
			int b = Math.min(w, h);
			int r = 0;

			while(b != 0) {
				r = a % b;
				a = b;
				b = r;
			}

			int W = w, H = h;
			if(a != 1) {
				W = w/a;
				H = h/a;
			}

			black = (W+H-1)*a;
		}

		long answer = (long)w*(long)h - black;

		System.out.println(answer);
	}
}
