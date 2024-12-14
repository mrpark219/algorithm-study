package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1059 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());

		int[] input = new int[L];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < L; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int N = Integer.parseInt(br.readLine());

		int start = 0;
		int end = 1000;

		for(int i = 0; i < L; i++) {
			if(input[i] < N) {
				if(input[i] > start) {
					start = input[i];
				}
			}
			else if(input[i] > N) {
				if(input[i] < end) {
					end = input[i];
				}
			}
			else {
				System.out.println(0);
				return;
			}
		}

		int count = 0;

		for(int i = start + 1; i <= N; i++) {
			for(int j = N; j <= end - 1; j++) {
				if(i != j) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
