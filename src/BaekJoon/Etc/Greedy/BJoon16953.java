package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* A -> B
 * Date : 2022/07/04
 */
public class BJoon16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = findOriginalNum(A, B);

        System.out.println(answer);
    }

    private static int findOriginalNum(int A, int B) {
        int cnt = 0;

        while (A < B) {
            if(B%10 == 1) B /= 10;
            else if(B%2 == 0) B /= 2;
            else return -1;

            cnt++;
        }

        return A == B ? cnt + 1 : -1;
    }
}
