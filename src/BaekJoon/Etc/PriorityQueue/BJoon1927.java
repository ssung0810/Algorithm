package BaekJoon.Etc.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentMap;

/* 최소 힙
 * Date : 2021/10/22
 */
public class BJoon1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(bf.readLine());

            if(num == 0) {
                if(pq.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(pq.remove() + "\n");
                }
            } else {
                pq.add(num);
            }
        }

        System.out.println(sb);
    }

}
