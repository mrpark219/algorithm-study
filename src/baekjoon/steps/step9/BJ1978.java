package baekjoon.steps.step9;

import java.util.Scanner;

public class BJ1978 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 0;

        for(int i = 0; i < N; i++) {

            boolean flag = true;
            int num = sc.nextInt();

            if(num == 1) {
                continue;
            }
            for(int j = 2; j <= Math.sqrt(num); j++) {
                if(num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                cnt++;
            }
        }
        System.out.println(cnt);

        sc.close();

    }
}
