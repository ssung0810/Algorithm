package Programmers.WeeklyChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 복서 정렬하기
 * Date : 2021/10/13
 */
public class week6 {
    static double[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] weights = new int[N];
        String[] head2head = new String[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            head2head[i] = st.nextToken();
        }

        /////////////////////////////////////////////

        arr = new double[weights.length][4];
        for(int i=0; i<weights.length; i++) {
            String score = head2head[i];
            arr[i][3] = i+1;
            arr[i][2] = weights[i];
            double win = 0;
            double battle = 0;

            for(int j=0; j<score.length(); j++) {
                if(i == j) continue;

                char ck = score.charAt(j);
                if(ck != 'N') {
                    battle++;

                    if(ck == 'W') {
                        win++;

                        if(weights[i] < weights[j]) arr[i][1]++;
                    }
                }
            }

            arr[i][0] = battle == 0 ? 0 : win / battle * 100; //Math.round(((double)win / (double)battle * 100)*100) / 100.0;
        }

        Arrays.sort(arr, comp);

        int[] answer = new int[weights.length];
        for(int i=0; i<answer.length; i++) {
            answer[i] = (int)arr[i][3];
        }

        System.out.println(Arrays.toString(answer));
    }

    static Comparator<double[]> comp = new Comparator<double[]>() {
        @Override
        public int compare(double[] o1, double[] o2) {
            if(o1[0] == o2[0]) {
                if(o1[1] == o2[1]) {
                    if(o1[2] == o2[2]) {
                        return (int) (o1[3] - o1[3]);
                    }

                    return (int) (o2[2] - o1[2]);
                }

                return (int) (o2[1] - o1[1]);
            }

            return o2[0] >= o1[0] ? 1 : -1;
        }
    };
}
