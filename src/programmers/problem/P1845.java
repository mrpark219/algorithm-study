package programmers.problem;

import java.util.HashSet;
import java.util.Set;

public class P1845 {

	static class Solution {
		public int solution(int[] nums) {

			Set<Integer> numSet = new HashSet<>();

			for(int n : nums) {
				numSet.add(n);
			}

			int resultSize = nums.length / 2;

			if(resultSize >= numSet.size()) {
				return numSet.size();
			}
			else {
				return resultSize;
			}
		}
	}
}
