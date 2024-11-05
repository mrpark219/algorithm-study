package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ6497 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if(m == 0 && n == 0) {
				break;
			}

			int[][] connectionInfo = new int[n][3];

			int originCost = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());

				connectionInfo[i][0] = x;
				connectionInfo[i][1] = y;
				connectionInfo[i][2] = z;
				originCost += z;
			}

			Arrays.sort(connectionInfo, ((o1, o2) -> o1[2] - o2[2]));

			int[] parentArray = new int[m];
			for(int i = 0; i < m; i++) {
				parentArray[i] = i;
			}

			int minCost = 0;
			int count = 0;
			int index = 0;
			while(count < m - 1 || index < n) {

				int x = connectionInfo[index][0];
				int y = connectionInfo[index][1];
				int z = connectionInfo[index][2];

				if(!isSameParent(parentArray, x, y)) {
					union(parentArray, x, y);
					minCost += z;
					count++;
				}
				index++;
			}

			sb.append(originCost - minCost).append("\n");
		}

		System.out.println(sb);
	}

	public static int find(int[] parentArray, int a) {
		if(parentArray[a] == a) {
			return a;
		}
		return parentArray[a] = find(parentArray, parentArray[a]);
	}

	public static void union(int[] parentArray, int a, int b) {
		a = find(parentArray, a);
		b = find(parentArray, b);

		if(a < b) {
			parentArray[b] = a;
		}
		else {
			parentArray[a] = b;
		}
	}

	public static boolean isSameParent(int[] parentArray, int a, int b) {
		return find(parentArray, a) == find(parentArray, b);
	}
}
