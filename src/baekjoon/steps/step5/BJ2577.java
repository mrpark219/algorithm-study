package baekjoon.steps.step5;

import java.util.Scanner;

public class BJ2577 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[10];

        int N = A * B * C;

        while(N > 0) {
            arr[N % 10]++;
            N = N / 10;
        }

        for(int result : arr) {
            System.out.println(result);
        }
        sc.close();
    }
}
