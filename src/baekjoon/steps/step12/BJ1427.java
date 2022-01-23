package baekjoon.steps.step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = Integer.parseInt(input);
        ArrayList<Integer> arr = new ArrayList<>();

        int i = 0;
        while(N != 0) {
            arr.add(N % 10);
            N /= 10;
            i++;
        }

        arr.sort(Collections.reverseOrder());

        for(int n : arr) {
            System.out.print(n);
        }

        br.close();

    }
}
