package Programmers.Lv2;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/* 후보키
 * Date : 2021/08/20
 */
public class CandidateKey_kakao {
    static Set<String> s = new HashSet<String>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] realation = new String[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j=0; j<M; j++) {
                realation[i][j] = st.nextToken();
            }
        }

        ////////////////////////////////

        answer = 0;
        String[] dp = new String[20];

        key(realation, dp, 0, 0, 0);

        System.out.println(answer);
    }

    static void key(String[][] relation, String[] dp, int row, int col, int d) {
        if(col == relation.length) return;

        // 컬럼 반복문
        for(int i=col; i<relation[i].length; i++) {
            s = new HashSet<String>();
            String[] arr = dp;

            // 튜플 반복문
            for(int j=row; j<relation.length; j++) {
                arr[j] = arr[j] + relation[j][i];
                // Set에 중복된게 있다면 다음 체크리스트로 넘김
                if(!s.add(arr[j])) {
                    // 튜플이 마지막 인덱스가 아니라면 재귀실행
                    if(j != relation.length-1) {
                        key(relation, arr, 0, i+1, d+1);
                    }

                    break;
                }

                if(j == relation[i].length-1) answer++;
            }
        }
    }
}
