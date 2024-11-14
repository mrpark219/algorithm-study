package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1504 {

	public static List<Node>[] graph;
	public static int[] distance;
	public static final int INF = 800 * 1000 * 3;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		graph = new List[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		dijkstra(v1);
		long v1To1 = distance[1];
		long v1Tov2 = distance[v2];
		long v1Ton = distance[N];

		dijkstra(v2);
		long v2To1 = distance[1];
		long v2Ton = distance[N];

		long sum = Math.min(v1To1 + v1Tov2 + v2Ton, v2To1 + v1Tov2 + v1Ton);

		if(sum >= INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));

		priorityQueue.offer(new Node(start, 0));

		Arrays.fill(distance, INF);
		distance[start] = 0;

		while(!priorityQueue.isEmpty()) {
			Node current = priorityQueue.poll();
			int currentIndex = current.index;
			int currentWeight = current.weight;

			if(distance[currentIndex] < currentWeight) {
				continue;
			}

			for(Node node : graph[currentIndex]) {
				int nextIndex = node.index;
				int nextWeight = node.weight;

				if(distance[nextIndex] > distance[currentIndex] + nextWeight) {
					distance[nextIndex] = distance[currentIndex] + nextWeight;
					priorityQueue.offer(new Node(nextIndex, distance[nextIndex]));
				}
			}
		}
	}

	public static class Node {
		public int index;
		public int weight;

		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
}
