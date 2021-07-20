package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.omg.Messaging.SyncScopeHelper;

public class PhoneNumberClick {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		String hand = bf.readLine();
		
		////////////////////////////////////////
		
		Hand left = new Hand(4, 1, "L");
		Hand right = new Hand(4, 3, "R");
        String answer = "";
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                switch(numbers[i]) {
                    case 1: left = new Hand(1, 1, "L"); break;
                    case 4: left = new Hand(2, 1, "L"); break;
                    case 7: left = new Hand(3, 1, "L"); break;
                }
                answer += "L";
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                switch(numbers[i]) {
                    case 3: right = new Hand(1, 3, "R"); break;
                    case 6: right = new Hand(2, 3, "R"); break;
                    case 9: right = new Hand(3, 3, "R"); break;
                }
                answer += "R";
            } else {
                int middle = 0;
                switch(numbers[i]) {
                    case 2: middle = 1; break;
                    case 5: middle = 2; break;
                    case 8: middle = 3; break;
                    case 0: middle = 4; break;
                }
                
                int leftpos = Math.abs(left.row - middle) + Math.abs(left.col - 2);
                int rightpos = Math.abs(right.row - middle) + Math.abs(right.col - 2);
                
                if(leftpos > rightpos || (leftpos == rightpos && hand.equals("right"))) {
                	answer += "R";
                	right = new Hand(middle, 2, "M");
                } else if(leftpos < rightpos || (leftpos == rightpos && hand.equals("left"))) {
                	answer += "L";
                	left = new Hand(middle, 2, "M");
                }
            }
        }
        
        System.out.println(answer);
	}

}

class Hand {
    int row;
    int col;
    String pos;
    
    Hand(int row, int col, String pos) {
        this.row = row;
        this.col = col;
        this.pos = pos;
    }
}