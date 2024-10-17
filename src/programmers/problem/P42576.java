package programmers.problem;

import java.util.HashMap;
import java.util.Map;

public class P42576 {

	static class Solution {
		public String solution(String[] participant, String[] completion) {

			Map<String, Integer> participantMap = new HashMap<>();
			for(int i = 0; i < participant.length; i++) {
				participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) + 1);
			}

			for(int i = 0; i < completion.length; i++) {
				participantMap.put(completion[i], participantMap.get(completion[i]) - 1);
			}


			for(String key : participantMap.keySet()) {
				if(participantMap.get(key) > 0) {
					return key;
				}
			}

			return "";
		}
	}
}
