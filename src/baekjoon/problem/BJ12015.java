package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ12015 {

	public static List<Integer> tailList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());

			int position = binarySearch(input);

			if(position == tailList.size()) {
				tailList.add(input);
			}
			else {
				tailList.set(position, input);
			}
		}

		System.out.println(tailList.size());
	}

	public static int binarySearch(int number) {

		int left = 0;
		int right = tailList.size() - 1;

		while(left <= right) {
			int mid = left + (right - left) / 2;

			if(tailList.get(mid) == number) {
				return mid;
			}
			else if(number > tailList.get(mid)) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		return left;
	}
}
