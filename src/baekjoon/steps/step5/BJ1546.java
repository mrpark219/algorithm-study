package baekjoon.steps.step5;

import java.util.Scanner;

public class BJ1546 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;
        double sum = 0.0;

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        for(int i = 0; i < N; i++) {
            sum += (double) arr[i] / max * 100;
        }

        System.out.println(sum / N);

        sc.close();

    }
}
