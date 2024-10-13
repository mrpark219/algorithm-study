package programmers.problem;

import java.util.PriorityQueue;

public class P42626 {

	static class Solution {
		public int solution(int[] scoville, int K) {

			int count = 0;

			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
			for(int n : scoville) {
				priorityQueue.add(n);
			}

			while(priorityQueue.size() > 1 && priorityQueue.peek() < K) {

				int firstScoville = priorityQueue.poll();
				int secondScoville = priorityQueue.poll();

				int mixedScoville = firstScoville + (secondScoville * 2);

				priorityQueue.add(mixedScoville);

				count++;
			}

			if(priorityQueue.size() < 2 && priorityQueue.peek() < K) {
				return -1;
			}

			return count;
		}
	}
}
