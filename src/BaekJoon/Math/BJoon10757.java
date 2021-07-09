package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 큰 수 A+B
 * Created by qkrtjdcjf124
 * Date : 2021/07/09
 */
public class BJoon10757 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int max_length = Math.max(a.length()+1, b.length()+1);
		
		int[] arr_a = new int[max_length];
		int[] arr_b = new int[max_length];
		
		for(int i=a.length()-1, idx=0; i>=0; i--, idx++) {
			arr_a[idx] = a.charAt(i)-'0';
		}
		
		for(int i=b.length()-1, idx=0; i>=0; i--, idx++) {
			arr_b[idx] = b.charAt(i)-'0';
		}
		
		for(int i=0; i<max_length-1; i++) {
			int sum = arr_a[i] + arr_b[i];
			arr_a[i] = sum % 10;
			arr_a[i+1] += sum / 10;
		}
		
		if(arr_a[max_length-1] != 0) {
			sb.append(arr_a[max_length-1]);
		}
		
		for(int i=max_length-2; i>=0; i--) {
			sb.append(arr_a[i]);
		}
		
		System.out.println(sb);
	}

}
