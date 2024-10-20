package programmers.problem;

import java.util.LinkedList;
import java.util.Queue;

public class P12906 {

	static class Solution {
		public int[] solution(int[] arr) {

			Queue<Integer> queue = new LinkedList<>();

			int temp = -1;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == temp) {
					continue;
				}
				else {
					temp = arr[i];
					queue.add(temp);
				}
			}

			int[] result = new int[queue.size()];
			for(int i = 0; i < result.length; i++) {
				result[i] = queue.poll();
			}

			return result;
		}
	}
}
