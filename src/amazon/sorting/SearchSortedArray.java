package amazon.sorting;

public class SearchSortedArray {

    public static int search(int[] a, int k) {

        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == k) {
                return mid;
            }
            if ((mid < a.length - 1) && (a[mid] < a[mid + 1])) {
                start = mid + 1;
            } else if ((mid > 0) && (a[mid] > a[mid - 1])) {
                end = mid - 1;
            }
        }
        if (a[start] == k) {
            return start;
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(search(arr, 2));


    }
}
