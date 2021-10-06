package BaekJoon.Etc.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 기타 레슨
 * Date : 2021/10/04
 */
public class BJoon2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int sum = 0;
        int min = 0;
        int[] video = new int[N];
        for(int i=0; i<N; i++) {
            video[i] = Integer.parseInt(st.nextToken());
            sum += video[i];
//            min = min < video[i] ? video[i] : min;
        }

        int max = sum;
        int mid = (min+max)/2;
        int answer = Integer.MAX_VALUE;

        if(N == 1) {
            answer = video[0];
        } else {
            while(min <= max) {
                mid = (min+max)/2;

                int num = sum(video, M, mid);

                if(num > M) {
                    min = mid + 1;
                } else if(num <= M) {
                    max = mid - 1;
                } else {
                    answer = Math.min(answer, mid);
                    max = mid - 1;
                }
            }
        }

        System.out.println(min);
    }

    static int sum(int[] video, int limit, int count) {
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<video.length; i++) {
            sum += video[i];

            if(sum > count) {
                sum = video[i];
                cnt++;
            }
        }

        if(sum != 0) cnt++;

        return cnt;
    }
}
