package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2212 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		if(K >= N) {
			System.out.println(0);
			return;
		}

		int sum = 0;
		int[] sensorArray = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sensorArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensorArray);

		Integer[] diffArray = new Integer[N - 1];
		for(int i = 0; i < N - 1; i++) {
			diffArray[i] = sensorArray[i + 1] - sensorArray[i];
		}

		Arrays.sort(diffArray, (((o1, o2) -> o2 - o1)));

		for(int i = K - 1; i < N - 1; i++) {
			sum += diffArray[i];
		}

		System.out.println(sum);
	}
}
