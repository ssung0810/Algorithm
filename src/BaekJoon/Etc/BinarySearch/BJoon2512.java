package BaekJoon.Etc.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 예산
 * Date : 2021/09/07
 */
public class BJoon2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        long max = 0;
        long sum = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
            sum += num;
        }

        long M = Integer.parseInt(bf.readLine());
        long answer = 0;
        long s=0, e=max, m=(s+e)/2;

        if(sum <= M) answer = max;
        else {
            while (s <= e) {
                sum = search(m, arr);

                if (sum > M) {
                    e = m - 1;
                } else if (sum < M) {
                    s = m + 1;
                    answer = Math.max(m, answer);
                } else {
                    answer = m;
                    break;
                }
                m = (s + e) / 2;
            }
        }

        System.out.println(answer);
    }

    static long search(long N, int[] arr) {
        long sum = 0;

        for(int i=0; i<arr.length; i++) {
            if(N >= arr[i]) {
                sum += arr[i];
            } else {
                sum += N;
            }
        }

        return sum;
    }
}
