package BaekJoon;

import java.io.IOException;
import java.util.Arrays;

/* A + B - 4
 * Created by qkrtjdcjf124
 * Date : 2021/06/04
 */
public class Main {
	static int[] A = {1,2,3,4,5};
    static int[] B = {2,1,2,3,2,4,2,5};
    static int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    static int[] result = new int[3];
    
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		int[] answers = {1,2,3,4,5};
		int max = 0;
		for(int i=0; i<answers.length; i++) {
            int solve = answers[i];
            
            if(A[i%5] == solve) result[0]++;
            if(B[i%8] == solve) result[1]++;
            if(C[i%10] == solve) result[2]++;
        }
        
		for(int i=0; i<3; i++) {
			max = Math.max(max, result[i]);
		}
		
		int cnt = 0;
		for(int i=0; i<3; i++) {
			if(result[i] == max) {
				cnt++;
			}
		}
        
        int[] answer = new int[cnt];
        
        cnt = 0;
        for(int i=0; i<3; i++) {
        	if(result[i] == max) {
        		answer[cnt] = i+1;
                cnt++;
			}
        }
		
        System.out.println(Arrays.toString(answer));
	}
	
}
