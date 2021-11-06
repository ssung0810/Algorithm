package BaekJoon.Etc.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Yonsei TOTO
 * Date : 2021/10/26
 */
public class BJoon12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = n;

        int[] sugang = new int[n];
        int sum = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());

            if(P >= L) {
                int[] mileage = new int[P];
                for(int j=0; j<P; j++) mileage[j] = Integer.parseInt(st.nextToken());
                Arrays.sort(mileage);
                sugang[i] = mileage[P-L];
                sum += sugang[i];
            } else {
                sugang[i] = 1;
                sum += 1;
            }
        }

        Arrays.sort(sugang);

        System.out.println(Arrays.toString(sugang));

        if(sum <= m) answer = n;
        else {
            for(int i=sugang.length-1; i>=0; i--) {
                sum -= sugang[i];
                answer--;
                if(sum <= m) break;
            }
        }

        System.out.println(answer);
    }
}
