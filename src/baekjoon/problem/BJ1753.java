package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1753 {

	public static final int INF = Integer.MAX_VALUE;
	public static int[] distance;
	public static List<Node>[] graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		distance = new int[V + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		graph = new List[V + 1];

		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(V, start);

		for(int i = 1; i <= V; i++) {
			if(distance[i] == INF) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(distance[i]).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void dijkstra(int V, int start) {

		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
		priorityQueue.offer(new Node(start, 0));

		while(!priorityQueue.isEmpty()) {
			Node currentNode = priorityQueue.poll();
			int currentIndex = currentNode.index;
			int currentWeight = currentNode.weight;

			// distance 배열에 저장된 값이 더 작으면 continue
			if(currentWeight > distance[currentIndex]) {
				continue;
			}

			// 현재 노드와 연결된 노드 처리
			for(Node node : graph[currentIndex]) {
				int connectIndex = node.index;
				int connectWeight = node.weight;

				if(distance[connectIndex] > distance[currentIndex] + connectWeight) {
					distance[connectIndex] = distance[currentIndex] + connectWeight;
					priorityQueue.offer(new Node(connectIndex, distance[connectIndex]));
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
