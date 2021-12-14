package Programmers.Lv2;

import com.sun.org.apache.xpath.internal.objects.XBoolean;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 후보키
 * Date : 2021/12/13
 */
public class CandidateKey_kakao {
    static ArrayList<String> str = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    static boolean[] visit;

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
        visit = new boolean[relation[0].length];
        Queue<Integer> q = new LinkedList<>();

        // 1개만 했을 때 중복체크
        for(int i=0; i<relation[0].length; i++) {
            set.clear();

            for(int j=0; j<relation.length; j++) {
                // 컬럼에서 중복이 있으면 true로 변환
                if(!set.add(relation[j][i])) {
                    visit[i] = true;
                    break;
                }
            }

            if(set.size() == relation.length) answer++;
        }

        System.out.println(Arrays.toString(visit));

        for(int i=0; i<relation[0].length; i++) {
            if(visit[i]) {
                int cnt = 2;
                q.add(i);
                for(int j=i+1; j<relation[0].length; j++) {
                    if(!visit[j]) continue;

                    q.add(j);
                    cnt++;
                    set.clear();

                    if(isUnique(q, relation)) {
                        answer++;
                        break;
                    }
                }

                q.clear();
            }
        }

        System.out.println(answer);
    }

    static boolean isUnique(Queue<Integer> q, String[][] relation) {
        StringBuilder sb = new StringBuilder();

        for(int num : q) {
            System.out.print(q + " ");
        }
        System.out.println();

        for(int i=0; i<relation.length; i++) {
            for(int idx : q) {
                sb.append(relation[q.poll()][i]);
            }
            if(!set.add(sb.toString())) return false;
        }

        return true;
    }
}
