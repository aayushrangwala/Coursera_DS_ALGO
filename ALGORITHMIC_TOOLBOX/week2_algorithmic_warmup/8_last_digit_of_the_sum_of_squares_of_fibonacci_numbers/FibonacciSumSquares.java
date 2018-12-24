import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }


    private static long getFibonacciSumSquaresFast (long n) {
        if (n <= 1) {
            return n;
        }
        long sum = 1, first = 0, sec = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = (first%10 + sec%10) % 10;
            sum += (tmp*tmp)%10;
            first = sec;
            sec = tmp;
        }
        return sum%10;
    }

    private static void stressTest () {
        while (true) {
            Random r = new Random();
            long n = r.nextLong();
            long res = getFibonacciSumSquaresNaive(n);
            long res1 = getFibonacciSumSquaresFast(n);
            if (res == res1) {
                System.out.println("OK");
            } else {
                System.out.println("Wrong Ans: " + res + " " + res1 + " " + n);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long x = 60;
        n %= x;
        System.out.println(getFibonacciSumSquaresFast(n));
        //stressTest();
    }
}

