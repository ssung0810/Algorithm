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
        long max_x = Integer.MIN_VALUE;
        long min_x = Integer.MAX_VALUE;
        long max_y = Integer.MIN_VALUE;
        long min_y = Integer.MAX_VALUE;

        // x, y 좌표 중 정수인것만 리스트에 입력
        for(int i=0; i< line.length; i++) {
            int[] arr = line[i];
            for(int j=i+1; j< line.length; j++) {
                long bottom = arr[0] * line[j][1] - arr[1] * line[j][0];
                if(bottom == 0) continue;

                long a = arr[1] * line[j][2] - arr[2] * line[j][1];
                long b = arr[2] * line[j][0] - arr[0] * line[j][2];

                if(a % bottom == 0 && b % bottom == 0) {
                    max_x = Math.max((int) (a/bottom), max_x);
                    min_x = Math.min((int) (a/bottom), min_x);
                    max_y = Math.max((int) (b/bottom), max_y);
                    min_y = Math.min((int) (b/bottom), min_y);
                    star.add(new int[]{(int) (a/bottom), (int) (b/bottom)});    // (x좌표, y좌표) 입력
                }
            }
        }

        int size_x = (int) (max_x - min_x + 1);
        int size_y = (int) (max_y - min_y + 1);

        String[] answer = new String[size_y];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size_x; i++) {
            sb.append(".");
        }
        Arrays.fill(answer, sb.toString());

        // 그래프 입력
        int x=0, y=0;
        System.out.println(size_x + " :: " + max_x);
        System.out.println(size_y + " :: " + max_y);
        for(int i=0; i< star.size(); i++) {
            if(size_y != max_y) y = star.get(i)[1]+(int)max_y;
            else y = star.get(i)[1];
            if(size_x != max_x) x = star.get(i)[0]+(int)max_x;
            else x = star.get(i)[0];

            String str = answer[y];
            sb = new StringBuilder(str);
            sb.replace(x, x+1, "*");
            answer[y] = sb.toString();
        }

        System.out.println(Arrays.toString(answer));
    }

    static Comparator<long[]> comp = new Comparator<long[]>() {
        @Override
        public int compare(long[] o1, long[] o2) {
            if(o1[1] == o2[1]) {
                if(o1[0] >= o2[0]) return 1;
                else return -1;
            }

            if(o2[1] >= o1[1]) return 1;
            else return -1;
        }
    };
}
