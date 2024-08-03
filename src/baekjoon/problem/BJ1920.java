package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());

		int[] nArray = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nArray);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());

			int start = 0;
			int end = N - 1;

			while(true) {

				int next = (end - start) / 2;
				int position = start + next;

				if(next == 0) {
					if(input == nArray[start] || input == nArray[end]) {
						sb.append("1").append("\n");
					}
					else {
						sb.append("0").append("\n");
					}
					break;
				}

				if(input == nArray[position]) {
					sb.append("1").append("\n");
					break;
				}
				else if(input > nArray[position]) {
					start = position;
				}
				else if(input < nArray[position]) {
					end = position;
				}
			}
		}

		System.out.println(sb);
	}
}
