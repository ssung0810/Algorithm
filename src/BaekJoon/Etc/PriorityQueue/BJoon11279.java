package BaekJoon.Etc.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/* 최대 힙
 * Date : 2021/10/22
 */
public class BJoon11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);

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

    static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
}
