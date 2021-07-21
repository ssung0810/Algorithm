package BaekJoon.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJoon18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		int[] sort = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sort[i] = num;
		}
		
		Arrays.sort(sort);
		
		int cnt = 0;
		HashMap<Integer, Integer> m = new HashMap<>();
		for(int i=0; i<N; i++) {
			if(!m.containsKey(sort[i])) {
				m.put(sort[i], cnt);
				cnt++;
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(m.get(arr[i]) + " ");
		}
		
		System.out.println(sb);
	}

}
