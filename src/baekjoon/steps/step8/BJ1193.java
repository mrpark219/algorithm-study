package baekjoon.steps.step8;

import java.util.Scanner;

public class BJ1193 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int cnt = 0;

        sc.close();

        for(int i = 2; ; i++) {
            for(int j = 1; j < i; j++) {
                cnt++;
                if(X == cnt) {
                    if((i - 1) % 2 == 0) {
                        System.out.println(j + "/" + (i - j));
                    }
                    else {
                        System.out.println((i - j) + "/" + j);
                    }
                    return;
                }
            }
        }

    }
}
