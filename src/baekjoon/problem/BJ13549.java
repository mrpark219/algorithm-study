package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ13549 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = bfs01(N, K);

		System.out.println(count);
	}

	public static int dijkstra(int N, int K) {

		int MAX = 100000;

		int[] distance = new int[MAX + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		PriorityQueue<Info> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);

		priorityQueue.add(new Info(N, 0));
		distance[N] = 0;

		while(!priorityQueue.isEmpty()) {
			Info info = priorityQueue.poll();

			if(info.position == K) {
				return info.count;
			}

			if(info.position - 1 >= 0 && info.count + 1 < distance[info.position - 1]) {
				distance[info.position - 1] = info.count + 1;
				priorityQueue.add(new Info(info.position - 1, info.count + 1));
			}

			if(info.position + 1 <= MAX && info.count + 1 < distance[info.position + 1]) {
				distance[info.position + 1] = info.count + 1;
				priorityQueue.add(new Info(info.position + 1, info.count + 1));
			}

			if(info.position * 2 <= MAX && info.count < distance[info.position * 2]) {
				distance[info.position * 2] = info.count;
				priorityQueue.add(new Info(info.position * 2, info.count));
			}
		}

		return distance[K];
	}

	public static int bfs01(int N, int K) {
		int MAX = 100000;

		int[] distance = new int[MAX + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		Deque<Info> deque = new LinkedList<>();

		deque.offer(new Info(N, 0));
		distance[N] = 0;

		while(!deque.isEmpty()) {
			Info info = deque.poll();

			if(info.position == K) {
				return info.count;
			}

			if(info.position - 1 >= 0 && info.count + 1 < distance[info.position - 1]) {
				distance[info.position - 1] = info.count + 1;
				deque.offer(new Info(info.position - 1, info.count + 1));
			}

			if(info.position + 1 <= MAX && info.count + 1 < distance[info.position + 1]) {
				distance[info.position + 1] = info.count + 1;
				deque.offer(new Info(info.position + 1, info.count + 1));
			}

			if(info.position * 2 <= MAX && info.count < distance[info.position * 2]) {
				distance[info.position * 2] = info.count;
				deque.addFirst(new Info(info.position * 2, info.count));
			}
		}

		return distance[K];
	}

	public static class Info {
		int position;
		int count;

		public Info(int position, int count) {
			this.position = position;
			this.count = count;
		}
	}
}
