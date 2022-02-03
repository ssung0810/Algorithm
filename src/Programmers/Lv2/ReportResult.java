package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 신고 결과 받기
 * Date : 2022/02/01/
 */
public class ReportResult {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String[] id_list = new String[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            id_list[i] = st.nextToken();
        }

        n = Integer.parseInt(bf.readLine());
        String[] report = new String[n];
        for(int i=0; i<n; i++) {
            report[i] = bf.readLine();
        }
        int k = Integer.parseInt(bf.readLine());

        //////////////////////////////////////////////

        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            result.put(id_list[i], i);
        }

        for(int i=0; i< report.length; i++) {
            String[] name = report[i].split(" ");
            map.get(name[1]).add(name[0]);
        }

        for (String key : map.keySet()) {
            if(map.get(key).size() >= k) {
                Iterator<String> iterator = map.get(key).iterator();
                while (iterator.hasNext()) {
                    String name = iterator.next();
                    answer[result.get(name)]++;
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
