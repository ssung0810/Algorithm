package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 강의실 배정
 * Date : 2021/11/19
 */
public class BJoon11000 {
    static int[] dp ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[][] study = new int[N][2];
        dp = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            study[i][0] = Integer.parseInt(st.nextToken());
            study[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(study,comp);

        int answer = 1;
        int cur = study[0][1];
        for(int i=0; i<study.length; i++) {
            dfs();
        }

        for(int i=0; i<N; i++) {
            System.out.println(study[i][0] + " :: " + study[i][1]);
        }
    }

    static void dfs() {

    }

    static Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] > o2[0]) return 1;
            return -1;
        }
    };
}
