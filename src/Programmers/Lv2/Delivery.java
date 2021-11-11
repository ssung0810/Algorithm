package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 배달
 * Date : 2021/11/11
 */
public class Delivery {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[][] road = new int[M][3];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
            road[i][2] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(bf.readLine());

        /////////////////////////////////////////////////

        int answer = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[road.length];

//        for(int[] a : road) {
//            System.out.println(a[0] + " :: " + a[1] + " :: " + a[2]);
//        }

        int[] dp = new int[N+1];

        q.add(1);
        while(!q.isEmpty()) {
            int num = q.poll();
            for(int i=0; i<road.length; i++) {
                if(visit[i]) continue;

                if(road[i][0] == num || road[i][1] == num) {
                    int a = road[i][0];
                    int b = road[i][1];
                    visit[i] = true;

                    if(a == num) {
                        q.add(b);
                        dp[b] = dp[b] == 0 ? dp[a] + road[i][2] : Math.min(dp[b], dp[a] + road[i][2]);
                    } else {
                        q.add(a);
                        dp[a] = dp[a] == 0 ? dp[b] + road[i][2] : Math.min(dp[a], dp[b] + road[i][2]);
                    }
                }
            }

//            Arrays.fill(visit, false);
        }

        for(int num : dp) {
            if(num != 0 && num <= K) answer++;
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }
}
