package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* A + B - 4
 * Created by qkrtjdcjf124
 * Date : 2021/06/04
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a, b;
		
		for(int i=0; i<6; i++) {
			String txt = bf.readLine();
			if(txt.equals("")) System.out.println(1);
			else System.out.println(2);
		}
		
//		while(st.hasMoreTokens()) {
//			a = Integer.parseInt(st.nextToken());
//			b = Integer.parseInt(st.nextToken());
//			
//			sb.append(a + b + "\n");
//			
//			st = new StringTokenizer(bf.readLine());
//		}
		
//		System.out.println(sb);
	}
}
