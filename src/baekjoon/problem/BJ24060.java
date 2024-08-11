package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ24060 {

	public static int[] tmp;
	public static int count = 0;
	public static int saveCount = -1;
	public static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] A = new int[N + 1];
		tmp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(A, 1, N);

		System.out.println(saveCount);
	}

	public static void merge_sort(int[] A, int p, int r) {


		if(p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 1;

		while(i <= q && j <= r) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
			}
			else {
				tmp[t++] = A[j++];
			}
		}

		while(i <= q) {
			tmp[t++] = A[i++];
		}
		while(j <= r) {
			tmp[t++] = A[j++];
		}
		i = p;
		t = 1;
		while(i <= r) {
			count++;
			if(count == K) {
				saveCount = tmp[t];
			}
			A[i++] = tmp[t++];
		}
	}
}
