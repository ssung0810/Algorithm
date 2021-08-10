package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 캠핑
 * Date : 2021/08/10
 */
public class BJoon4796 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int cnt = 1;
		
		while(true) {
			st = new StringTokenizer(bf.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int answer = 0;
			
			if(a == 0 && b == 0 && c == 0) break;
			
			sb.append("Case " + cnt + ": ");
			
			if(c % b <= a) {
				answer = (c / b) * a + (c % b);
			} else {
				answer = (c / b) * a + a;
			}
			
			sb.append(answer + "\n");
			cnt++;
		}
		
		System.out.println(sb);
	}

}
