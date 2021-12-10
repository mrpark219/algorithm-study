package baekjoon.steps.step6;

import java.util.Scanner;

public class BJ1065 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(han(N));

        sc.close();

    }

    public static int han(int n) {

        int hanCnt = 0;

        for(int i = 1; i <= n; i++) {
            if(i < 100) {
                hanCnt++;
            }
            else if(i > 1000) {
                break;
            }
            else {
                int i100 = i / 100;
                int i10 = i / 10 % 10;
                int i1 = i % 10;

                if(i100 - i10 == i10 - i1) {
                    hanCnt++;
                }
            }
        }

        return hanCnt;
    }
}
