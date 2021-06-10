package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 스택
 * Created by qkrtjdcjf124
 * Date : 2021/06/10
 */
public class BJoon10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack s = new Stack();
		
		int N = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			switch(st.nextToken()) {
				case "push": s.push(Integer.parseInt(st.nextToken())); break;
				case "pop": sb.append(s.pop() + "\n"); break;
				case "size": sb.append(s.size() + "\n"); break;
				case "empty": sb.append(s.empty() + "\n"); break;
				case "top": sb.append(s.top() + "\n"); break;
			}
		}
		System.out.println(sb);
	}
}

class Stack {
	private static final Object[] EMPTY_ARRAY = {};
	private static final int DEFAULT_CAPACITY = 10;
	
	private int size = 0;
	
	Object[] array;
	
	public Stack() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	
	public void resize() {
		int capacity = array.length;
		
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		
		if(size == capacity) {
			int new_capacity = array.length * 2;
			array = Arrays.copyOf(array, new_capacity);
		}
	}
	
	public void push(int value) {
		resize();
		
		array[size] = value;
		size++;
	}
	
	public int pop() {
		if(size == 0) {
			return -1;
		}

		size--;
		return (int)array[size];
	}
	
	public int size() {
		return size;
	}
	
	public int empty() {
		return size == 0 ? 1 : 0;
	}
	
	public int top() {
		if(size == 0) {
			return -1;
		}
		
		return (int)array[size-1];
	}
}
