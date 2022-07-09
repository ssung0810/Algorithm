package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 통나무 건너뛰기
 * Date : 2022/07/09
 */
public class BJoon11497 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            sb.append(getMinHeight(bf) + "\n");
        }

        System.out.println(sb.toString());
    }

    private static int getMinHeight(BufferedReader bf) throws Exception {
        int N = Integer.parseInt(bf.readLine());
        int[] L = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(L);

        int[] wood = new int[N+1];
        wood[0] = L[0];
        wood[wood.length-1] = L[0];

        int answer = setWoodLine(wood, L);

        return answer;
    }

    private static int setWoodLine(int[] wood, int[] L) {
        int max = 0;
        int front = 1;
        int rear = wood.length-2;
        int flag = 0;

        for (int i=1; i<L.length; i++) {
            if (flag == 0) {
                wood[front] = L[i];
                max = Math.max(max, wood[front] - wood[front - 1]);
                front++;
                flag = 1;
            } else {
                wood[rear] = L[i];
                max = Math.max(max, wood[rear] - wood[rear + 1]);
                rear--;
                flag = 0;
            }
        }

        return max;
    }
}
