package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        String s = "abcd";

        String a = s.substring(0, s.indexOf("b", 1));
        System.out.println(s.substring(0,2)+s.substring(3));
        System.out.println(s.indexOf(a));
    }
}