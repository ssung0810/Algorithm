package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 숫자 카드 2
 * Created by qkrtjdcjf124
 * Date : 2021/06/23
 */
public class BJoon10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int CALC = 10000000;
		
		int N = Integer.parseInt(bf.readLine());
		int[] card = new int[20000001];
		
		st = new StringTokenizer(bf.readLine());
		int num;
		for(int i=0; i<N; i++) {
			num = Integer.parseInt(st.nextToken()) + CALC;
			card[num]++;
		}
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<M; i++) {
			num = Integer.parseInt(st.nextToken()) + CALC;
			sb.append(card[num] + " ");
		}
		
		System.out.println(sb);
	}

}
