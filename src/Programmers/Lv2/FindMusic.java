package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [3차]방금 그곡
 * Date : 2021/12/03
 */
public class FindMusic {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String m = bf.readLine();
        String[] musicinfos = new String[2];
        for(int i=0; i<2; i++) {
            musicinfos[i] = bf.readLine();
        }

        ////////////////////////////////////////////////

        String answer = "(None)";
        ArrayList<music> arr = new ArrayList<>();
        StringBuilder sb;

        m = blackKey(m);

        for(int i=0; i<musicinfos.length; i++) {
            int time = getTime(musicinfos[i].split(",")[0], musicinfos[i].split(",")[1]);
            String name = musicinfos[i].split(",")[2];
            String sheet = blackKey(musicinfos[i].split(",")[3]);
            arr.add(new music(time, name, sheet));
        }

        Collections.sort(arr, comp);

        for(music ms : arr) {
            int time = ms.time;
            String t = ms.sheet;
            sb = new StringBuilder();

            if(time < t.length()) {
                t = t.substring(0, time);
            } else if(time > t.length()) {
                int cnt = time/t.length();
                String txt = "";
                while(cnt-- > 0 ) {
                    sb.append(t);
                }

                if(time % t.length() > 0) {
                    cnt = time%t.length();
                    for(int i=0; i<cnt; i++) {
                        sb.append(t.charAt(i));
                    }
                }

                t = sb.toString();
            }

            if(t.contains(m)) {
                answer = ms.name;
                break;
            }
        }

        System.out.println(answer);
    }

    static int getTime(String s, String e) {
        int time = 0;

        String[] s_arr = s.split(":");
        String[] e_arr = e.split(":");
        int hour = Integer.parseInt(e_arr[0]) - Integer.parseInt(s_arr[0]);
        time = Integer.parseInt(e_arr[1]) - Integer.parseInt(s_arr[1]);

        if(hour > 0) time += hour*60;

        return time;
    }

    static Comparator<music> comp = new Comparator<music>() {
        @Override
        public int compare(music o1, music o2) {
            if(o1.time <= o2.time) {
                return 1;
            }

            return -1;
        }
    };

    static String blackKey(String t) {
        t = t.replaceAll("C#", "H");
        t = t.replaceAll("D#", "I");
        t = t.replaceAll("F#", "J");
        t = t.replaceAll("G#", "K");
        t = t.replaceAll("A#", "L");

        return t;
    }
}

class music {
    int time;
    String name;
    String sheet;

    public music(int time, String name, String sheet) {
        this.time = time;
        this.name = name;
        this.sheet = sheet;
    }
}
