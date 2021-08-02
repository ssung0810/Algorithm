package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		HashMap<String, Integer> h = new HashMap<>();
		for(int num=2; num<=s.length()/2; num++) {
			for(int st=0; st+num<=s.length(); st++) {
				String txt = s.substring(st, st+num);
				if(h.containsKey(txt)) {
					h.put(txt, h.get(txt) + 1);
					st += num;
				} else {
					h.put(txt, 1);
				}
				
			}
		}
		
		for(String key : h.keySet()) {
			System.out.println(key + " :: " + h.get(key));
		}
		
//		String t = "abcde";
//		System.out.println(t.substring(1, 2));
	}

}
