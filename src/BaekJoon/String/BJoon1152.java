package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 단어의 개수
 * Created by qkrtjdcjf124
 * Date : 2021/07/14
 */
public class BJoon1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String txt = bf.readLine().trim();
		int cnt = 1;
		
		for(int i=0; i<txt.length(); i++) {
			if(txt.charAt(i) - '0' == -16) cnt++;
		}
		
		if(txt.length() == 0) System.out.println(0);
		else System.out.println(cnt);
	}

}
