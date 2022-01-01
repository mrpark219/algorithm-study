package baekjoon.steps.step9;

import java.util.Scanner;

public class BJ2581 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] primeArr = new boolean[N + 1];

        primeArr[0] = true;
        primeArr[1] = true;

        for(int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            for(int j = i * i; j < primeArr.length; j += i) {
                primeArr[j] = true;
            }
        }

        int sum = 0;
        int min = -1;

        for(int i = M; i <= N; i++) {
            if(!primeArr[i]) {
                sum += i;
                if(min == -1) {
                    min = i;
                }
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }

        sc.close();

    }
}
