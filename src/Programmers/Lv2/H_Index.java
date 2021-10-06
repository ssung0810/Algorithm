package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* H-Index
 * Date : 2021/10/06
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

        int answer = 0;
//        Arrays.sort(citations);

        int left = 0;
        int right = citations.length-1;

        for(int i=0; i<citations.length; i++) {
            if(i > right) {
                answer = i;
                break;
            }

            left++;
            right--;
        }

        System.out.println(answer);
    }
}
