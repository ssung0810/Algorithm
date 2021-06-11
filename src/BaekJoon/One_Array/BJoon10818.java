package BaekJoon.One_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 최소, 최대
 * Created by qkrtjdcjf124
 * Date : 2021/06/11
 */
public class BJoon10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int min = 10000000;
		int max = -10000000;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		System.out.println(min + " " + max);
	}

}
