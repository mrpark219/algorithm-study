package baekjoon.steps.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {

    public static int[] numArr;
    public static int[] operArr = new int[4];
    public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operArr[i] = Integer.parseInt(st.nextToken());
        }

        func(numArr[0], 0);

        System.out.println(max);
        System.out.println(min);

        br.close();

    }

    public static void func(int value, int depth) {

        if(N == depth + 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operArr[i] > 0) {
                operArr[i]--;
                switch(i) {
                    case 0:
                        func(value + numArr[depth + 1], depth + 1);
                        break;
                    case 1:
                        func(value - numArr[depth + 1], depth + 1);
                        break;
                    case 2:
                        func(value * numArr[depth + 1], depth + 1);
                        break;
                    case 3:
                        func(value /= numArr[depth + 1], depth + 1);
                        break;
                }
                operArr[i]++;
            }

        }
    }

}
