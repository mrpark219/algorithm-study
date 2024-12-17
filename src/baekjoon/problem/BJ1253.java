package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		int count = 0;

		for(int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;

			while(true) {
				if(i == left) {
					left++;
				}
				else if(i == right) {
					right--;
				}

				if(left >= right) {
					break;
				}

				if(input[left] + input[right] > input[i]) {
					right--;
				}
				else if(input[left] + input[right] < input[i]) {
					left++;
				}
				else {
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}
}
