package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1374 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> waitingQueue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			waitingQueue.add(new int[]{index, startTime, endTime});
		}

		PriorityQueue<Integer> progressQueue = new PriorityQueue<>();

		while(!waitingQueue.isEmpty()) {
			int[] current = waitingQueue.poll();
			int startTime = current[1];
			int endTime = current[2];

			if(!progressQueue.isEmpty() && progressQueue.peek() <= startTime) {
				progressQueue.poll();
			}

			progressQueue.add(endTime);
		}

		System.out.println(progressQueue.size());
	}
}
