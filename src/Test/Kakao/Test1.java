package Test.Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1 {
    public static void main(String[] args) throws Exception, NullPointerException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String[] id_list = new String[st.countTokens()];
        for(int i=0; i<id_list.length; i++) {
            id_list[i] = st.nextToken();
        }

        int M = Integer.parseInt(bf.readLine());
        String[] report = new String[M];
        for(int i=0; i<M; i++) {
            report[i] = bf.readLine();
        }

        int k = Integer.parseInt(bf.readLine());

        ///////////////////////////////////

        int[] answer = {};
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, String> user = new HashMap<>();

        for(int i=0; i<report.length; i++) {
            String key = report[i].split(" ")[1];

            String us = report[i].split(" ")[0];
            if(user.get(key) == null) {
                count.put(key, count.getOrDefault(key, 0) + 1);
                user.put(key, user.getOrDefault(key,"") + report[i].split(" ")[0]+",");
            } else if(user.get(key) != null && !user.get(key).contains(us)) {
                count.put(key, count.getOrDefault(key, 0) + 1);
                user.put(key, user.getOrDefault(key,"") + report[i].split(" ")[0]+",");
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        for(String key : count.keySet()) {
            if(count.get(key) >= k) {
                String[] userList = user.get(key).split(",");
                for(int i=0; i< userList.length; i++) {
                    result.put(userList[i], result.getOrDefault(userList[i], 0) + 1);
                }
            }
        }

        answer = new int[id_list.length];
        for(int i=0; i< id_list.length; i++) {
            if(result.get(id_list[i]) == null) {
                answer[i] = 0;
            } else {
                answer[i] = result.get(id_list[i]);
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
