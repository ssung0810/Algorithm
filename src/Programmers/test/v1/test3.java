package Programmers.test.v1;

import java.util.ArrayList;

/* 추석 트래픽
 * Date : 2022/03/28
 */
public class test3 {

    class startAndEnd {
        private int start = 0;
        private int end = 0;

        startAndEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
//        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
//        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
//                "2016-09-15 20:59:58.233 1.181s",
//                "2016-09-15 20:59:58.299 0.8s",
//                "2016-09-15 20:59:58.688 1.041s",
//                "2016-09-15 20:59:59.591 1.412s",
//                "2016-09-15 21:00:00.464 1.466s",
//                "2016-09-15 21:00:00.741 1.581s",
//                "2016-09-15 21:00:00.748 2.31s",
//                "2016-09-15 21:00:00.966 0.381s",
//                "2016-09-15 21:00:02.066 2.62s"};

        int answer = solution(lines);
        System.out.println(answer);
    }

    public static int solution(String[] lines) {
        int answer = 0;
        int max = 0;

        test3 test3 = new test3();

        ArrayList<startAndEnd> arr = new ArrayList<>();

        for (String line : lines) {
            String[] time = line.split(" ");

            test3.setTime(time[1].replaceAll("[.:]", ""), time[2].replace("s", ""), arr);
        }

        for (startAndEnd startAndEnd : arr) {
            max = Math.max(test3.getCount(startAndEnd.start, startAndEnd.end, arr), max);
        }

        return max;
    }

    void setTime(String time, String loading, ArrayList<startAndEnd> arr) {
        int start = (int) (Double.parseDouble(loading) * 1000-1);

        arr.add(new startAndEnd(Integer.parseInt(time)-start, Integer.parseInt(time)));
    }

    int getCount(int start, int end, ArrayList<startAndEnd> arr) {
        int count = 0;

        for (startAndEnd startAndEnd : arr) {
            System.out.println(start + " :: " + end + " :: " + startAndEnd.start);
            if (start <= startAndEnd.start && startAndEnd.start <= end) {
//                System.out.println(start + " :: " + end + " :: " + startAndEnd.start);
                count++;
                continue;
            } else if (start <= startAndEnd.end && startAndEnd.end <= end) {
//                System.out.println(start + " :: " + end + " :: " + startAndEnd.start);
                count++;
            }
        }

        return count;
    }
}
