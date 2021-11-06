package Programmers.WeeklyChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 12주차
 * Date : 2021/10/26
 */
public class week12 {
    static boolean[] visit;
    static int len;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(bf.readLine());
        int[][] dungeons = new int[3][2];
        for(int i=0; i<dungeons.length; i++) {
            st = new StringTokenizer(bf.readLine());
            dungeons[i][0] = Integer.parseInt(st.nextToken());
            dungeons[i][1] = Integer.parseInt(st.nextToken());
        }

        ///////////////////////////////////////////////////////////

        int answer = 0;
        len = dungeons.length;
        visit = new boolean[len];

        dfs(k, 0, dungeons, 0);

        answer = max;
        System.out.println(answer);
    }

    static void dfs(int k, int sum, int[][] dungeons, int cnt) {
        if(sum > k) {
            max = Math.max(max, cnt-1);
            return;
        }

        for(int i=0; i<len; i++) {
            if(!visit[i] && dungeons[i][0] <= k-sum) {
                visit[i] = true;
                dfs(k, sum+dungeons[i][1], dungeons, cnt+1);
                visit[i] = false;
            }
        }

        max = Math.max(max, cnt);
    }
}
