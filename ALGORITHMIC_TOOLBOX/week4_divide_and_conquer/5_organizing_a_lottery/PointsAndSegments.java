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
                    return 0;
                }
                return (v1 > v2) ? 1: -1;
            }
        });
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        
        
        int leftCount = 0;
        for (Pair p : list) {
            int v = p.value;
            int ind = p.index;
            String t = p.type;
            if (t.equals("l"))
                leftCount++;
            else if (t.equals("r"))
                leftCount--;
            else
                cnt[ind] = leftCount;
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
    }
}

