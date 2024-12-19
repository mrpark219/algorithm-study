package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3190 {

	public static int[] moveX = {-1, 0, 1, 0};
	public static int[] moveY = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];

		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			map[A][B] = 1;
		}

		int L = Integer.parseInt(br.readLine());

		Map<Integer, String> commandMap = new HashMap<>();

		for(int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();

			commandMap.put(second, direction);
		}

		int time = 0;
		int direction = 3;
		Deque<Point> snackDeque = new LinkedList<>();

		snackDeque.offer(new Point(1, 1));

		while(true) {
			time++;

			Point head = snackDeque.peek();
			int nextX = head.x + moveX[direction];
			int nextY = head.y + moveY[direction];

			// 종료조건
			if(nextX < 1 || nextX > N || nextY < 1 || nextY > N || checkContains(snackDeque, nextX, nextY)) {
				break;
			}

			snackDeque.offerFirst(new Point(nextX, nextY));

			// 사과 처리 - 사과가 없다면 길이 줄이기
			if(map[nextX][nextY] == 0) {
				snackDeque.pollLast();
			}
			else {
				map[nextX][nextY] = 0;
			}

			// 방향 처리
			if(commandMap.containsKey(time)) {
				if(commandMap.get(time).equals("L")) {
					direction = (direction + 1) % 4;
				}
				else {
					direction = (direction + 3) % 4;
				}
			}
		}

		System.out.println(time);
	}

	public static boolean checkContains(Deque<Point> deque, int x, int y) {
		for(Point point : deque) {
			if(point.x == x && point.y == y) {
				return true;
			}
		}
		return false;
	}

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
