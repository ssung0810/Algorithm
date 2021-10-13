package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 게임 맵 최단거리
 * Date : 2021/10/13
 */
public class GameMapShortDistance {
    static int[] x1 = {1, 0, -1, 0};
    static int[] y1 = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maps = new int[N][M];

        for(int i=0; i<N; i++) {
            String[] arr = bf.readLine().split("");

            for(int j=0; j<M; j++) {
                maps[i][j] = Integer.parseInt(arr[j]);
            }
        }

        ////////////////////////////////////////////////////

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] arr = q.poll();

            for(int i=0; i<4; i++) {
                int x = arr[0] + x1[i];
                int y = arr[1] + y1[i];

                if(x >= 0 && y >= 0 && x <= maps.length-1 && y <= maps[0].length-1 && maps[x][y] == 1) {
                    maps[x][y] = maps[arr[0]][arr[1]]+1;
                    q.offer(new int[]{x, y});
                }
            }
        }

        int answer = maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
        System.out.println(answer);
    }

    static void maze(int[][] maps, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] arr = q.poll();

            for(int i=0; i<4; i++) {
                int x = arr[0] + x1[i];
                int y = arr[1] + y1[i];

                if(x >= 0 && y >= 0 && x <= maps.length-1 && y <= maps[0].length-1 && maps[x][y] == 1) {
                    maps[x][y] = maps[arr[0]][arr[1]]+1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}
