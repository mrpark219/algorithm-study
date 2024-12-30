package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1449 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int count = 0;
		float previous = -10000;

		int[] positionArray = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			positionArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(positionArray);

		for(int position : positionArray) {

			if(previous + L < position + 0.5) {
				count++;
				previous = position - 0.5F;
			}
		}

		System.out.println(count);
	}
}
