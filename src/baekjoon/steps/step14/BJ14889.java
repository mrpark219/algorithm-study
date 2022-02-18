package baekjoon.steps.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {

    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0);

        System.out.println(min);

        br.close();

    }

    public static void func(int index, int depth) {

        if(depth == N / 2) {
            getDipp();
            return;
        }

        for(int i = index; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                func(i + 1, depth + 1);
                visit[i] = false;
            }
        }

    }

    public static void getDipp() {
        int startPoint = 0;
        int linkPoint = 0;

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visit[i] && visit[j]) {
                    startPoint += map[i][j];
                    startPoint += map[j][i];
                }
                else if(!visit[i] && !visit[j]) {
                    linkPoint += map[i][j];
                    linkPoint += map[j][i];
                }
            }
        }

        int val = Math.abs(startPoint - linkPoint);

        if(val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }

}
