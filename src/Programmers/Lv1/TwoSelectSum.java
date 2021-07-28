package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/* 두 개 뽑아서 더하기
 * Date : 2021/07/28
 */
public class TwoSelectSum {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		/////////////////////////////////////////
		
		HashMap<String, Integer> m = new HashMap<>();
		for(int i=0; i<numbers.length; i++) {
			for(int j=0; j<numbers.length; j++) {
				if(i == j) continue;
				
				if(!m.containsValue(numbers[i]+numbers[j])) {
					m.put(numbers[i]+"+"+numbers[j], numbers[i]+numbers[j]);
				}
			}
		}

		int[] answer = new int[m.size()];
		int cnt = 0;
		for(String s : m.keySet()) {
			answer[cnt] = m.get(s);
			cnt++;
		}
			
		Arrays.sort(answer);
		System.out.println(Arrays.toString(answer));
	}

}
