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
    static ArrayList<HashSet<Integer>> box = new ArrayList<>();
    static HashSet<Integer> idxSet = new HashSet<>();
    static HashSet<String> set = new HashSet<>();
    static boolean[] visit;
    static int result = 0;

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

//        System.out.println(Arrays.toString(visit));

        for(int i=2; i<=relation[0].length; i++) {
            idxSet.clear();
            search(0, i, 0, relation);
        }

        System.out.println(answer+=result);
    }

    static void search(int s, int size, int d, String[][] relation) {
        if(d == size) {
            for(HashSet<Integer> ck : box) {
                if(idxSet.containsAll(ck)) {
                    return;
                }
            }

            if(isUnique(relation)) {
                result++;
                box.add(idxSet);
            }
        } else {
            for(int i=s; i<relation[0].length; i++) {
                if(!visit[i]) continue;

                idxSet.add(i);
                search(i+1, size, d+1, relation);
                idxSet.remove(i);
            }
        }
    }


    static boolean isUnique(String[][] relation) {
        StringBuilder sb = new StringBuilder();
        set = new HashSet<>();

        for(int i=0; i<relation.length; i++) {
            for(int idx : idxSet) {
                sb.append(relation[i][idx]);
            }
            if(!set.add(sb.toString())) return false;
        }

        return true;
    }
}
