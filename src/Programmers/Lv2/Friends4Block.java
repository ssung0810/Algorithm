package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 프렌즈4블록
 * Date : 2021/10/11
 */
public class Friends4Block {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        String[] board = new String[m];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<board.length; i++) {
            board[i] = st.nextToken();
        }

        /////////////////////////////////////////////////////

        int answer = 0;
        String[][] arr = new String[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = board[i].split("")[j];
            }
        }

        int stRow = 0;
        int stCol = 0;

        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n-1; j++) {
                if(arr[i][j].equals("")) continue;

                if(block(arr, i, j)) {
                    stRow = i;
                    stCol = j;
                }
            }
        }
    }

    static boolean block(String[][] arr, int row, int col) {
        return true;
    }
}
