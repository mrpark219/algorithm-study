package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3151 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] scoreArray = new int[N];

		for(int i = 0; i < N; i++) {
			scoreArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(scoreArray);

		long count = 0;

		for(int i = 0; i < N; i++) {

			// 음의 범위일 때만 조합 찾기
			if(scoreArray[i] > 0) {
				break;
			}
			int start = i + 1;
			int end = N - 1;

			while(start < end) {
				int s = 1;
				int e = 1;
				int current = scoreArray[i] + scoreArray[start] + scoreArray[end];

				if(current == 0) {

					if(scoreArray[start] == scoreArray[end]) {
						count += (long) (end - start + 1) * (end - start) / 2;
						break;
					}

					while(start + 1 < end && scoreArray[start] == scoreArray[start + 1]) {
						s++;
						start++;
					}

					while(start < end - 1 && scoreArray[end] == scoreArray[end - 1]) {
						e++;
						end--;
					}

					count += (long) s * e;
				}

				if(current > 0) {
					end--;
				}
				else {
					start++;
				}
			}
		}

		System.out.println(count);
	}
}
