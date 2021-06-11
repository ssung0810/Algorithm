package BaekJoon.One_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJoon1546 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		float[] arr = new float[N];
		float max = 0;
		float sum = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = (float)num;
			max = Math.max(max, num);
		}
		
		for(int i=0; i<N; i++) {
			sum += (arr[i] / max) * 100;
		}
		
		System.out.println(sum / N);
	}

}
