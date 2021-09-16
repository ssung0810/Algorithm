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
		ArrayList<String> arr = new ArrayList<>();

		for(int i=2; i<=len/2; i++) {
			String txt = "";
			for(int j=0; j<len; j++) {
				if(i != 2) {
					if(roop(i, j, s) == 0) {

					}
				} else {


					if(j+1 < len && s.charAt(j) == s.charAt(j+1)) {
						txt += '2'+s.charAt(j);
						i++;
					} else {
						txt += s.charAt(j);
					}
				}
			}

			arr.add(txt);
		}
		
	}

	static int roop(int cnt, int start, String s) {
		int end = 0;
		int r = 0;

		for(int i=start; i<s.length(); i++) {
			int common = 1;

			while(i+cnt*common < s.length() && s.charAt(i) == s.charAt(i+cnt*common)) {
				common++;
			}

			end = common - 1;

			if(r == cnt && end != 1) {

			}
		}

		return r;
	}
}

