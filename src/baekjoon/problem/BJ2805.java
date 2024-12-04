package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long[] trees = new long[N];

		long max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		long start = 0;
		long end = max;
		long result = 0;

		while(start <= end) {
			long mid = (start + end) / 2;

			long total = 0;
			for(long tree : trees) {
				if(tree > mid) {
					total += tree - mid;
				}
			}

			if(total >= M) {
				result = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}

		System.out.println(result);
	}
}
