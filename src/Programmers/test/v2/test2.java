package Programmers.test.v2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 프렌즈4블록
 * Date : 2022/03/28
 */
public class test2 {

    static boolean[][] visit;

    public static void main(String[] args) {
//        int m = 6;
//        int n = 6;
//        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int answer = solution(m, n, board);

        System.out.println(answer);
    }

    private static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] arr = new char[m][n];
        for (int i=0; i<m; i++) {
            arr[i] = board[i].toCharArray();
        }

        visit = new boolean[m][n];
        int cnt = 0;
        while(true) {
            cnt = delete(arr);
            clear(arr);
            answer += cnt;

            if(cnt == 0) break;
        }

        return answer;
    }

    static int delete(char[][] arr) {
        int result = 0;

        for(int i=0; i<arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(visit[i][j]) continue;
                result += blockCheck(arr, i, j, 0);
            }
        }

        return result;
    }

    static int blockCheck(char[][] arr, int x, int y, int score) {
        int result = 0;

        int cnt = 0;
        char icon = arr[x][y];

        if(x+1 < arr.length && y+1 < arr[0].length) {
            if (icon == arr[x][y + 1]) cnt++;
            if (icon == arr[x + 1][y + 1]) cnt++;
            if (icon == arr[x + 1][y]) cnt++;
        }

        if(cnt == 3) {
            result += blockCheck(arr, x, y+1, 1);
            result += blockCheck(arr, x+1, y+1, 2);
            result += blockCheck(arr, x+1, y, 3);

            if(visit[x][y] == false) result++;
            if(visit[x][y+1] == false) result++;
            if(visit[x+1][y+1] == false) result++;
            if(visit[x+1][y] == false) result++;

            visit[x][y] = true;
            visit[x][y+1] = true;
            visit[x+1][y+1] = true;
            visit[x+1][y] = true;
        }

        return result;
    }

    static void clear(char[][] arr) {
        for(int i=arr.length-1; i>=0; i--) {
            for(int j=arr[0].length-1; j>=0; j--) {
                if(visit[i][j]) lineClear(arr, i, j, arr.length);

            }
        }
    }

    static void lineClear(char[][] arr, int x, int y, int len) {
        Queue<Character> q = new LinkedList<>();

        arr[x][y] = '-';

        for (int i = 1; i <= x; i++) {
            if(visit[x-i][y] == false) {
                q.add(arr[x-i][y]);
                visit[x-i][y] = true;
            }
            arr[x - i][y] = '-';
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            arr[x-cnt][y] = q.poll();
            visit[x-cnt][y] = false;
            cnt++;
        }
    }
}
