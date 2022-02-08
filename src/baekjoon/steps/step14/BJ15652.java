package baekjoon.steps.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652 {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        func(N, M, 0);

        System.out.println(sb);

        br.close();

    }

    public static void func(int N, int M, int depth) {

        if(M == depth) {
            for(int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(depth > 0 && arr[depth - 1] > i + 1) {
                continue;
            }
            else {
                arr[depth] = i + 1;
                func(N, M, depth + 1);
            }
        }

    }
}
