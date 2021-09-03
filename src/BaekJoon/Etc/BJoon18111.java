package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 마인크래프트(구현)
 * Date : 2021/09/03
 */
public class BJoon18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];
        int up = 0;
        int down = 0;
        int upCnt = 0;
        int downCnt = 0;
        int zero = 0;
        double sum = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                ground[i][j] = num;
                sum += num;
            }
        }

        int standard = (int) (Math.round(sum / (N*M)));

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(standard < ground[i][j]) {
                    up += (ground[i][j] - standard);
                    upCnt++;
                } else if(standard > ground[i][j]) {
                    down += (standard - ground[i][j]);
                    downCnt++;
                } else {
                    zero++;
                }
            }
        }

        int answer = 0;
        while(true) {
            if (up + B >= down) {
                answer = up*2 + down;
                break;
            }

            standard--;
            up += upCnt + zero;
            down -= downCnt;
        }

        System.out.println(answer + " " + standard);
    }
}
