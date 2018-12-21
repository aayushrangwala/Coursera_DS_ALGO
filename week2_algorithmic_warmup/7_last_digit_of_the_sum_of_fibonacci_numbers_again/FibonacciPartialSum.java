import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    public static long getPisanoPeriod (long m) {
        long a = 0, b = 1, c = a+b;
        for (long i = 0; i < m*m; i++) {
            c = (a%10 + b%10)%10;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                return i+1;
            }
        }
        return -1;
    }

    public static long getFibonacciPartialSumFast (long n, long m) {
         long sum_n = 0;
         long first = 0, sec = 1;
         for (long i = 0; i <= n; i++) {
            if (i >= m) {
                sum_n += first;
            }
            
            long tmp = (first%10+sec%10)%10;
            first = sec;
            sec = tmp;
         }
         return sum_n%10;
    }

    public static void stressTest () {
        while (true) {
            Random r = new Random();
            long n = r.nextLong();
            long m = r.nextLong();
            if (n == 0 || m == 0) {
                continue;
            }
            if (n < 0) {
                n *= -1;
            }
            if (m < 0) {
                m *= -1;
            }
            long small, large;
            if (n < m) {
                small = n;
                large = m;
            } else {
                small = m;
                large = n;
            }
            long res = getFibonacciPartialSumNaive(small, large);
            long res1 = getFibonacciPartialSumFast(small, large);
            if (res == res1) {
                System.out.println("OK");
            } else {
                System.out.println("Wrong Ans: " + res + " " + res1 + " " + n + " " + m);
                break;
            }
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        long x = getPisanoPeriod(10);
        from = from % x;
        to = to % x;
        long small, large;
        if (from < to) {
            small = from;
            large = to;
        } else {
            small = to;
            large = from;
        }
        System.out.println(getFibonacciPartialSumFast(large, small));
        //stressTest();
    }
}

