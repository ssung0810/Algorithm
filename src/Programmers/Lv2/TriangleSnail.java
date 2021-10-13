package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 삼각 달팽이
 * Date : 2021/10/13
 */
public class TriangleSnail {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        /////////////////////////////////////////////////////

        int[][] arr = new int[n][n];
        boolean[][] visit = new boolean[n][n];

        int end = (int)(n*(n+1)/2);
        int row = 0;
        int col = 0;
        int draw = 1;
        for(int i=1; i<=end; i++) {
            arr[row][col] = i;
            visit[row][col] = true;

            if(draw == 1) {
                if(row + 1 < n && visit[row+1][col] == false) {
                    row += 1;
                } else {
                    col += 1;
                    draw = 2;
                }
            } else if(draw == 2) {
                if(col + 1 < n && visit[row][col+1] == false) {
                    col += 1;
                } else {
                    row -= 1;
                    col -= 1;
                    draw = 3;
                }
            } else if(draw == 3) {
                if(col - 1 >= 0 && visit[row-1][col-1] == false) {
                    row -= 1;
                    col -= 1;
                } else {
                    row += 1;
                    draw = 1;
                }
            }
        }

        int[] answer = new int[end];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] != 0) {
                    answer[cnt] = arr[i][j];
                    cnt++;
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
