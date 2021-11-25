package Programmers.Lv2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 프렌즈4블록
 * Date : 2021/11/24
 */
public class Friends4Block {
    static char[][] block;
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
        block = new char[m][n];

        for(int i=0; i<m; i++) {
            block[i] = board[i].toCharArray();
        }

//        for(int i=0; i<block.length; i++) {
//            for(char z : block[i]) {
//                System.out.print(z + " ");
//            }
//            System.out.println();
//        }

        int cnt = 0;
        while((cnt = boom()) != 0) {
            answer += cnt;
            clear();
        }

        System.out.println(answer);
    }

    static int boom() {
        HashMap<Integer, Integer> remove = new HashMap<>();
        boolean[][] visit = new boolean[block.length][block[0].length];
        int answer = 0;

        for(int i=0; i<block.length-1; i++) {
            for(int j=0; j<block[i].length-1; j++) {
                if(block[i][j] == '0') continue;

                if(search(i, j)) {
                    visit[i][j] = true;
                    visit[i][j+1] = true;
                    visit[i+1][j] = true;
                    visit[i+1][j+1] = true;
                }
            }
        }

        for(int i=0; i<visit.length; i++) {
            for(int j=0; j<visit[i].length; j++) {
                if(visit[i][j]) {
                    block[i][j] = '0';
                    visit[i][j] = false;
                    answer++;
                }
            }
        }

        return answer;
    }

    static boolean search(int row, int col) {
        if(block[row][col] != block[row][col+1]) return false;
        if(block[row][col] != block[row+1][col]) return false;
        if(block[row][col] != block[row+1][col+1]) return false;

        return true;
    }

    static void clear() {
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<block[0].length; i++) {
            for(int j=block.length-1; j>=0; j--) {
                if(block[j][i] != '0') q.add(block[j][i]);
            }

            for(int j=block.length-1; j>=0; j--) {
                if(q.isEmpty()) block[j][i] = '0';
                else block[j][i] = q.poll();
            }
        }
    }
}