package baekjoon.steps.step5;

import java.util.Scanner;

public class BJ2562 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int max = -1;
        int maxPosition = 0;

        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            if(max < arr[i]) {
                max = arr[i];
                maxPosition = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(maxPosition);

        sc.close();

    }
}
