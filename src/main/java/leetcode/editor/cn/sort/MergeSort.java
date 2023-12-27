package leetcode.editor.cn.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 5, 3, 7, 9, 4, 6, 10 ,8};
        MergeSort sort = new MergeSort();
        int[] target = sort.sort(array);
        System.out.println(Arrays.toString(target));
    }

    public static int[] sort(int[] arrays) {
        int length = arrays.length;
        if (length < 2) {
            return arrays;
        }
        int middle = length/2;
        int[] left = Arrays.copyOfRange(arrays, 0, middle);
        int[] right = Arrays.copyOfRange(arrays, middle, length);
        return merge(sort(left), sort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] target = new int[left.length + right.length];
        int i = 0, j = 0, index = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                target[index++] = right[j++];
            } else if (j == right.length) {
                target[index++] = left[i++];
            } else if (left[i] < right[j]) {
                target[index++] = left[i++];
            } else {
                target[index++] = right[j++];
            }
        }
        return target;
    }
}
