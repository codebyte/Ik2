package Array;

import java.util.*;

public class SlidingWindow {

    public static float averageStream(int num[], int k) {

        Queue<Integer> q = new LinkedList<>();
        float max = 0;

        int total = 0;

        for (int i = 0; i < num.length; i++) {

            q.add(num[i]);
            total += num[i];

            if (q.size() > k) {
                total -= q.poll();
                float average = (float) total / q.size();
                max = Math.max(average, max);
            }
        }
        System.out.println(max);
        return 0;
    }

    public static float maxAverageWindowSum(int num[], int k) {

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += num[i];
        }
        int globalSum = windowSum;

        for (int i = k; i < num.length; i++) {
            windowSum += num[i];
            windowSum -= num[i - k];
            globalSum = Math.max(windowSum, globalSum);
        }

        return (float) globalSum / k;
    }

    public static int subArraysSizeKAverage(int num[], int k, int threshold) {

        int windowSum = 0;
        int subArrayCount = 0;
        int currAverage = 0;
        for (int i = 0; i < k; i++) {
            windowSum += num[i];
        }

        currAverage = windowSum / k;
        if (currAverage >= threshold) {
            subArrayCount++;
        }

        for (int i = k; i < num.length; i++) {
            windowSum += num[i];
            windowSum -= num[i - k];

            currAverage = windowSum / k;

            if (currAverage >= threshold) {
                subArrayCount++;
            }
        }
        return subArrayCount;
    }

    public static int getScore(int calorie, int lower, int upper) {
        if (calorie > upper) {
            return 1;
        } else if (calorie < lower) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int dietPerformance(int[] num, int k, int lower, int upper) {

        int windowSum = 0;
        int totalScore = 0;

        for (int i = 0; i < k; i++) {
            windowSum += num[i];
        }

        totalScore += getScore(windowSum, lower, upper);

        for (int i = k; i < num.length; i++) {
            windowSum += num[i];
            windowSum -= num[i - k];
            totalScore += getScore(windowSum, lower, upper);
        }
        return totalScore;
    }

    public static int grumpyBookStore() {
        int store[] = {1, 0, 1, 2, 1, 1, 7, 5};
        int grumpy[] = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;

        int total = 0;
        int windowSum = 0;

        for (int i = 0; i < X; i++) {
            windowSum += store[i];
            if (grumpy[i] != 1) {
                total += store[i];
            }
        }
        int maxWindowSum = windowSum;
        int maxi = 0;
        int maxj = X;

        for (int i = X; i < store.length; i++) {
            windowSum += store[i];
            windowSum -= store[i - X];

            if (windowSum > maxWindowSum) {
                maxWindowSum = windowSum;
                maxj = i;
                maxi = i - X + 1;
            }
            if (grumpy[i] != 1) {
                total += store[i];
            }
        }

        for (int i = maxi; i <= maxj; i++) {
            if (grumpy[i] == 1) {
                total += store[i];
            }
        }

        return total;
    }


    public static int maxVowels(String s, int k) {
        String vowels = "aeiou";

        int windowSum = 0;
        int maxVowels = 0;
        for (int i = 0; i < k; i++) {
            char letter = s.charAt(i);
            if (vowels.contains(String.valueOf(s.charAt(i)))) {
                windowSum++;
            }
        }

        maxVowels = Math.max(windowSum, maxVowels);

        for (int i = k; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (vowels.contains(String.valueOf(s.charAt(i)))) {
                windowSum++;
            }
            if (vowels.contains(String.valueOf(s.charAt(i - k)))) {
                windowSum--;
            }

            maxVowels = Math.max(windowSum, maxVowels);
        }


        return maxVowels;
    }

    public static void updateElementInMap(Map<Character, Integer> window, char letter) {
        if (window.containsKey(letter)) {
            window.put(letter, window.get(letter) + 1);
        } else {
            window.put(letter, 1);
        }
    }

    public static void removeElementInMap(Map<Character, Integer> window, char letter) {
        if (window.containsKey(letter)) {
            if (window.get(letter) > 1) {
                window.put(letter, window.get(letter) - 1);
            } else {
                window.remove(letter);
            }
        }
    }


    public static int findKLengthSubStringsWithNoRepeatChar() {
        String s = "havefunonleetcode";
        int k = 5;

        int count = 1;
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Character letter = s.charAt(i);
            updateElementInMap(window, letter);
        }
        int total = 0;
        for (int i = k; i < s.length(); i++) {
            Character letter = s.charAt(i);
            removeElementInMap(window, s.charAt(i - k));
            updateElementInMap(window, s.charAt(i));
            if (window.keySet().size() == 5) {

                count++;
            }
        }
        return count;
    }

    public static ArrayList<Integer> slidingWindowMaximum() {
        int num[] = {1, 3, -1, -3, 5, 3, 6, 7};
        //int num[] = {1, -1, 0};
        int k = 2;

        ArrayList<Integer> result = new ArrayList<>();

        int lastWindowMax = 0;
        int lastWindowMaxPos = 0;

        for (int i = 0; i < k; i++) {
            if (num[i] > lastWindowMax) {
                lastWindowMax = num[i];
                lastWindowMaxPos = i + 1;
            }
        }
        System.out.println("LastWindowMax" + lastWindowMax);
        result.add(lastWindowMax);


        for (int i = k; i < num.length; i++) {
            lastWindowMaxPos -= 1;
            if ((num[i] > lastWindowMax) && (lastWindowMaxPos == 0)) {
                lastWindowMax = num[i];
                lastWindowMaxPos = i-k;
            }
            result.add(lastWindowMax);
        }
        return result;
    }

    public static void main(String args[]) {
        int num[] = {1, 2, 3, 4, 5};

        averageStream(num, 4);
        System.out.println(maxAverageWindowSum(num, 4));
        System.out.println(subArraysSizeKAverage(num, 3, 4));
        System.out.println(dietPerformance(num, 1, 3, 3));

        System.out.println(grumpyBookStore());
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(findKLengthSubStringsWithNoRepeatChar());
        System.out.println(slidingWindowMaximum());

    }
}
