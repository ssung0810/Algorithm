package Programmers.Lv3;

import java.util.Arrays;
import java.util.HashMap;

/* 다단계 칫솔 판매
 * Date : 2022/03/23
 */
public class ToothbrushSale {
    public static void main(String[] args) {
//        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//        String[] seller = {"young", "john", "tod", "emily", "mary"};
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};

        int[] answer = solution(enroll, referral, seller, amount);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        HashMap<String, Integer> enrollMap = new HashMap<>();
        HashMap<Integer, String> referralMap = new HashMap<>();
        HashMap<String, Integer> resultMap = new HashMap<>();

        setEnrollMap(enroll, enrollMap);
        setReferralMap(referral, referralMap);

        for (int i=0; i<seller.length; i++) {
            String s = seller[i];
            int originalMoney = amount[i] * 100;
            int money = 0;

            while(true) {
                int enrollMan = enrollMap.get(s);
                String referralMan = referralMap.get(enrollMan);

                money = getMoney(originalMoney);

                if(originalMoney - money < 1) {
                    resultMap.put(s, resultMap.getOrDefault(s, 0) + originalMoney);
                    break;
                } else if(referralMan.equals("-")) {
                    resultMap.put(s, resultMap.getOrDefault(s, 0) + originalMoney - money);
                    break;
                }

                resultMap.put(s, resultMap.getOrDefault(s, 0) + originalMoney - money);

                originalMoney = money;
                s = referralMan;
            }
        }

        for(int i=0; i<enroll.length; i++) {
            if(resultMap.containsKey(enroll[i])) {
                answer[i] = resultMap.get(enroll[i]);
            }
        }

        return answer;
    }

    static void setEnrollMap(String[] enroll, HashMap<String, Integer> enrollMap) {
        for(int i=0; i<enroll.length; i++) {
            enrollMap.put(enroll[i], i);
        }
    }
    static void setReferralMap(String[] referral, HashMap<Integer, String> referralMap) {
        for(int i=0; i<referral.length; i++) {
            referralMap.put(i, referral[i]);
        }
    }

    static int getMoney(int money) {
        return (int) (money * 0.1);
    }
}
