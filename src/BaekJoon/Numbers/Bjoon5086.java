package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 배수와 약수
 * Created by qkrtjdcjf124
 * Date : 2021/06/03
 */
public class Bjoon5086 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st =  new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==0 && b==0) break;
			
			if(b % a == 0) {
				sb.append("factor" + "\n");
			} else if(a % b == 0) {
				sb.append("multiple" + "\n");
			} else {
				sb.append("neither" + "\n");
			}
		}
		
		System.out.println(sb);
	}

}
