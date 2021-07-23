package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 3진법 뒤집기
 * Date : 2021/07/23
 */
public class Triangulation {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int answer = 0;
        String txt = "";
        
        while(n - 1 > -1) {
            txt += n%3;
            n /= 3;
        }
        
        int num = 1;
        for(int i=txt.length()-1; i>=0; i--) {
            answer += (txt.charAt(i)-'0') * num;
            num *= 3;
        }
        
        System.out.println(answer);
	}

}
