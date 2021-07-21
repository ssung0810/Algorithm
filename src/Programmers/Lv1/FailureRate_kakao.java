package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FailureRate_kakao {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] stages = new int[Integer.parseInt(bf.readLine())];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<stages.length; i++) {
			stages[i] = Integer.parseInt(st.nextToken());
		}
		
		/////////////////////////////////////////
		
		int[] answer = new int[N];
		failure[] obj = new failure[N];
		
		int[] clear = new int[N+2];
		for(int i=0; i<stages.length; i++) {
			clear[stages[i]]++;
		}
		
		int sum = 0;
		int len = stages.length;
		for(int i=0; i<answer.length; i++) {
			obj[i] = new failure(i+1, (double)clear[i+1] / (len - sum));
			sum += clear[i+1];
		}
		
		Arrays.sort(obj, comp);
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = obj[i].stage;
		}
		
		System.out.println(Arrays.toString(answer));
	}
	
	static Comparator<failure> comp = new Comparator<failure>() {
		@Override
		public int compare(failure o1, failure o2) {
			if(o1.value == o2.value) {
				return o1.stage - o2.stage;
			}
			
			if(o2.value > o1.value) {
				return 1;
			} else if(o2.value < o1.value) {
				return -1;
			} else {
				return 0;
			}
		}
	};
}

class failure {
	int stage;
	double value;
	
	failure(int stage, double value) {
		this.stage = stage;
		this.value = value;
	}
}
