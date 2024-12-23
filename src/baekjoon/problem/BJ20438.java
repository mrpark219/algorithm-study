package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ20438 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] studentArray = new boolean[N + 3];
		Set<Integer> sleepSet = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			sleepSet.add(Integer.valueOf(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++) {
			int current = Integer.parseInt(st.nextToken());

			if(sleepSet.contains(current)) {
				continue;
			}

			if(!studentArray[current]) {
				for(int j = current; j < N + 3; j++) {
					if(j % current == 0) {
						if(!sleepSet.contains(j)) {
							studentArray[j] = true;
						}
					}
				}
			}
		}

		int[] cumSum = new int[N + 3];
		for(int i = 3; i < cumSum.length; i++) {
			cumSum[i] = cumSum[i - 1] + ((!studentArray[i]) ? 1 : 0);
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			System.out.println(cumSum[e] - cumSum[s - 1]);
		}
	}
}
