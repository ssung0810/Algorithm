package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 메뉴 리뉴얼
 * Date : 2021/11/10
 */
public class MenuRenewal {
    static HashMap<String, Integer> setMenu = new HashMap<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] orders = new String[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            orders[i] = st.nextToken();
        }
        int m = Integer.parseInt(bf.readLine());
        int[] course = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<m; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        //////////////////////////////////////////////////

        int[][] menuSel = new int[course.length][2];
        for(int i=0; i<course.length; i++) {
            int c = course[i];
            menuSel[i][0] = c;
            max = 0;

            for(String menu : orders) {
                char[] imsi = menu.toCharArray();
                Arrays.sort(imsi);
                menu = new String(imsi);

                if(menu.length() > c) {
                    setMenu(menu, "", 0, c);
                } else if(menu.length() == c) {
                    setMenu.put(menu, setMenu.getOrDefault(menu, 0) + 1);
                    max = Math.max(setMenu.get(menu), max);
                }
            }

            menuSel[i][1] = max;
        }

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<course.length; i++) {
            for (String key : setMenu.keySet()) {
                if (setMenu.get(key) > 1 && key.length() == course[i] && setMenu.get(key) == menuSel[i][1]) {
                    arr.add(key);
                }
            }
        }

        Collections.sort(arr);

        String[] answer = new String[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    static void setMenu(String menu, String txt, int s, int c) {
        if(txt.length() == c) {
            setMenu.put(txt, setMenu.getOrDefault(txt, 0) + 1);
            max = Math.max(setMenu.get(txt), max);
        }

        for(int i=s; i<menu.length(); i++) {
            setMenu(menu, txt+menu.charAt(i), i+1, c);
        }
    }
}
