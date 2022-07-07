package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 행렬
 * Date : 2022/07/07
 */
public class BJoon1080 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] A = new char[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = bf.readLine().toCharArray();
        }

        char[][] B = new char[N][M];
        for (int i = 0; i < N; i++) {
            B[i] = bf.readLine().toCharArray();
        }

        //////////////////////////////////////////////

        int answer = 0;

        main:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) {
                    if(check(A, i, j)) {
                        answer++;
                    } else {
                        answer = -1;
                        break main;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean check(char[][] A, int i, int j) {
        if(A.length < 3 || A[0].length < 3) return false;
        if(A.length - i < 3 || A[0].length - j < 3) return false;

        changeMatrix(A, i, j);

        return true;
    }

    private static void changeMatrix(char[][] A, int i, int j) {
        int[] position = {0, 1, 2};

        for (int m = 0; m < position.length; m++) {
            for (int n = 0; n < position.length; n++) {
                A[i+m][j+n] = changeNumber(A[i+m][j+n]);
            }
        }
    }

    private static char changeNumber(char num) {
        return num == '1' ? '0' : '1';
    }
}
