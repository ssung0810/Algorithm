package BaekJoon.QueueAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 큐 2
 * Created by qkrtjdcjf124
 * Date : 2021/06/16
 */
public class BJoon18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		
		innerQueue q = new innerQueue(N);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			switch(st.nextToken()) {
				case "push": q.push(Integer.parseInt(st.nextToken())); break;
				case "pop": sb.append(q.pop() + "\n"); break;
				case "front": sb.append(q.front() + "\n"); break;
				case "back": sb.append(q.back() + "\n"); break;
				case "size": sb.append(q.size() + "\n"); break;
				case "empty": sb.append(q.empty() + "\n"); break;
			}
		}
		
		System.out.println(sb);
	}

}

class innerQueue {
	private int size = 0;
	private Object[] array;
	private int front = 0;
	private int rear = 0;
	
	public innerQueue(int capacity) {
		array = new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	public void push(int item) {
		rear = (rear+1)%array.length;
		array[rear] = item;
		size++;
	}
	
	public int pop() {
		if(size == 0) return -1;
		
		front = (front+1)%array.length;
		int value = (int)array[front];
		array[front] = null;
		size--;
		return value;
	}
	
	public int size() {
		return size;
	}
	
	public int empty() {
		return size == 0 ? 1 : 0;
	}
	
	public int front() {
		if(size == 0) return -1;
		
		return (int)array[front+1];
	}
	
	public int back() {
		if(size == 0) return -1;
		
		return (int)array[rear];
	}
}