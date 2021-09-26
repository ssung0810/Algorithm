package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 행렬 테두리 회전하기
 * Date : 2021/09/25
 */
public class LineRotation {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(bf.readLine());
        int columns = Integer.parseInt(bf.readLine());
        int N = Integer.parseInt(bf.readLine());
        int[][] queries = new int[N][4];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());

            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            queries[i][2] = Integer.parseInt(st.nextToken());
            queries[i][3] = Integer.parseInt(st.nextToken());
        }

        /////////////////////////////////////////////////////////

        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        int cnt = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                arr[i][j] = cnt;
                cnt++;
            }
        }

        for(int i=0; i<queries.length; i++) {
            answer[i] = rotation(queries[i]);
        }

        System.out.println(answer);
    }

    static int rotation(int[] queries) {
        int a = queries[0] - 1;
        int b = queries[1] - 1;
        int c = queries[2] - 1;
        int d = queries[3] - 1;
        int[] move = {c-a+1, d-b, c-a, d-b};

        int num = arr[a][b];
        int min = num;
        int row = a, col = b;
        while(!(row == a && col == b+1)) {
            if(move[0] != 0) {
                if(move[0] != 1) {
                    arr[row][col] = arr[row+1][col];
                    row++;
                    move[0]--;
                } else {
                    arr[row][col] = arr[row][col+1];
                    col++;
                    move[0]--;
                }
            } else if(move[1] != 0) {
                if(move[1] != 1) {
                    arr[row][col] = arr[row][col+1];
                    col++;
                    move[1]--;
                } else {
                    arr[row][col] = arr[row-1][col];
                    row--;
                    move[1]--;
                }
            } else if(move[2] != 0) {
                if(move[2] != 1) {
                    arr[row][col] = arr[row-1][col];
                    row--;
                    move[2]--;
                } else {
                    arr[row][col] = arr[row][col-1];
                    col--;
                    move[2]--;
                }
            } else if(move[3] != 0) {
                arr[row][col] = arr[row][col-1];
                col--;
                move[3]--;
            }

            min = Math.min(min, arr[row][col]);
        }

        arr[a][b+1] = num;

        return min;
    }
}
