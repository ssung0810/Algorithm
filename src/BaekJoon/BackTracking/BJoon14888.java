package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 연산자 끼워넣기
 * Created by qkrtjdcjf124
 * 2021/05/17
 */
public class BJoon14888 {
	static int[] num, calc, result;
	static int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		visit = new boolean[N];
		num = new int[N];
		calc = new int[N-1];
		result = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<4; i++) {
			int len = Integer.parseInt(st.nextToken());
			for(int j=0; j<len; j++) {
				calc[cnt] = i+1;
				cnt++;
			}
		}
		
		result[0] = num[0];
		Calc(N, 0);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void Calc(int N, int d) {
		if(N-1 == d) {
			max = Math.max(result[N-1], max);
			min = Math.min(result[N-1], min);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(!visit[i]) {
				visit[i] = true;
				switch(calc[i]) {
					case 1: result[d+1] = result[d] + num[d+1]; break;
					case 2: result[d+1] = result[d] - num[d+1]; break;
					case 3: result[d+1] = result[d] * num[d+1]; break;
					case 4: 
						if(result[d] < 0 && num[d+1] > 0) result[d+1] = -(-result[d] / num[d+1]);
						else result[d+1] = result[d] / num[d+1];
					break;
				};
				
				Calc(N, d+1);
				visit[i] = false;
			}
		}
	}
}
