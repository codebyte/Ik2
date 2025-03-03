package amazon.sorting;

public class MedianSortedArrays {

    public static int findKthSmallest(int a[], int b[], int k) {

        int start = 0;
        int end = a.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if ((getVal(b, k - 1 - mid - 1) <= a[mid]) && (a[mid] <= getVal(b, k - 1 - mid))) {
                return a[mid];
            } else if (a[mid] > getVal(b, k - 1 - mid)) {
                end = mid - 1;
            } else if (a[mid] < getVal(b, k - 1 - mid - 1)) {
                start = mid + 1;
            }
        }
        return a[k - 1 - start];
    }

    public static Integer getVal(int arr[], int i) {
        if (i < 0) {
            return Integer.MIN_VALUE;
        } else if (i > (arr.length)) {
            return Integer.MAX_VALUE;
        } else {
            return arr[i];
        }
    }

    public static int findMedianSortedArrays(int a[], int b[]) {

        int total = a.length + b.length;
        int k = 0;

        if (total % 2 != 0) {
            k = total / 2;
            findKthSmallest(a, b, k);
        }

        return 0;
    }


    public static void main(String args[]) {
        int a[] = {10, 3, 4, 6, 7};
        int b[] = {5, 8, 23, 56, 67};

        System.out.println(findKthSmallest(a, b, 5));

    }
}
