package Programmers.WeeklyChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 10주차
 * Date : 2021/10/15
 */
public class week10 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[][] line = new int[N][3];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
            line[i][2] = Integer.parseInt(st.nextToken());
        }

        ///////////////////////////////////////////////

        ArrayList<int[]> star = new ArrayList<>();

        for(int i=0; i< line.length; i++) {
            int[] arr = line[i];
            for(int j=i+1; j< line.length; j++) {
                int a = arr[0] * line[j][1] - arr[1] * line[j][0];
                int b = arr[1] * line[j][2] - arr[2] * line[j][1];

                if((a != 0 && b % a == 0) && (b/a * arr[0] + arr[2]) % arr[1] == 0) {
                    star.add(new int[]{b/a, -(b/a * arr[0] + arr[2]) / arr[1]});    // (x좌표, y좌표) 입력
                }
            }
        }

        int[][] result = new int[star.size()][2];
        int max_x = Integer.MIN_VALUE;
        int min_x = Integer.MAX_VALUE;
        for(int i=0; i<star.size(); i++) {
            result[i][0] = star.get(i)[0];
            result[i][1] = star.get(i)[1];

            max_x = Math.max(result[i][0], max_x);
            min_x = Math.min(result[i][0], min_x);
        }

        Arrays.sort(result, comp);

        int len = result.length;
        int size_x = Math.abs(max_x - min_x) + 1;
        int size_y = Math.abs(result[0][1] - result[result.length-1][1]) + 1;

        String[] answer = new String[size_y];

//        for(int[] p : result) {
//            System.out.println(p[0] + " :: " + p[1]);
//        }

        StringBuilder sb = new StringBuilder();
        for(int i=result[0][1], cnt=0, r=0; i>=result[result.length-1][1]; i--, r++) {
//            System.out.println("i " + i);

            for(int j=min_x; j<=max_x; j++) {
//                System.out.println("j " + j);

                if(j == result[cnt][0] && i == result[cnt][1]) {
                    sb.append("*");
                    cnt++;
                } else {
                    sb.append(".");
                }
            }

            answer[r] = sb.toString();
            sb = new StringBuilder();
        }

        System.out.println(Arrays.toString(answer));
    }

    static Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o2[1] - o1[1];
        }
    };
}
