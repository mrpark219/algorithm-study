package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ3078 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] inputArray = new String[N];

		for(int i = 0; i < N; i++) {
			inputArray[i] = br.readLine();
		}

		long count = 0;
		Map<Integer, Integer> lengthMap = new HashMap<>();

		for(int i = 0; i < N; i++) {
			int targetLength = inputArray[i].length();

			count += lengthMap.getOrDefault(targetLength, 0);

			lengthMap.put(targetLength, lengthMap.getOrDefault(targetLength, 0) + 1);

			if(i >= K) {
				int removeLength = inputArray[i - K].length();
				lengthMap.put(removeLength, lengthMap.get(removeLength) - 1);

				if(lengthMap.get(removeLength) == 0) {
					lengthMap.remove(removeLength);
				}
			}
		}

		System.out.println(count);
	}
}
