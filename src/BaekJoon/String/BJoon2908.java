package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 상수
 * Created by qkrtjdcjf124
 * Date : 2021/06/16/
 */
public class BJoon2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		String[] a_t = st.nextToken().split("");
		String a = a_t[2] + a_t[1] + a_t[0];
		
		a_t = st.nextToken().split("");
		String b = a_t[2] + a_t[1] + a_t[0];
		
		if (Integer.parseInt(a) > Integer.parseInt(b)) System.out.println(a);
		else System.out.println(b);
	}

}
