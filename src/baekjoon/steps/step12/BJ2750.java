package baekjoon.steps.step12;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2750 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int n : arr) {
            System.out.println(n);
        }

        sc.close();

    }
}
