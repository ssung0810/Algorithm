package Programmers.test.v2;

import java.util.Arrays;

/* 프렌즈4블록
 * Date : 2022/03/28
 */
public class test2 {

    static int[] x = {0, 1, 1};
    static int[] y = {1, 1, 0};
    static boolean[][] visit;

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        int answer = solution(m, n, board);

        System.out.println(answer);
    }

    private static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] arr = new char[m][n];
        for (int i=0; i<m; i++) {
            arr[i] = board[i].toCharArray();
//            System.out.println(Arrays.toString(arr[i]));
        }

        visit = new boolean[m][n];

        int result = 1;
        while (result > 0) {
            result = delete(arr, 0, 0);
            clear(board);

            System.out.println(result);

            answer += result;
        }

        return answer;
    }

    static int delete(char[][] arr, int m, int n) {
        int max = 0;

        for (int i = m; i < arr.length; i++) {
            for (int j = n; j < arr[0].length; j++) {
                if(arr[i][j] == '0') continue;

                int cnt = blockCheck(arr, i, j);

                if(cnt == 3) {
                    delete(arr, i, j+1);
                    delete(arr, i+1, j+1);
                    delete(arr, i+1, j);

                    if(arr[i][j] != '0') {
                        arr[i][j] = '0';
                        max++;
                    }
                    if(arr[i][j+1] != '0') {
                        arr[i][j+1] = '0';
                        max++;
                    }
                    if(arr[i+1][j+1] != '0') {
                        arr[i+1][j+1] = '0';
                        max++;
                    }
                    if(arr[i+1][j] != '0') {
                        arr[i+1][j] = '0';
                        max++;
                    }
                }
            }
        }

        return max;
    }

    static int blockCheck(char[][] arr, int i, int j) {

        char ck = arr[i][j];
//        System.out.println(i + " :: " + j + " :: " + ck);
        int cnt = 0;
        for (int p = 0; p < 3; p++) {
            int a = i+x[p];
            int b = j+y[p];
            if(a < arr.length && b < arr[0].length) {
                System.out.println(i + " :: " + j + " :: " + ck + " :: " + a + " :: " + b + " :: " + arr[a][b]);
                if(ck == arr[a][b]) cnt++;
                else return 0;
            }
        }

        return cnt;
    }

    static void clear(String[] board) {

    }
}
