package Programmers.test.v4;

import java.util.Stack;

/* 신규 아이디 추천
 * Date : 2022/03/31
 */
public class test1 {

    public static void main(String[] args) {
        String new_id = "=.=";

        String answer = solution(new_id);

        System.out.println(answer);
    }

    private static String solution(String new_id) {
        String answer = "";

        answer = getLower(new_id);
        answer = deleteText(answer);
        answer = deleteDoubleComma(answer);
        answer = deleteComma(answer);
        if(answer.equals("")) answer = "a";
        answer = maxLen(answer);
        answer = minLen(answer);

        return answer;
    }

    private static String getLower(String id) {
        return id.toLowerCase();
    }

    private static String deleteText(String id) {
        return id.replaceAll("[^a-z0-9._-]", "");
    }

    private static String deleteDoubleComma(String id) {
        Stack<Character> stack = new Stack<>();
        stack.add(id.charAt(0));

        for (int i = 1; i < id.length(); i++) {
            if(id.charAt(i) != '.' || stack.peek() != '.') {
                stack.add(id.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    private static String deleteComma(String id) {
        if(id.length() == 1 && id.equals(".")) return "";

        if (id.charAt(0) == '.' && id.charAt(id.length() - 1) == '.') {
            return id.substring(1, id.length() - 1);
        } else if (id.charAt(0) == '.') {
            return id.substring(1);
        } else if (id.charAt(id.length() - 1) == '.') {
            return id.substring(0, id.length() - 1);
        }

        return id;
    }

    private static String maxLen(String id) {
        if(id.length() > 15) {
            id = id.substring(0, 15);

            return deleteComma(id);
        }

        return id;
    }

    private static String minLen(String id) {
        if (id.length() < 3) {
            char c = id.charAt(id.length() - 1);

            while(id.length() < 3) {
                id += c;
            }
        }

        return id;
    }
}
