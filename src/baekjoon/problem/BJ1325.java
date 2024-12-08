package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1325 {

	public static List<Integer>[] connectInfo;
	public static int[] count;
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = new int[N + 1];
		connectInfo = new List[N + 1];

		for(int i = 1; i <= N; i++) {
			connectInfo[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			connectInfo[A].add(B);
		}

		for(int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			bfs(i, visited);
		}

		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, count[i]);
		}

		for(int i = 1; i <= N; i++) {
			if(count[i] == max) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}

	public static void bfs(int startNode, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		visited[startNode] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();

			for(int child : connectInfo[current]) {
				if(!visited[child]) {
					visited[child] = true;
					count[child]++;
					queue.add(child);
				}
			}
		}
	}
}
