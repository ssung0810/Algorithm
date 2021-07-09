package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* A + B - 4
 * Created by qkrtjdcjf124
 * Date : 2021/06/04
 */
public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		int[] arr_a = new int[a.length()];
		int[] arr_b = new int[b.length()];
		int[] result = new int[Math.max(a.length(), b.length())];
		int up = 0;
		
		for(int i=0; i<a.length(); i++) {
			arr_a[i] = a.charAt(i)-'0';
		}
		
		for(int i=0; i<b.length(); i++) {
			arr_b[i] = b.charAt(i)-'0';
		}
		
		for(int i=a.length()-1, j=b.length()-1, r=result.length-1; i>=0 && j>=0; i--, j--, r--) {
			int sum = arr_a[i] + arr_b[j] + result[r];
			
			// 마지막 숫자의 합계 정하기
			result[r] = (sum) % 10;
			
			// 합이 10이상이면 앞에 1추가하기
			if(sum > 9) {
				up = 1;
				if(i != 0) result[r-1]++;
			} else up = 0;
		}
		
		if(arr_a.length > arr_b.length) {
			for(int i=arr_a.length-arr_b.length-1; i>=0; i--) {
				int sum = arr_a[i] + result[i];
				
				// 마지막 숫자의 합계 정하기
				result[i] = (sum) % 10;
				
				// 합이 10이상이면 앞에 1추가하기
				if(sum > 9) {
					up = 1;
					if(i != 0) result[i-1]++;
				} else up = 0;
			}
		} else if(arr_a.length < arr_b.length) {
			for(int i=arr_b.length-arr_a.length-1; i>=0; i--) {
				int sum = arr_b[i] + result[i];
				
				// 마지막 숫자의 합계 정하기
				result[i] = (sum) % 10;
				
				// 합이 10이상이면 앞에 1추가하기
				if(sum > 9) {
					up = 1;
					if(i != 0) result[i-1]++;
				} else up = 0;
			}
		} 
		
		String txt = "";
		for(int i=0; i<result.length; i++) {
			txt += result[i];
		}
		
		if(up == 1) {
			System.out.println("1"+txt);
		} else {
			System.out.println(txt);
		}
		
	}
	
}
