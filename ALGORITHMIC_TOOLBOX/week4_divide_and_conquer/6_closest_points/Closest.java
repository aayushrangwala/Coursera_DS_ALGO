import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(long[] x, long y[]) {
        //double ans = Double.POSITIVE_INFINITY;
        //write your code here
        Point[] list_x = new Point[x.length];
        Point[] list_y = new Point[y.length];
        for (int i = 0; i < x.length; i++) {
            list_x[i] = new Point(x[i], y[i]);
            list_y[i] = list_x[i];
        }
        Arrays.sort(list_y);
        Arrays.sort(list_x, new Comparator<Point> () {
            @Override
            public static int compare (Point p1, Point p2) {
                long x = p1.x;
                long y = p1.y;
                
                return o.x == x ? Long.signum(y - o.y) : Long.signum(x - o.x);
            }
        });

        return closestPairUtil(list_x, list_y, 0, x.length);

        //return ans;
    }


    static double closestPairUtil (Point[] list_x, Point[] list_y, int l, int r) {
        double ans = Double.POSITIVE_INFINITY;

        if (r-l <= 3) {
            return bruteForce(list_x, l, r);
        }    
        int mid = l + (r-l)/2;
        Point p_mid = list_x[mid];

        long[] list_y_left = new long[mid+1];//0 to mid inclusive
        long[] list_y_right = new long[n-mid-1];//mid+1 to n inclusive

        int a = 0, int b = 0;
        for (int i = 0; i < list_y.length; i++) {
            if (list_y[i].x <= p_mid.x) {
                list_y_left[a++] = list_y[i];
            } else {
                list_y_right[b++] = list_y[i];
            }
        }

        double d_left = closestPairUtil(list_x, list_y_left, l, mid);
        double d_right = closestPairUtil(list_x, list_y_right, mid+1, r);

        double d = Math.min(d_left, d_right);

        List<Point> strip = new ArrayList<Point>();

        for (int i = l; i < r; i++) {
            if (Math.abs(list_y[i].x - p_mid.x) < d) {
                strip.add(list_y[i]);
            }
        }
        ans = Math.min(d, stripClosest(strip, d));
        return ans;
    }

    public static double stripClosest (List<Point> list, double d) {
        double min = d;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size() && (list.get(i).y - list.get(j).y) < min; j++) {//It is proofed that for every i,
                //there are at most '7' j such that (point[i]-point[j]) > 0, means fter 7th J dist will increase
                double tmp = distance(list.get(i), list.get(j));
                min = (min > tmp) ? tmp : min;
            }
        }
        return min;
    }

    public static double distance (Point p1, Point p2) {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        long[] x = new long[n];
        long[] y = new long[n];
        for (long i = 0; i < n; i++) {
            x[i] = nextLong();
            y[i] = nextLong();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
