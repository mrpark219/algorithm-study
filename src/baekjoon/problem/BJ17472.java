package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ17472 {

	static int[][] map;
	static boolean[][] checkMap;
	static int islandCount = 0;
	static final int[] directionX = {1, -1, 0, 0};
	static final int[] directionY = {0, 0, 1, -1};
	static List<int[]> connectionList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		checkMap = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					input = -1;
				}
				map[i][j] = input;
			}
		}

		countIsland();

		getConnection();

		int count = 0;
		int valueCount = 0;
		int[] parentArray = new int[islandCount + 1];

		for(int i = 1; i < islandCount; i++) {
			parentArray[i] = i;
		}

		connectionList.sort((o1, o2) -> o1[2] - o2[2]);
		int index = 0;

		while(index < connectionList.size()) {

			int[] connection = connectionList.get(index);

			int a = connection[0];
			int b = connection[1];
			int value = connection[2];
			index++;

			if(value < 2) {
				continue;
			}

			if(!isSameParent(parentArray, a, b)) {
				union(parentArray, a, b);
				count++;
				valueCount += value;

				if(count == islandCount - 1) {
					System.out.println(valueCount);
					return;
				}
			}
		}

		System.out.println(-1);
	}

	public static int find(int[] parentArray, int a) {
		if(parentArray[a] == a) {
			return a;
		}
		return parentArray[a] = find(parentArray, parentArray[a]);
	}

	public static void union(int[] parentArray, int a, int b) {
		a = find(parentArray, a);
		b = find(parentArray, b);

		if(a < b) {
			parentArray[b] = a;
		}
		else {
			parentArray[a] = b;
		}
	}

	public static boolean isSameParent(int[] parentArray, int a, int b) {
		return find(parentArray, a) == find(parentArray, b);
	}

	public static void getConnection() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {

				if(map[i][j] == 0) {
					continue;
				}

				int island = map[i][j];

				int nowX = j;
				int nowY = i;

				for(int a = nowX - 1; a >= 0; a--) {
					if(map[nowY][a] == island) {
						break;
					}
					else if(map[nowY][a] != 0) {
						connectionList.add(new int[]{island, map[nowY][a], nowX - a - 1});
						break;
					}
				}
				for(int a = nowX + 1; a < map[0].length; a++) {
					if(map[nowY][a] == island) {
						break;
					}
					else if(map[nowY][a] != 0) {
						connectionList.add(new int[]{island, map[nowY][a], a - nowX - 1});
						break;
					}
				}
				for(int a = nowY - 1; a >= 0; a--) {
					if(map[a][nowX] == island) {
						break;
					}
					else if(map[a][nowX] != 0) {
						connectionList.add(new int[]{island, map[a][nowX], nowY - a - 1});
						break;
					}
				}
				for(int a = nowY + 1; a < map.length; a++) {
					if(map[a][nowX] == island) {
						break;
					}
					else if(map[a][nowX] != 0) {
						connectionList.add(new int[]{island, map[a][nowX], a - nowY - 1});
						break;
					}
				}
			}
		}
	}

	public static void countIsland() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(!checkMap[i][j] && map[i][j] == -1) {
					islandCount++;
					countIslandBfs(i, j);
				}
			}
		}
	}

	public static void countIslandBfs(int y, int x) {

		if(map[y][x] == 0 || checkMap[y][x]) {
			return;
		}

		map[y][x] = islandCount;
		checkMap[y][x] = true;

		for(int i = 0; i < 4; i++) {
			int moveX = x + directionX[i];
			int moveY = y + directionY[i];

			if(moveY >= 0 && moveY < map.length && moveX >= 0 && moveX < map[0].length) {
				countIslandBfs(moveY, moveX);
			}
		}
	}
}
