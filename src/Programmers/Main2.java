package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		String[] participant = new String[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			participant[i] = st.nextToken();
		}

		int M = Integer.parseInt(bf.readLine());
		String[] completion = new String[M];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<M; i++) {
			participant[i] = st.nextToken();
		}

		/////////////////////////////
		
		String answer = "";

		ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<completion.length; i++) {
            arr.add(completion[i]);
        }

        for(int i=0; i<participant.length; i++) {
            if(arr.contains(participant[i])) {
                arr.remove(i);
            } else {
                answer = participant[i];
            }
        }
        
        System.out.println(answer);
	}

}
