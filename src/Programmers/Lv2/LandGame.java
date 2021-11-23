package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 땅따먹기
 * Date : 2021/11/20
 */
public class LandGame {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] land = new int[n][4];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            land[i][0] = Integer.parseInt(st.nextToken());
            land[i][1] = Integer.parseInt(st.nextToken());
            land[i][2] = Integer.parseInt(st.nextToken());
            land[i][3] = Integer.parseInt(st.nextToken());
        }

        /////////////////////////////////////////////////////

        dp = new int[land.length][4];
        int answer = 0;
        for(int i=1; i< land.length; i++) {
            land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2]);
        }

        int len = land.length-1;
        answer = max(land[len][0], land[len][1], land[len][2], land[len][3]);

        System.out.println(answer);
    }

    static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    static int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
