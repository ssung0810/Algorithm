package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/* 후보키
 * Date : 2021/12/13
 */
public class CandidateKey_kakao {
    static ArrayList<String> str = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    static boolean[] visit = new boolean[99999999];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] relation = new String[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j=0; j<M; j++) {
                relation[i][j] = st.nextToken();
            }
        }

        ////////////////////////////////

        int answer = 0;

        // 기준이 되는 컬럼위치
        for(int i=0; i<relation[0].length; i++) {
            // 조합할 개수
            for(int j=1; j<=relation[0].length; j++) {
                findKey(0, j, relation);
            }
        }

        System.out.println(answer);
    }

    // 여기서 루프를 돌면서 확인할 컬럼의 인데스들을 뽑아냄
    static boolean findKey(int d, int limit, String[][] relation) {
        if(d == limit) {
            return true;
        }

        for(int i=0; i<relation[0].length; i++) {

        }

        return false;
    }

    // 위에서 뽑아낸 인덱스들에 해당하는 튜플들을 조합해서
    static void make(String[][] relation) {

    }
}
