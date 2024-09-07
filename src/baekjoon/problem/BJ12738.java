package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ12738 {

	public static long[] inputArray;
	public static List<Long> tailList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			long input = Long.parseLong(st.nextToken());

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

	public static int binarySearch(long n) {

		int start = 0;
		int end = tailList.size() - 1;

		while(start <= end)	{
			int mid = start + (end - start) / 2;

			if(tailList.get(mid) == n) {
				return mid;
			}
			else if(n > tailList.get(mid)) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}

		return start;
	}
}
