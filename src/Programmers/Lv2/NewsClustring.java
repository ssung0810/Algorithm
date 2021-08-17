package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

/* [1차]뉴스 클러스트링
 * Date : 2021/08/16
 */
public class NewsClustring {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bf.readLine();
        String str2 = bf.readLine();

        //////////////////////////////////

        int answer = 0;

        str1 = str1.toUpperCase(Locale.ROOT);
        str2 = str2.toUpperCase(Locale.ROOT);

        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();

        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        int andCnt = 0;
        int orCnt = 0;

        for(int i=0; i<str1Arr.length-1; i++) {
            if(str1Arr[i] - 'A' >= 0 && str1Arr[i] - 'A' <= 25) {
                if(str1Arr[i+1] - 'A' >= 0 && str1Arr[i+1] - 'A' <= 25) {
                    String txt = new String(str1Arr, i, 2);
                    str1Map.put(txt, str1Map.getOrDefault(txt, 0) + 1);
                }
            }
        }

        for(int i=0; i<str2Arr.length-1; i++) {
            if (str2Arr[i] - 'A' >= 0 && str2Arr[i] - 'A' <= 25) {
                if (str2Arr[i + 1] - 'A' >= 0 && str2Arr[i + 1] - 'A' <= 25) {
                    String txt = new String(str2Arr, i, 2);
                    str2Map.put(txt, str2Map.getOrDefault(txt, 0) + 1);
                }
            }
        }

        HashMap<String, Integer> str2Map2 = (HashMap<String, Integer>) str2Map.clone();
        // 교집합 만들기
        for(String key : str1Map.keySet()) {
            int cnt = str1Map.get(key);
            while(cnt > 0) {
                if (str2Map2.containsKey(key) && str2Map2.get(key) > 0) {
                    andCnt++;
                    str2Map2.put(key, str2Map2.get(key) - 1);
                }
                cnt--;
            }
        }

        // 합집합 만들기
        for(String key : str1Map.keySet()) {
            int cnt = str1Map.get(key);
            while(cnt > 0) {
                orCnt++;
                if (str2Map.containsKey(key) && str2Map.get(key) > 0) {
                    str2Map.put(key, str2Map.get(key) - 1);
                }
                cnt--;
            }
        }

        for(String key : str2Map.keySet()) {
            int cnt = str2Map.get(key);
            while(cnt > 0) {
                orCnt++;
                str2Map.put(key, str2Map.get(key) - 1);
                cnt--;
            }
        }

        if(andCnt == 0 && orCnt == 0) answer = 65536;
        else answer = (int)(((double)andCnt / (double)orCnt) * 65536);

        System.out.println(answer);
    }
}
