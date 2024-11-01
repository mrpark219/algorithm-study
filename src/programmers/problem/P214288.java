package programmers.problem;

import java.util.*;

public class P214288 {

	static class Solution {
		List<List<Integer>> orders = new ArrayList<>();

		public int solution(int k, int n, int[][] reqs) {
			int answer = Integer.MAX_VALUE;
			Integer[] area = new Integer[k + 1];
			Arrays.fill(area, 1);
			dfs(n - k, 1, new ArrayList<>(Arrays.asList(area)));

			for(List<Integer> order : orders) {
				answer = Math.min(answer, simulation(k, order, reqs));
			}
			return answer;
		}

		// 경우의 수 찾기
		void dfs(int remain, int index, List<Integer> area) {
			if(remain <= 0) {
				orders.add(area);
				return;
			}

			for(int i = index; i < area.size(); i++) {
				area.set(i, area.get(i) + 1);
				dfs(remain - 1, i, new ArrayList<>(area));
				area.set(i, area.get(i) - 1);
			}
		}

		// 기다리는 시간 구하기
		int simulation(int k, List<Integer> order, int[][] reqs) {
			PriorityQueue<Integer>[] pq = new PriorityQueue[k + 1];
			int result = 0;

			for(int i = 1; i <= k; i++) {
				pq[i] = new PriorityQueue<>();
				for(int j = 0; j < order.get(i); j++) pq[i].add(0);
			}

			for(int[] req : reqs) {
				int arrive = req[0];
				int time = req[1];
				int idx = req[2];

				int picked = pq[idx].poll();

				if(picked > arrive) {
					result += picked - arrive;
					pq[idx].add(picked + time);
				}
				else if(picked < arrive) {
					pq[idx].add(arrive + time);
				}
				else {
					pq[idx].add(picked + time);
				}
			}

			return result;
		}
	}

}
