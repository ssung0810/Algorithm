package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 카드 정렬
 * Date : 2021/11/17
 */
public class BJoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }

        int answer = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            answer += a+b;
            pq.add(a+b);
        }

        System.out.println(answer);
    }
}
