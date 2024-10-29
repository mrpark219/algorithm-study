package programmers.problem;

public class P340212 {

	static class Solution {
		public int solution(int[] diffs, int[] times, long limit) {

			int minLevel = 1;
			int maxLevel = 0;
			for(int diff : diffs) {
				maxLevel = Math.max(maxLevel, diff);
			}

			int level = maxLevel;

			while(minLevel <= maxLevel) {

				level = minLevel + (maxLevel - minLevel) / 2;

				if(check(level, diffs, times, limit)) {
					if(!check(level - 1, diffs, times, limit)) {
						break;
					}
					else {
						maxLevel = level - 1;
					}
				}
				else {
					minLevel = level + 1;
				}

			}

			return level;
		}

		public boolean check(int level, int[] diffs, int[] times, long limit) {

			long count = 0;

			for(int i = 0; i < diffs.length; i++) {
				int diff = diffs[i];
				int time = times[i];

				if(diff <= level) {
					count += time;
				}
				else {
					count += (long) (diff - level) * (time + (i > 0 ? times[i - 1] : 0)) + time;
				}

				if(count > limit) {
					return false;
				}
			}

			return limit >= count;
		}
	}
}
