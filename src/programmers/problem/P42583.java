package programmers.problem;

import java.util.LinkedList;
import java.util.Queue;

public class P42583 {

	static class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {

			Queue<Integer> truckQueue = new LinkedList<>();
			Queue<Integer> timeQueue = new LinkedList<>();

			int time = 0;
			int currentWeight = 0;
			int index = 0;


			while(index < truck_weights.length || !timeQueue.isEmpty()) {

				if(!timeQueue.isEmpty() && time - timeQueue.peek() >= bridge_length) {
					currentWeight -= truckQueue.remove();
					timeQueue.remove();
				}
				if(index < truck_weights.length && currentWeight + truck_weights[index] <= weight) {
					currentWeight += truck_weights[index];
					truckQueue.add(truck_weights[index]);
					timeQueue.add(time);
					index++;
				}

				time++;
			}

			return time;
		}
	}
}
