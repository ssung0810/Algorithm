package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tuples_kakao {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        /////////////////////////////////////

        int[] answer = {};

//        s = s.substring(1);
//        s = s.substring(0, s.length()-1);
//
//        String[] x = s.split("},");
//        String[][] m = new String[x.length][2];
//
//        for(int i=0; i<x.length; i++) {
//            m[i][0] = String.valueOf(x[i].length());
//
//            if(i == x.length-1) m[i][1] = x[i].substring(1, x[i].length()-1);
//            else m[i][1] = x[i].substring(1);
//        }
//
//        Arrays.sort(m, (e1, e2) -> {
//            return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
//        });
//
//        answer = new int[m.length];
//
//        HashMap<String, Integer> map = new HashMap<>();
//        answer[0] = Integer.parseInt(m[0][1]);
//        map.put(String.valueOf(answer[0]), 0);
//        for(int i=1; i<m.length; i++) {
//            for(int j=0; j<m[i][1].split(",").length; j++) {
//                if(!map.containsKey(m[i][1].split(",")[j])) {
//                    answer[i] = Integer.parseInt(m[i][1].split(",")[j]);
//                    map.put(String.valueOf(answer[i]), i);
//                }
//            }
//        }

        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        Set<String> a = new HashSet<>();
        System.out.println(a.add("1"));
        System.out.println(a.add("1"));

//        System.out.println(Arrays.toString(arr));
    }

}

class box {
    int num;
    String txt;

    box(int num, String txt) {
        this.num = num;
        this.txt = txt;
    }
}