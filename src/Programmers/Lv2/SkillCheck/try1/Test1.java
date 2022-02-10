package Programmers.Lv2.SkillCheck.try1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String number = bf.readLine();
        int k = Integer.parseInt(bf.readLine());

        //////////////////////////////////////////////

        String answer = "";
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder(number);

        char[] arrNumber = number.toCharArray();
        Arrays.sort(arrNumber);

//        int answerLen = number.length() - k;
//        for(int i=arrNumber.length-1; i>=0; i--) {
//            int idx = number.indexOf(arrNumber[i]);
//            if(number.length() - )
//        }

    }
}
