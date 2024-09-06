package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ31964 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] xArray = new int[N];
		int[] tArray = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			xArray[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tArray[i] = Integer.parseInt(st.nextToken());
		}

		int position = xArray[N - 1];
		int xPosition = N - 1;
		int spendTime = xArray[N - 1];

		while(xPosition >= 0) {
			if(xArray[xPosition] == position) {
				while(tArray[xPosition] > spendTime) {
					spendTime++;
				}
				xPosition--;
			}
			else {
				spendTime++;
				position--;
			}
		}
		spendTime += position;

		System.out.println(spendTime);
	}
}
