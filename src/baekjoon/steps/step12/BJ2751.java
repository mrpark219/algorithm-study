package baekjoon.steps.step12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ2751 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for(int n : list) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);

        sc.close();

    }
}
