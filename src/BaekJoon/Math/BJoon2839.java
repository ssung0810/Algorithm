package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 설탕 배달
 * Created by qkrtjdcjf124
 * Date : 2021/08/30
 */
public class BJoon2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int answer = 0;

		if(N == 3) answer = 1;
		else if(N == 4 || N == 7) answer = -1;
		else {
			if(N % 5 == 0) answer = N / 5;
			else if(N % 5 == 1 || N % 5 == 3) answer = N / 5 + 1;
			else answer = N / 5 + 2;
		}

		System.out.println(answer);
	}
}
