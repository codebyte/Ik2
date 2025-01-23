package educative.twopointers;

import java.util.Arrays;

public class SortColors {

    public static void swap(int colors[], int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
    public static int[] sortColors(int[] colors) {
        int r = -1;
        int w = -1;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 1) {
                w++;
                swap(colors, w, i);
            } else if (colors[i] == 0) {
                w++;
                swap(colors, w, i);
                r++;
                swap(colors, r, w);
            }
        }
        return colors;
    }


    public static void main(String args[]) {
        int[] colors = {0, 2, 1, 0, 1, 2, 1, 0};

        sortColors(colors);
        System.out.println(Arrays.toString(colors));


    }

}
