package baekjoon.steps.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650 {

    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        func(1, 0, N, M);

        System.out.println(sb);

        br.close();
    }

    public static void func(int pos, int depth, int N, int M) {

        if(depth == M) {
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = pos; i <= N; i++) {
            arr[depth] = i;
            func(i + 1, depth + 1, N, M);
        }

    }
}
