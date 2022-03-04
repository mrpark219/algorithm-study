package baekjoon.steps.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {

    public static int[] arr;
    public static Integer[] dp_r;
    public static Integer[] dp_l;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp_r = new Integer[N];
        dp_l = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for(int i = 0; i < N; i++) {
            max = Math.max(dp_r[i] + dp_l[i], max);
        }

        System.out.println(max - 1);

        br.close();

    }

    public static int LIS(int n) {

        if(dp_r[n] == null) {
            dp_r[n] = 1;

            for(int i = n - 1; i >= 0; i--) {
                if(arr[i] < arr[n]) {
                    dp_r[n] = Math.max(dp_r[n], LIS(i) + 1);
                }
            }
        }

        return dp_r[n];

    }

    public static int LDS(int n) {

        if(dp_l[n] == null) {
            dp_l[n] = 1;

            for(int i = n + 1; i < N; i++) {
                if(arr[i] < arr[n]) {
                    dp_l[n] = Math.max(dp_l[n], LDS(i) + 1);
                }
            }
        }

        return dp_l[n];

    }
}
