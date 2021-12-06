package baekjoon.steps.step5;

import java.util.HashSet;
import java.util.Scanner;

public class BJ3052 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < 10; i++) {
            hashSet.add(sc.nextInt() % 42);
        }

        System.out.println(hashSet.size());

        sc.close();
    }
}
