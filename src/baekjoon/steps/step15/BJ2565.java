package baekjoon.steps.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2565 {

    public static int N;
    public static int[][] arr;
    public static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new Integer[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, func(i));
        }

        System.out.println(N - max);

        br.close();

    }

    public static int func(int n) {

        if(dp[n] == null) {

            dp[n] = 1;

            for(int i = n + 1; i < N; i++) {
                if(arr[n][1] < arr[i][1]) {
                    dp[n] = Math.max(dp[n], func(i) + 1);
                }
            }

        }

        return dp[n];
    }
}
