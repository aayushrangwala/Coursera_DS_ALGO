import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static int getFibonacciLastDigitFast (int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0, sec = 1;
        for (int i = 2; i <= n; i_++) {
            int tmp = (first%10 + sec%10)%10;
            first = sec;
            sec = tmp;
        }
        return sec;
    }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(getFibonacciLastDigitFast(n));
  }
}
