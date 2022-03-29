package BaekJoon;

public class Main {

    public static void main(String[] args) {

        String a = "abc123abc";

        System.out.println(a.replaceAll("a", "="));          // =bc123=bc
        System.out.println(a.replaceAll("[bc1]", "="));      // a===23a==
        System.out.println(a.replaceAll("[b12]", "="));      // a=c==3a=c
        System.out.println(a.replaceAll("b|1|2", "="));      // a=c==3a=c
        System.out.println(a.replaceAll("[^12]", "="));      // ===12====
    }
}