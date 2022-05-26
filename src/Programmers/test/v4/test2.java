package Programmers.test.v4;

import java.util.*;

/* 메뉴 리뉴얼
 * Date : 2022/04/01
 */
public class test2 {

    static int max = 0;

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        String[] answer = solution(orders, course);

        System.out.println(Arrays.toString(answer));
    }

    private static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        courseMenu[] arr = new courseMenu[course.length];
        for (int i=0; i<course.length; i++) {
            courseMenu cm = new courseMenu();
            cm.setNum = course[i];

            HashMap<String, Integer> map = new HashMap<>();
            getArray(orders, map, cm);

            cm.menu = map;
            arr[i] = cm;
        }

        TreeSet<String> set = new TreeSet<>();

        for(int i=0; i<arr.length; i++) {
            courseMenu cm = arr[i];
            HashMap<String, Integer> menu = cm.menu;
            int maxValue = cm.max;

            for(String key : menu.keySet()) {
                System.out.println(key + " :: "+ menu.get(key) + " :: " + maxValue);
                if(maxValue == menu.get(key)) {
                    set.add(key);
                }
            }
        }

        answer = new String[set.size()];
        int cnt = 0;
        for (String s : set) {
            answer[cnt] = s;
        }

        return answer;
    }

    private static void getArray(String[] orders, HashMap<String, Integer> map, courseMenu cm) {
//        System.out.println(1);
        for(int i=0; i<orders.length; i++) {
            dfs(map, orders[i], new StringBuilder(), 0, cm.setNum);
            cm.max = Math.max(cm.max, max);
            max = 0;
//            System.out.println(cm.max);
        }

    }

    private static void dfs(HashMap<String, Integer> map, String order, StringBuilder sb, int s, int course) {
//        System.out.println(2);
        if(s >= order.length()) return;

        if(sb.length() == course) {
            String txt = sb.toString();
            map.put(txt, map.getOrDefault(txt, 0) + 1);

            max = Math.max(max, map.get(txt));
            sb = new StringBuilder();

            return;
        }

        for(int i=s; i<order.length(); i++) {
            sb.append(order.charAt(i));

            dfs(map, order, sb, i+1, course);
        }
    }
}

class courseMenu {
    int setNum;
    HashMap<String, Integer> menu = new HashMap<>();
    int max;


}