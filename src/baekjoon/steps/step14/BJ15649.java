package baekjoon.steps.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        func(N, M, 0);

        System.out.println(sb);

        br.close();

    }

    public static void func(int N, int M, int depth) {

        if(depth == M) {
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                func(N, M, depth + 1);
                visit[i] = false;
            }

        }

    }
}
