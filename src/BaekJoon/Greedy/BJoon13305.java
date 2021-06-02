package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 주유소
 * Created by qkrtjdcjf124
 * Date : 2021/06/02
 */
public class BJoon13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		long[] distance = new long[N-1];
		long[] oil = new long[N];
		long sum = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}
		
		long oilCk = oil[0];
		
		for(int i=0; i<N-1; i++) {
			if(oilCk > oil[i]) oilCk = oil[i];
			sum += oilCk * distance[i];
		}
		
		System.out.println(sum);
	}
}
