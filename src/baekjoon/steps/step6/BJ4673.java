package baekjoon.steps.step6;

public class BJ4673 {

    public static void main(String[] args) {

        boolean[] arr = new boolean[10001];

        for(int i = 1; i <= 10000; i++) {
            int n = d(i);

            if(n <= 10000) {
                arr[n] = true;
            }
        }


        for(int j = 1; j <= 10000; j++) {
            if(!arr[j]) {
                System.out.println(j);
            }
        }

    }

    public static int d(int number) {
        int sum = number;

        while(number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
