package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KtheLargest {


    public static List<List<Integer>> kthSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();

        int i = 0;
        int j = 0;

        while ((i < nums1.length) && (j < nums2.length)) {

            if (pairs.size() == k) {
                return pairs;
            }
            if ((nums1[i] + nums2[j]) == k) {
                pairs.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
                i++;
            } else if ((nums1[i] + nums2[j]) > k) {
                if (nums1[i] > nums2[j])
                    i++;
                else
                    j++;
            } else if ((nums1[i] + nums2[j]) < k) {
                if (nums1[i] > nums2[j])
                    i++;
                else
                    j++;
            }

        }
        return pairs;
    }

    public static int[] twoSumSorted(int[] num, int target) {
        int i = 0;
        int j = num.length - 1;
        int result[] = new int[2];

        while (i < j) {
            if ((num[i] + num[j]) == target) {
                result[0] = i+1;
                result[1] = j+1;
                i++;
                j--;
                break;
            } else if ((target - num[i]) < num[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public static int kThLargest(int num[], int k) {
        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < num.length; i++) {
            if (q.size() < k) {
                q.add(num[i]);
            } else {
                if (num[i] > q.peek()) {
                    q.poll();
                    q.add(num[i]);
                }
            }
        }
        return q.poll();
    }

    public static void main(String args[]) {
        int num[] = {2, 7, 11, 15};
        int k = 9;

        //System.out.println(kThLargest(num, k));

        //System.out.println(kthSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3));

        System.out.println(twoSumSorted(num, k).toString());

    }
}