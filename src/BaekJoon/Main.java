package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[][] meeting = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				if(e1[1] == e2[1]) {
					return e1[0] - e1[1];
				}
				
				return e1[1] - e2[1];
			}
		});
		
		int cnt = 1;
		int endTime = meeting[0][1];
		for(int i=1; i<N; i++) {
			if(meeting[i][0] >= endTime) {
				cnt++;
				endTime = meeting[i][1];
			}
		}
		
		System.out.println(cnt);
	}
	
}
