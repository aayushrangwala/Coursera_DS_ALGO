import java.util.*;


class Pair {
    int index;
    double val;

    Pair (int i, double d) {
        index = i;
        val = d;
    }
}

class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < values.length; i++) {
            double tmp = (double) ((double)values[i]/(double)weights[i]);
            list.add(new Pair(i, tmp));
        }

        Collections.sort(list, new Comparator <Pair> () {
            @Override
            public int compare (Pair p1, Pair p2) {
                double d1 = p1.val;
                double d2 = p2.val;

                if (d1 > d2) {
                    return -1;
                } else if (d1 == d2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < values.length; i++) {
            if (capacity == 0) {
                return value;
            }
            Pair t = list.get(i);
            int tmp = Math.min(capacity, weights[t.index]);
            value += (tmp * t.val);
            capacity -= tmp;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double ans = getOptimalValue(capacity, values, weights);
        System.out.printf("%.4f", ans);
    }
} 
