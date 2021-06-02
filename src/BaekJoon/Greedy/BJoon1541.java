package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 잃어버린 괄호
 * Created by qkrtjdcjf124
 * Date : 2021/06/02
 */
public class BJoon1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), "-+", true);
		
		String[] txt = new String[st.countTokens()];
		boolean minus = false;
		int sum = 0;
		int excep = 0;
		
		for(int i=0; i<txt.length; i++) {
			txt[i] = st.nextToken();
		}
		
		for(int i=0; i<txt.length; i++) {
			if(txt[i].equals("-")) {
				minus = true;
			}
			
			if(minus && (i == txt.length-1 || txt[i+1].equals("-"))) {
				excep += Integer.parseInt(txt[i]);
				sum -= excep;
				excep = 0;
				minus = false;
			} else if(minus && i%2 == 0) {
				excep += Integer.parseInt(txt[i]);
			} else if(!minus && i%2 == 0) {
				sum += Integer.parseInt(txt[i]);
			}
		}
		
		System.out.println(sum);
	}
}
