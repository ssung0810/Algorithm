package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 순위 검색
 * Date : 2021/09/26
 */
public class RankingSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] info = new String[N];
        for(int i=0; i<N; i++) {
            info[i] = bf.readLine();
        }

        int M = Integer.parseInt(bf.readLine());
        String[] query = new String[N];
        for(int i=0; i<M; i++) {
            query[i] = bf.readLine();
        }

        /////////////////////////////////////////////

        int[] answer = new int[query.length];

        HashMap<Integer, Integer> success = new HashMap<>();
        for(int i=0; i<info.length; i++) {
            success.put(i, 0);
        }

        for(int i=0; i< query.length; i++) {
            String[] arr = query[i].replaceAll("and ", "").split(" ");
            int cnt = 0;

            for(int j=0; j<arr.length; j++) {
                if(!arr[j].equals("-")) {
                    for(int k=0; k<info.length; k++) {
                        if(j == 4) {
                            int num = Integer.parseInt(info[k].split(" ")[4]);
                            if(num >= Integer.parseInt(arr[j])) {
                                success.put(k, success.getOrDefault(k, 0) + 1);
                            }
                        } else if(info[k].contains(arr[j])) {
                            success.put(k, success.getOrDefault(k, 0) + 1);
                        }
                    }
                    cnt++;
                }
            }

            int result = 0;
            for(int key : success.keySet()) {
                if(success.get(key) == cnt) result++;
                success.put(key, 0);
            }
            answer[i] = result;
        }

        for(int num : answer) {
            System.out.print(num + " ");
        }
    }
}
