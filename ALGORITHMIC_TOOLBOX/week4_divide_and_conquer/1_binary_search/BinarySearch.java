import java.io.*;
import java.util.*;


class BinarySearch {

    static int binarySearch(int[] a, int key) {
        //Arrays.sort(a);
        int left = 0, right = a.length;
        //quickSort(a, left, right);
        //write your code here
        return binarySearchUtil(a, left, right, key);
    }

    /*static int binarySearchUtil (int[] a, int l, int r, int key) {
        if (l < r) {
            int mid = l + (r-l)/2;
            if  (a[mid] == key) {
                return mid;
            }
            if (a[mid] > key) {
                return binarySearchUtil(a, l, mid, key);
            }
            return binarySearchUtil(a, mid+1, r, key);
        }
        return -1;
    }*/

    static int binarySearchUtil (int[] a, int l, int r, int key) {
        while (l < r-1) {
            int mid = l + (r-l)/2;
            if  (a[mid] <= key) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (a[l] == key) {
            return l;
        }
        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        /*int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }*/
        
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            int key = scanner.nextInt();
            if (key < a[0] || key > a[n-1]) {
                System.out.print("-1 ");
            } else {
                System.out.print(binarySearch(a, key) + " ");
            }
            
        }
        //quickSort(a, 0, a.length-1);
        //System.out.println(Arrays.toString(a));
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
    
    /*public static void quickSort (int[] arr, int l, int r) {
        while (l <= r) {
            Pair p = partition(arr, l, r);
            int p1 = p.p1;
            int p2 = p.p2;
            if (p1-l-1 < r-p2-1) {
                quickSort(arr, l, p1-1);
                l = p2+1;
            } else {
                quickSort(arr, p2+1, r);
                r = p1-1;
            }
        }
    }
    
    public static Pair partition (int[] arr, int l, int r) {
        if (r-l <= 1) {
            if (arr[r] < arr[l]) {
                swap(arr, l, r);
            }
            return new Pair(l, r);
        }
        int left = l, mid = l, right = r;
        int pivot = arr[r];
        while (mid <= right) {
            if (arr[mid] < pivot) {
                swap(arr, mid, left);
                left++;
                mid++;
            } else if (arr[mid] == pivot) {
                mid++;
            } else {
                swap(arr, mid, right);
                right--;
            }
        }
        return new Pair(left-1, mid);
    }
    
    public static void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }*/
    
    
}
