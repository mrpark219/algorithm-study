package baekjoon.steps.step9;

import java.util.Scanner;

public class BJ4948 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input;
        boolean[] primeArr = new boolean[246913];

        primeArr[0] = true;
        primeArr[1] = true;

        for(int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            for(int j = i * i; j < primeArr.length; j += i) {
                primeArr[j] = true;
            }
        }

        while(true) {
            input = sc.nextInt();

            if(input == 0) {
                break;
            }

            int cnt = 0;
            for(int i = input + 1; i <= input * 2; i++) {
                if(!primeArr[i]) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }

        sc.close();

    }
}
