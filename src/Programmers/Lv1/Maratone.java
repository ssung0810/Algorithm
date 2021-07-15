package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 완주하지 못한 선수
 * Date : 2021/07/14
 */
public class Maratone {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		
		String[] participant = new String[N];
		String[] completion = new String[N-1];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			participant[i] = st.nextToken();
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N-1; i++) {
			completion[i] = st.nextToken();
		}
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
//		for(int i=0; i<N; i++) {
//			System.out.print(participant[i] + " ");
//		}
//		System.out.println();
//		for(int i=0; i<N-1; i++) {
//			System.out.print(completion[i] + " ");
//		}
		
		String answer = "";
        
        for(int i=0; i<completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
            }
        }
        
        if(answer.equals("")) {
            answer = participant[participant.length - 1];
        }
        
        System.out.println(answer);
	}

}
