package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ClothesLend {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		int a = Integer.parseInt(bf.readLine());
		int[] lost = new int[a];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<a; i++) {
			lost[i] = Integer.parseInt(st.nextToken());
		}
		
		int b = Integer.parseInt(bf.readLine());
		int[] reserve = new int[b];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<b; i++) {
			reserve[i] = Integer.parseInt(st.nextToken());
		}
		
		////////////////////////////////////
		
		int answer = 0;
		int[] clothes = new int[n+2];
		Arrays.fill(clothes, 1);

        for(int i=0; i<lost.length; i++) {
            clothes[lost[i]]--;
        }

        for(int i=0; i<reserve.length; i++) {
        	clothes[reserve[i]]++;
        }
        
        for(int i=0; i<clothes.length; i++) {
        	if(clothes[i] == 2) {
        		if(clothes[i-1] == 0) {
        			clothes[i-1]++;
        			clothes[i]--;
        		} else if(clothes[i+1] == 0) {
        			clothes[i+1]++;
        			clothes[i]--;
        		}
        	}
        }

        for(int i=0; i<clothes.length; i++) {
            if(clothes[i] == 0) {
                answer++;
            }
        }

        answer = n-answer;
        
        System.out.println(answer);
	}

}
