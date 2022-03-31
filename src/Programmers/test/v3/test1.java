package Programmers.test.v3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/* 실패율
 * Date : 2022/03/30
 */
public class test1 {

    public static void main(String[] args) {
//        int N = 5;
//        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int N = 3;
        int[] stages = {1,1,1, 4};
//        int N = 8;
//        int[] stages = {1,2,3,4,5,6,7};

        int[] answer = solution(N, stages);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int[N];

        HashMap<Integer, Integer> stageCount = new HashMap<>();
        for (int stage : stages) {
            stageCount.put(stage, stageCount.getOrDefault(stage, 0) + 1);
        }

        int len = stages.length;

        double[][] arr = new double[N][2];
        clear(stageCount, arr, len);

        Arrays.sort(arr, comp);

        for(int i=0; i<arr.length; i++) {
            answer[i] = (int)arr[i][0];
        }

        return answer;
    }

    static void clear(HashMap<Integer, Integer> stageCount, double[][] arr, int len) {
        for (int i=0; i<arr.length; i++) {
            arr[i][0] = i+1;
            if(stageCount.containsKey(i+1)) {
                if(len == 0) arr[i][1] = 0;
                else {
                    arr[i][1] = (double) stageCount.get(i + 1) / len;
                    len -= stageCount.get(i + 1);
                }
            }
        }
    }

    static Comparator<double[]> comp = new Comparator<double[]>() {
        @Override
        public int compare(double[] o1, double[] o2) {
            if(o1[1] > o2[1]) {
                return -1;
            } else if(o1[1] == o2[1]) {
                if(o1[0] < o2[0]) {
                    return -1;
                }
            }

            return 0;
        }
    };
}
