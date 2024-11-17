package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = bfs(N, K);

		System.out.println(count);
	}

	public static int bfs(int N, int K) {

		int MAX = 100000;

		boolean[] visited = new boolean[MAX + 1];

		Queue<Info> queue = new LinkedList<>();

		queue.add(new Info(N, 0));
		visited[N] = true;

		while(!queue.isEmpty()) {
			Info info = queue.poll();

			if(info.position == K) {
				return info.count;
			}

			if(info.position - 1 >= 0 && !visited[info.position - 1]) {
				visited[info.position - 1] = true;
				queue.add(new Info(info.position - 1, info.count + 1));
			}

			if(info.position + 1 <= MAX && !visited[info.position + 1]) {
				visited[info.position + 1] = true;
				queue.add(new Info(info.position + 1, info.count + 1));
			}

			if(info.position * 2 <= MAX && !visited[info.position * 2]) {
				visited[info.position * 2] = true;
				queue.add(new Info(info.position * 2, info.count + 1));
			}
		}

		return -1;
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
