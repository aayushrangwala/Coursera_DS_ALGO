import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left) {
            return numberOfInversions;
        }
        int ave = left + (right-left) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        numberOfInversions += merge(a, b, left, ave+1, right);
        return numberOfInversions;
    }

    /*private static long getNumberOfInversions(int[] a, int left, int right) {
        return mergeSort(a, left, right);

    }*/

    /*public static long mergeSort (int[] a, int l, int r) {
        long count = 0;
        if (l < r) {
            int mid = l + (r-l)/2;
            count += mergeSort(a, l, mid);
            count += mergeSort(a, mid+1, r);
            count += merge(a, l, mid, r);
        }
        return count;
    }*/

    public static long merge (int[] a, int[] b, int l, int mid, int r) {
        long inv = 0;
        /*int n1 = mid-l+1;
        int n2 = r-mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = a[l+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[mid+i+1];
        }*/
        int i = l, j = mid, k = l;
        while (i < mid && j <= r) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                inv += (mid-i);
                b[k++] = a[j++];
            }
        }

        while (i < mid) {
            b[k++] = a[i++];
        }
        
        while (j <= r) {
            b[k++] = a[j++];
        }
        for (i = l; i <= r; i++) {
            a[i] = b[i];
        }
        return inv;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}

