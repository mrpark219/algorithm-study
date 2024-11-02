package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1197 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int[][] info = new int[e][3];

		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			info[i][0] = start;
			info[i][1] = end;
			info[i][2] = value;
		}

		Arrays.sort(info, ((o1, o2) -> o1[2] - o2[2]));

		int[] parent = new int[v + 1];
		for(int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		int count = 0;
		int index = 0;
		int answer = 0;

		while(count < v - 1 && index < e) {
			int start = info[index][0];
			int end = info[index][1];
			int value = info[index][2];

			if(!isSameParent(parent, start, end)) {
				union(parent, start, end);
				answer += value;
				count++;
			}

			index++;
		}

		System.out.println(answer);
	}

	public static int find(int[] parent, int n) {
		if(parent[n] == n) {
			return n;
		}

		return parent[n] = find(parent, parent[n]);
	}

	public static void union(int[] parent, int a, int b) {
		a = find(parent, a);
		b = find(parent, b);

		if(a < b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
	}

	public static boolean isSameParent(int[] parent, int a, int b) {
		a = find(parent, a);
		b = find(parent, b);

		return a == b;
	}
}
