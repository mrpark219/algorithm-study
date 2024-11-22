package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1927 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		MinHeap minHeap = new MinHeap();

		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				sb.append(minHeap.extractMin()).append("\n");
			}
			else {
				minHeap.insert(input);
			}
		}

		System.out.println(sb);
	}

	public static class MinHeap {

		private final List<Integer> heap;

		public MinHeap() {
			this.heap = new ArrayList<>();
		}

		public void insert(int value) {
			heap.add(value);
			int index = heap.size() - 1;
			while(index > 0) {
				int parent = (index - 1) / 2;
				if(heap.get(index) >= heap.get(parent)) {
					break;
				}
				swap(index, parent);
				index = parent;
			}
		}

		public int extractMin() {
			if(heap.isEmpty()) {
				return 0;
			}

			int min = heap.get(0);
			int last = heap.remove(heap.size() - 1);

			if(!heap.isEmpty()) {
				heap.set(0, last);
				heapify(0);
			}

			return min;
		}

		public void heapify(int index) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			int smallest = index;

			if(left < heap.size() && heap.get(left) < heap.get(smallest)) {
				smallest = left;
			}
			if(right < heap.size() && heap.get(right) < heap.get(smallest)) {
				smallest = right;
			}

			if(smallest != index) {
				swap(index, smallest);
				heapify(smallest);
			}
		}

		private void swap(int i, int j) {
			int temp = heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j, temp);
		}
	}
}
