package baekjoon.steps.step9;

import java.util.Scanner;

public class BJ1002 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            //완전 일치
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            }
            //외접할 때, 내접할 때
            else if(distance == Math.pow(r1 + r2, 2) || distance == Math.pow(r2 - r1, 2)) {
                System.out.println(1);
            }
            //두 원의 반지름 길이의 합보다 길이가 더 멀 때, 원안에 원이 있지만 서로 접하지 않을 때
            else if(distance > Math.pow(r1 + r2, 2) || distance < Math.pow(r2 - r1, 2)) {
                System.out.println(0);
            }
            else {
                System.out.println(2);
            }

        }

        sc.close();

    }
}
