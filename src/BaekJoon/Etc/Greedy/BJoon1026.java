package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 보물
 * Date : 2022/07/02
 */

/**
 * 나는 무식한 방법으로 풀었지만 가장 정석적인 방법은 A와 B를 둘다 정렬한 뒤 곱해서 더해버리는 방법.
 */
public class BJoon1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        ///////////////////////////////////////////////////

        int answer = 0;
        int[] result = new int[N];

        boolean[] visitA = new boolean[N];
        boolean[] visitB = new boolean[N];

        for (int i=0; i<N; i++) {
            int maxOfA = findMaxOfA(A, visitA);
            int positionOfB = findMinPositionOfB(B, visitB);

            result[positionOfB] = maxOfA;
        }

        for (int i=0; i<A.length; i++) {
            answer += result[i] * B[i];
        }

        System.out.println(answer);
    }

    private static int findMaxOfA(int[] A, boolean[] visitA) {
        int max = -1;
        int pos = 0;

        for (int i = 0; i < A.length; i++) {
            if(!visitA[i]) {
                if(max < A[i]) {
                    max = A[i];
                    pos = i;
                }
            }
        }

        visitA[pos] = true;
        return max;
    }

    private static int findMinPositionOfB(int[] B, boolean[] visitB) {
        int min = 101;
        int pos = 0;

        for (int i = 0; i < B.length; i++) {
            if (!visitB[i]) {
                if(min > B[i]) {
                    min = B[i];
                    pos = i;
                }
            }
        }

        visitB[pos] = true;
        return pos;
    }
}
