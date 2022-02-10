package Programmers.Lv2.SkillCheck.try2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        //////////////////////////////////////////////

        int[] answer = {};
        HashSet<String> set = new HashSet<>();

        s = s.substring(2, s.length() - 2).replaceAll("},\\{", " ");
        String[] arr = s.split(" ");

        answer = new int[arr.length];

        Arrays.sort(arr, comp);
        set.add(arr[0]);
        answer[0] = Integer.parseInt(arr[0]);

        String[] list;
        for(int i=1; i<arr.length; i++) {
            list = arr[i].split(",");

            for(int j=0; j<list.length; j++) {
                if(set.add(list[j])) {
                    answer[i] = Integer.parseInt(list[j]);
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }

    static Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()) {
                return 1;

            }
            return -1;
        }
    };
}
