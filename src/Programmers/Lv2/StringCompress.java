package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 문자열 압축
 * Date : 2021/07/31
 */
public class StringCompress {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		
		///////////////////////////////////
		
		int answer = 0;
		int len = s.length();
		int cnt = 0;
		int max = len-1;
		ArrayList<String> arr = new ArrayList<>();

		for(int i=2; i<=len/2; i++) {
			String txt = roop(i, s);
			answer = Math.max(max, txt.length());

			System.out.println(txt);
		}

		System.out.println(answer);
	}

	static String roop(int cnt, String s) {
		String answer = "";
		int ck = 1;

		for(int i=0; i<s.length()-cnt+1; i++) {
			int num = i+cnt;

			if(num+cnt < s.length() && s.substring(i, i+cnt).equals(s.substring(num, num+cnt))) {
				ck++;
				i += cnt - 1;
				continue;
			} else {
				if(ck == 1) answer += s.charAt(i);
				else answer += ck + s.substring(i, i+cnt);

				ck = 1;
			}
		}

		return answer;
	}
}

