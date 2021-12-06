package baekjoon.steps.step5;

import java.util.Scanner;

public class BJ4344 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        for(int i = 0; i < C; i++) {
            int N = sc.nextInt();

            double sum = 0;
            int[] arr = new int[N];
            for(int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }

            double avg = sum / N;

            int cnt = 0;
            for(int k = 0; k < N; k++) {
                if(arr[k] > avg) {
                    cnt++;
                }
            }

            System.out.printf("%.3f%%\n", Math.round((double) cnt / N * 100 * 1000) / 1000.0);
        }

        sc.close();

    }
}
