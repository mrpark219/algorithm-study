package programmers.problem;

import java.util.HashMap;
import java.util.Map;

public class P340211 {

	static class Solution {

		public int solution(int[][] points, int[][] routes) {

			int[][] robot = new int[routes.length][2];
			int[] routeIndex = new int[routes.length];
			boolean[] completed = new boolean[routes.length];
			int completedCount = 0;

			// 로봇 초기 위치 설정
			for(int i = 0; i < routes.length; i++) {
				int point = routes[i][0];
				robot[i][0] = points[point - 1][0];
				robot[i][1] = points[point - 1][1];
			}

			int count = 0;
			Map<String, Integer> positionMap = new HashMap<>();

			while(completedCount < routes.length) {
				positionMap.clear();

				for(int i = 0; i < routes.length; i++) {
					if(completed[i]) continue;

					int targetPoint = routes[i][routeIndex[i]] - 1;
					int targetR = points[targetPoint][0];
					int targetC = points[targetPoint][1];

					if(robot[i][0] != targetR) {
						robot[i][0] += (targetR - robot[i][0] > 0 ? 1 : -1);
					}
					else if(robot[i][1] != targetC) {
						robot[i][1] += (targetC - robot[i][1] > 0 ? 1 : -1);
					}

					// 목적지 도착 시 다음 포인트로 이동
					if(robot[i][0] == targetR && robot[i][1] == targetC) {
						routeIndex[i]++;
						if(routeIndex[i] == routes[i].length) {
							completed[i] = true;
							completedCount++;
						}
					}

					// 현재 위치 저장
					String key = robot[i][0] + "," + robot[i][1];
					positionMap.put(key, positionMap.getOrDefault(key, 0) + 1);
				}

				// 충돌 체크
				for(int n : positionMap.values()) {
					if(n > 1) {
						count++;
					}
				}
			}

			return count;
		}
	}
}
