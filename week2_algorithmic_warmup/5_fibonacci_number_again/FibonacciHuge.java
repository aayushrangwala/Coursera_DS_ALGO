import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getPisanoPeriod (long m) {
        long a = 0, b = 1, c = a+b;
        for (long i = 0; i < m*m; i++) {
            c = (a+b)%m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                return i+1;
            }
        }
        return -1;  
    }

    private static long getFibonacciSumFast (long n) {
        if (n <= 1) {
            return n;
        }
        long first = 0, sec = 1, sum = 1;
        for (long i = 2; i <= n; i++) {
            long tmp = (first+sec)%10;
            sum += tmp;
            first = sec;
            sec = tmp;
        }
        return sum%10;
    }

    private static void stressTest () {
        while (true) {
            Random r = new Random();
            long n = r.nextInt(10);
            long res = getFibonacciSumNaive(n);
            long res1 = getFibonacciSumFast(n);
            if (res == res1) {
                System.out.println("OK");
            } else {
                System.out.println("Wrong Ans " + res + " " + res1 + " " + n);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long x = getPisanoPeriod(m);
        System.out.println(getFibonacciHugeFast(n%m));
    }
}

