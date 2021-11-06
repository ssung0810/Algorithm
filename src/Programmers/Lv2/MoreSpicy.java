package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 더 맵게
 * Date : 2021/11/06
 */
public class MoreSpicy {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] scoville = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            scoville[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(bf.readLine());

        ////////////////////////////////////////////////

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int a = 0;
        while((a = pq.poll()) < K) {
            if(pq.isEmpty()) break;
            pq.add(a + pq.poll()*2);
            answer++;
        }

        System.out.println(a < K ? -1 : answer);
    }
}
