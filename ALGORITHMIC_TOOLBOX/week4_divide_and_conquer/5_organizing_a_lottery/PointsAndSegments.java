import java.util.*;

public class PointsAndSegments {

    static class Pair {
        int value;
        String type;
        int index;

        Pair (int v, String t, int i) {
            value = v;
            type = t;
            index = i;
        }
    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < starts.length; i++) {
            list.add(new Pair(starts[i], "l", i));
        }
        for (int i = 0; i < ends.length; i++) {
            list.add(new Pair(ends[i], "r", i));
        }
        for (int i = 0; i < points.length; i++) {
            list.add(new Pair(points[i], "p", i));
        }

        Collections.sort(list, new Comparator<Pair> () {
            @Override
            public int compare (Pair a, Pair b) {
                int v1 = a.value;
                int v2 = b.value;

                if (v1 == v2) {
                    if ("p".equals(a.type) && "l".equals(b.type)) {
                        return 1;
                    } else if ("r".equals(a.type) && "p".equals(b.type)) {
                        return 1;
                    } else if ("r".equals(a.type) && "l".equals(b.type)) {
                        return 1;
                    } else if ((a.type).equals(b.type)) {
                        return 0;
                    }
                    return -1;
                }
                return (v1 > v2) ? 1: -1;
            }
        });
    
        /*for (Pair pp : list) {
            if ("p".equals(pp.type)) {
                System.out.println(pp.value + " " + pp.index);
            }
        }*/
        
        int leftCount = 0;
        for (Pair p : list) {
            int v = p.value;
            int ind = p.index;
            String t = p.type;
            if (t.equals("l"))
                leftCount++;
            else if (t.equals("r"))
                leftCount--;
            else {
                if (leftCount < 0) {
                    leftCount = 0;
                }
                cnt[ind] += leftCount;
            }
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
        //stressTest(50000, 50000, 10000000);
    }

    /*public static void stressTest (int N, int M, int a) {
        Random r = new Random();
        //int l = 1;
        while (true) {
            int n = r.nextInt(N);
            int m = r.nextInt(M);
            int[] s = new int[n];
            int[] e = new int[n];
            int[] p = new int[m];
            for (int i = 0; i < n; i++) {
                s[i] = r.nextInt(a);
                e[i] = r.nextInt(a) + s[i];
            }
            for (int i = 0; i < m; i++) {
                p[i] = r.nextInt(a);
            }
            int[] cnt1 = fastCountSegments(s, e, p);
            int[] cnt2 = naiveCountSegments(s, e, p);
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                if (cnt1[i] != cnt2[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("OK");
            } else {
                System.out.println(Arrays.toString(s));
                System.out.println(Arrays.toString(e));
                System.out.println(Arrays.toString(p));
                System.out.println(Arrays.toString(cnt1));
                System.out.println(Arrays.toString(cnt2));
                break;
            }
            //l--;
        }
    }*/
}

