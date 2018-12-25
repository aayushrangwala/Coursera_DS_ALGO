import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        Arrays.sort(a, new Comparator<String> () {
            @Override
            public int compare (String X, String Y) {
                String XY = X+Y;
                String YX = Y+X;
                long xy = Long.parseLong(XY);
                long yx = Long.parseLong(YX);
                if (xy > yx) {
                    return -1;
                } else if (xy < yx) {
                    return 1;
                }
                return 0;
                //return (XY.compareTo(YX) > 0) ? -1 : 1;
            }
        });
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

