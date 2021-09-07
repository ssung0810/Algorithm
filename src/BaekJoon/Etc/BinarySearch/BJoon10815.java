package BaekJoon.Etc.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 숮자카드
 * Date : 2021/09/07
 */
public class BJoon10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(search(num, arr) + "\n");
        }

        System.out.println(sb);
    }

    static int search(int N, int[] arr) {
        int s=0, e=arr.length-1, m=(s+e)/2;
        int answer = 0;

        while(s < e) {
            if(N < arr[m]) {
                e = m - 1;
            } else if(N > arr[m]) {
                s = m + 1;
            } else {
                answer = 1;
                break;
            }

            m = (s+e)/2;
        }

        if(N == arr[m]) answer = 1;

        return answer;
    }
}
