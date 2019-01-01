import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        //handeling 2 elements
        int m1;
        int m2;
        int[] m = new int[2];
        if (r-l <= 1) {
            if (a[l] > a[r]) {
                swap(a, l, r);
            }
            m1 = l;
            m2 = r;
            m[0] = m1;
            m[1] = m2;
            return m;
        }
        int pivot  = a[l], mid = l;

        while (mid <= r) {
            if (a[mid] < pivot) {
                swap(a, l, mid);
                l++;
                mid++;
            } else if (a[mid] == pivot) {
                mid++;
            } else {
                swap(a, r, mid);
                r--;
            }
        }
        m1 = l-1;
        m2 = r;
        m[0] = m1;
        m[1] = m2;
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    /*private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }*/


    private static void randomizedQuickSort(int[] a, int l, int r) {
        while (l < r) {
            int k = random.nextInt(r - l + 1) + l;
            swap(a, l, k);
            //use partition3
            int[] m = partition3(a, l, r);
            int m1 = m[0];
            int m2 = m[1];
            if (m1-l < r-m2) {
                randomizedQuickSort(a, l, m[0] - 1);
                l = m2+1;
            } else {
                randomizedQuickSort(a, m[1] + 1, r);
                l = m1-1;
            }
        }
    }


    public static void swap (int[] arr,  int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

