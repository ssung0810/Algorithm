package BaekJoon.Etc.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* 30
 * Date : 2022/07/02
 */
public class BJoon10610 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());

            sb.append(getCount(N, bf, sortedMap) + "\n");

            sortedMap.clear();
        }

        System.out.println(sb.toString());
    }

    private static int getCount(int N, BufferedReader bf, TreeMap<Integer, Integer> sortedMap) throws Exception {
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            sortedMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        return clearMap(sortedMap, 1);
    }

    private static int clearMap(TreeMap<Integer, Integer> sortedMap, Integer key) {
        int mainNum = sortedMap.get(key);
        int result = 1;

        for (int i = key+1; i <= sortedMap.size(); i++) {
            if(mainNum > sortedMap.get(i)) {
                result++;
                mainNum = sortedMap.get(i);
            }
        }

        return result;
    }
}