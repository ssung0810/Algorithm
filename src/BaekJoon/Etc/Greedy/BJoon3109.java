package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 빵집
 * Date : 2021/11/19
 */
public class BJoon3109 {
    static int R, C;
    static boolean[][] visit;
    static int answer = 0;
    static int exit = 0;
    static int[] moving = {-1, 0 , 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        visit = new boolean[R][C];
        for(int i=0; i<R; i++) {
            map[i] = bf.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                if(map[i][j] == 'x') visit[i][j] = true;
            }
        }

        for(int i=0; i<R; i++) {
            exit = 0;
            move(i, 0);
        }

        System.out.println(answer);
    }

    static void move(int row, int col) {
        if(col == C-1) {
            answer++;
            exit = 1;
            return;
        }

        for(int i=0; i<3; i++) {
            if(exit == 1) break;
            int m = moving[i];

            if(row+m >= 0 && row+m < R && !visit[row+m][col+1]) {
                visit[row+m][col+1] = true;
                move(row+m, col+1);
            }
        }
    }
}