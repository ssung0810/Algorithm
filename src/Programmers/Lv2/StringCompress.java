package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 문자열 압축
 * Date : 2021/12/17
 */
public class StringCompress {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String s = bf.readLine();
		
		///////////////////////////////////
		
		int answer = s.length();

		for(int i=1; i<=s.length()/2; i++) {
			answer = Math.min(compress(s, i).length(), answer);
		}

		System.out.println(answer);
	}

	static String compress(String s, int n) {
		StringBuilder sb = new StringBuilder();
		String txt = "";
		String compress = "";
		int cnt = 1;

		for(int i=0; i<s.length(); i+=n) {

			if(i+n < s.length()) {
				txt = s.substring(i, i + n);
			} else {
				txt = s.substring(i);
			}

			if(i != 0) {
				if(txt.equals(compress)) {
					cnt++;
				} else if(cnt >= 2) {
					sb.append(cnt+compress);
					cnt = 1;
				} else {
					sb.append(compress);
				}
			}

			compress = txt;
		}

		if(cnt >= 2) sb.append(cnt+compress);
		else sb.append(compress);

		return sb.toString();
	}
}

