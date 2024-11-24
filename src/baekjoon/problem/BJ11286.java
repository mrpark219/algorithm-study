package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ11286 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
			if(Math.abs(o1) > Math.abs(o2)) {
				return Math.abs(o1) - Math.abs(o2);
			}
			else if(Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			}
			else {
				return -1;
			}
		}));

		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(priorityQueue.isEmpty()) {
					sb.append("0").append("\n");
				}
				else {
					sb.append(priorityQueue.poll()).append("\n");
				}
			}
			else {
				priorityQueue.offer(x);
			}
		}
		System.out.println(sb);
	}
}
