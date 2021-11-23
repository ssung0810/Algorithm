package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* H-Index
 * Date : 2021/11/23
 */
public class H_Index {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] citations = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            citations[i] = Integer.parseInt(st.nextToken());
        }

        //////////////////////////////////////////

        int answer = 1;
        Arrays.sort(citations);

        for(int i=citations.length-1; i>=0; i--, answer++) {
            if(answer > citations[i]) {
                answer--;
                break;
            }

            if(i == 0) answer--;
        }

        if(citations.length == 1) {
            if(citations[0] == 1) answer = 1;
            else answer = 0;
        }

        System.out.println(answer);
    }
}
