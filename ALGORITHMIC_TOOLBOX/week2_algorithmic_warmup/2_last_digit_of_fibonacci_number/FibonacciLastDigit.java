import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    public static int getFibonacciLastDigitFast (int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0, sec = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = (first%10 + sec%10)%10;
            first = sec;
            sec = tmp;
        }
        return sec;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

