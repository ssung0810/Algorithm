package BaekJoon.Etc.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 카드 합체 놀이
 * Date : 2021/10/26
 */
public class BJoon15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++) {
            long a = pq.remove();
            long b = pq.remove();

            pq.add(a+b);
            pq.add(a+b);
        }

        long answer = 0;
        for(long num : pq) {
            answer += num;
        }

        System.out.println(answer);
    }
}
