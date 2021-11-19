package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 저울
 * Date : 2021/11/19
 */
public class BJoon2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] weight = new int[N];
        for(int i=0; i<N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (answer+1 < weight[i]) break;
            answer += weight[i];
        }

        System.out.println(answer+1);
    }
}
