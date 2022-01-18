package baekjoon.steps.step11;

import java.util.Scanner;

public class BJ1436{

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int num = 666;
        int cnt = 1;

        while(cnt != N) {
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }

        System.out.println(num);

        sc.close();

    }
}
