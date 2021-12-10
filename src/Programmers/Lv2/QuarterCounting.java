package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 쿼드압축 후 개수새기
 * Date : 2021/12/10
 */
public class QuarterCounting {
    static int cntOne = 0;
    static int cntZero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] c = bf.readLine().split("");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(c[j]);
            }
        }

        ////////////////////////////////////////////////

        int[] answer = new int[2];

        cutting(arr, arr.length, 0, 0);

        answer[0] = cntZero;
        answer[1] = cntOne;

        System.out.println(Arrays.toString(answer));
    }

    static void cutting(int[][] arr, int N, int row, int col) {
        int check = arr[row][col];

        for(int i=row; i<N+row; i++) {
            for(int j=col; j<N+col; j++) {
                if(check != arr[i][j]) {
                    cutting(arr, N/2, row, col);
                    cutting(arr, N/2, row+N/2, col);
                    cutting(arr, N/2, row, col+N/2);
                    cutting(arr, N/2, row+N/2, col+N/2);

                    return;
                }
            }
        }

        if(check == 0) cntZero++;
        else cntOne++;
    }
}
