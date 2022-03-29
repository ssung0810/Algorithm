package Programmers.test.v2;

/* 셔틀버스
 * Date : 2022/03/08
 */
public class test3 {

    public static void main(String[] args) {
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        String answer = solution(n, t, m, timetable);

        System.out.println(answer);
    }

    private static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        while (n-- > 0) {
            System.out.println(n);
        }

        return answer;
    }
}
