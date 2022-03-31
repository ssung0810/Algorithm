package Programmers.test.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/* 오픈 채팅방
 * Date : 2022/03/30
 */
public class test2 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        String[] answer = solution(record);

        System.out.println(Arrays.toString(answer));
    }

    private static String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> user = new HashMap<>();

        test2 main = new test2();
        ArrayList<User> arr = main.getMessage(user, record);

        answer = main.result(user, arr);

        return answer;
    }

    private ArrayList<User> getMessage(HashMap<String, String> user, String[] record) {
        ArrayList<User> arr = new ArrayList<>();

        for(int i=0; i< record.length; i++) {
            String[] st = record[i].split(" ");

            switch (st[0]) {
                case "Enter" :
                    user.put(st[1], st[2]);
                    arr.add(new User(st[1], "님이 들어왔습니다."));
                    break;
                case "Leave":
                    arr.add(new User(st[1], "님이 나갔습니다."));
                    break;
                case "Change":
                    user.put(st[1], st[2]);
                    break;
            }
        }

        return arr;
    }

    private String[] result(HashMap<String, String> user, ArrayList<User> users) {
        String[] answer = new String[users.size()];
        StringBuilder sb;

        for (int i=0; i<users.size(); i++) {
            User u = users.get(i);
            sb = new StringBuilder();

            sb.append(user.get(u.userId)).append(u.message);
            answer[i] = sb.toString();
        }

        return answer;
    }

    class User {
        String userId;
        String message;

        public User(String userId, String message) {
            this.userId = userId;
            this.message = message;
        }
    }
}
