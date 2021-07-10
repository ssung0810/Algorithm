package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class K_Number {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] answer = {};
		int N = Integer.parseInt(bf.readLine());
		int[] array = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(bf.readLine());
		int[][] commands = new int[M][3];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			commands[i][0] = Integer.parseInt(st.nextToken());
			commands[i][1] = Integer.parseInt(st.nextToken());
			commands[i][2] = Integer.parseInt(st.nextToken());
		}

		// ======================================================
		
		ArrayList<Integer> arr = new ArrayList<>();
		answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
				arr.add(array[j]);
			}
			
			Collections.sort(arr);
			answer[i] = arr.get(commands[i][2]-1);
			
			arr.clear();
		}
		
//		System.out.println(commands.length);
		System.out.println(Arrays.toString(answer));
	}

}
