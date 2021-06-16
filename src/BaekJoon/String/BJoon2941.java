package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 크로아티아 알파벳
 * Created by qkrtjdcjf124
 * Date : 2021/06/16
 */
public class BJoon2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String txt = bf.readLine();
		int cnt = 0;
		
		for(int i=0; i<txt.length(); i++) {
			if(txt.charAt(i) == 'c' && i < txt.length()-1) {
				if(txt.charAt(i+1) == '=') {
					i++;
				} else if(txt.charAt(i+1) == '-') {
					i++;
				}
			} else if(txt.charAt(i) == 'd' && i < txt.length()-1) {
				if(txt.charAt(i+1) == '-') {
					i++;
				} else if(txt.charAt(i+1) == 'z' && i < txt.length()-2) {
					if(txt.charAt(i+2) == '=') {
						i += 2;
					}
				}
			} else if(txt.charAt(i) == 'l' && i < txt.length()-1 && txt.charAt(i+1) == 'j') {
				i++;
			} else if(txt.charAt(i) == 'n' && i < txt.length()-1 && txt.charAt(i+1) == 'j') {
				i++;
			} else if(txt.charAt(i) == 's' && i < txt.length()-1 && txt.charAt(i+1) == '=') {
				i++;
			} else if(txt.charAt(i) == 'z' && i < txt.length()-1 && txt.charAt(i+1) == '=') {
				i++;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
