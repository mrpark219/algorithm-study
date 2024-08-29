package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {

	public static int[] array;
	public static int[] rank;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		array = new int[n + 1];
		rank = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			array[i] = i;
			rank[i] = 0;
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int operator = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(operator == 0) {
				if(a == b) {
					continue;
				}
				union(a, b);
			}
			else {
				if(isUnion(a, b)) {
					sb.append("YES");
				}
				else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	public static int find(int n) {
		if(n == array[n]) {
			return n;
		}
		else {
			// 경로 압축 - 루트 노드를 바라보도록 전체 변경
			int index = find(array[n]);
			array[n] = index;
			return index;
		}
	}

	public static boolean isUnion(int a, int b) {
		int aFind = find(a);
		int bFind = find(b);

		return aFind == bFind;
	}

	public static void union(int a, int b) {
		int aFind = find(a);
		int bFind = find(b);

		if(aFind == bFind) {
			return;
		}

		if(rank[aFind] > rank[bFind]) {
			array[bFind] = aFind;
		}
		else if(rank[bFind] > rank[aFind]) {
			array[aFind] = bFind;
		}
		else {
			array[bFind] = aFind;
			rank[aFind]++;
		}
	}
}
