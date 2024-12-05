package baekjoon.problem;

import java.io.*;
import java.util.*;

public class BJ3758 {

	public static int N, K, T, M;
	public static int[] logRequestCnt, logLatestRequestTime;
	public static int[][] logHighestScore;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		int C = Integer.parseInt(br.readLine());

		while(C-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			logHighestScore = new int[N][K];
			logRequestCnt = new int[N];
			logLatestRequestTime = new int[N];

			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int teamId = Integer.parseInt(st.nextToken()) - 1;
				int questId = Integer.parseInt(st.nextToken()) - 1;
				int score = Integer.parseInt(st.nextToken());

				logHighestScore[teamId][questId] = Math.max(logHighestScore[teamId][questId], score);
				logRequestCnt[teamId]++;
				logLatestRequestTime[teamId] = i + 1;
			}

			int[][] forSort = new int[N][4];
			for(int i = 0; i < N; i++) {
				forSort[i][0] = getAllScoreTeam(i);
				forSort[i][1] = logRequestCnt[i];
				forSort[i][2] = logLatestRequestTime[i];
				forSort[i][3] = i;
			}

			Arrays.sort(forSort, (o1, o2) -> {
				if(o1[0] != o2[0]) {
					return Integer.compare(o2[0], o1[0]);
				}
				if(o1[1] != o2[1]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[2], o2[2]);
			});

			for(int i = 0; i < N; i++) {
				if(forSort[i][3] == T - 1) {
					sb.append(i + 1).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}

	public static int getAllScoreTeam(int teamId) {
		int totalScore = 0;
		for(int score : logHighestScore[teamId]) {
			totalScore += score;
		}
		return totalScore;
	}
}
