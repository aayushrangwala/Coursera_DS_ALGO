import java.util.*;

public class GCD {
  private static long gcd_naive(long a, long b) {
    long current_gcd = 1;
    for(long d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static long gcd_fast(long a, long b) {
    if (b == 0) {
        return a;
    }
    return gcd_fast(b, a%b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();
    System.out.println(gcd_fast(a, b));
    
    //stressTest(200000000);
  }

public static void stressTest (long N) {
  while (true) {
      Random r = new Random();
  long a = r.nextLong();
  long b = r.nextLong();
  if (a < 0) {
      a *= -1;
  }
  if (b < 0) {
      b *= -1;
  }
  if (a == 0 || b == 0) {
      continue;
  }
  long res = gcd_naive(a, b);
  long res1 = gcd_fast(a, b);
  if (res == res1) {
    System.out.println("OK ");
  } else {
    System.out.println("Wrong Ans: " + res + " " + res1 + " " + a + ", " + b);
    break;
  }
  }
  
}

}
