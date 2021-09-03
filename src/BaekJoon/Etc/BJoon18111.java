package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 마인크래프트(구현)
 * Date : 2021/09/03
 */
public class BJoon18111 {
    static int N, M, B;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                ground[i][j] = num;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        int time = Integer.MAX_VALUE;
        int floor = 0;
        int num = 0;
        for(int i=min; i<=max; i++) {
            num = time(i, ground);

            if(time >= num) {
                time = num;
                floor = i;
            }
        }

        System.out.println(time + " " + floor);
    }

    static int time(int floor, int[][] ground) {
        int up = 0;
        int down = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(ground[i][j] > floor) {
                    up += ground[i][j] - floor;
                } else if(ground[i][j] < floor) {
                    down += floor - ground[i][j];
                }
            }
        }

        if(up + B >= down) {
            return up*2 + down;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
