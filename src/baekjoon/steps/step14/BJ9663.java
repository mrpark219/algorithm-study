package baekjoon.steps.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663 {

    /*
        2차원 배열이 아닌 1차원 배열을 사용할 수 있는 이유
        => 같은 행 혹은 열에는 퀸이 존재할 수 없기 때문
     */
    public static int[] position;
    public static int cnt = 0;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        position = new int[N];

        func(0);

        System.out.println(cnt);
        br.close();

    }

    public static void func(int depth) {

        if(N == depth) {
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++) {
            position[depth] = i;
            if(possible(depth)) {
                func(depth + 1);
            }
        }

    }

    public static boolean possible(int depth) {

        for(int i = 0; i < depth; i++) {
            if(position[depth] == position[i]) {
                //같은 행
                return false;
            }
            else if(Math.abs(depth - i) == Math.abs(position[depth] - position[i])) {
                //대각선
                return false;
            }
        }
        return true;

    }

}
