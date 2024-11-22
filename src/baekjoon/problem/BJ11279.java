package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ11279 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if(x == 0) {
				Integer n = priorityQueue.poll();
				if(n == null) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(n).append("\n");
				}
			}
			else {
				priorityQueue.add(x);
			}
		}

		System.out.println(sb);
	}
}
