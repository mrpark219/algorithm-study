package baekjoon.steps.step6;

public class BJ15596 {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.sum(new int[]{1, 2, 3}));
    }
}

class Test {
    public long sum(int[] a) {

        long sum = 0;
        for(int num : a) {
            sum += num;
        }
        return sum;
    }
}
