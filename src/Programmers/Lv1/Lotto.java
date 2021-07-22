package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lotto {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] lottos = new int[6];
		int[] win_nums = new int[6];
		
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<6; i++) {
			int num = Integer.parseInt(st.nextToken());
			lottos[i] = num;
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<6; i++) {
			win_nums[i] = Integer.parseInt(st.nextToken());
		}
		
		/////////////////////////////////////
		
		int[] answer = new int[2];
		int zeroCnt = 0;
		int cnt = 0;
		
		for(int i=0; i<6; i++) {
			if(lottos[i] != 0) {
				for(int j=0; j<6; j++) {
					if(win_nums[j] == lottos[i]) cnt++;
				}
			} else {
				zeroCnt++;
			}
		}
		
		if(cnt+zeroCnt > 1) answer[0] = 7-(cnt+zeroCnt);
		else answer[0] = 6;
		
		if(cnt > 1) answer[1] = 7-cnt;
		else answer[1] = 6;
		
		System.out.println(Arrays.toString(answer));
	}

}
