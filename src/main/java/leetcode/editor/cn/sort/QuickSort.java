package leetcode.editor.cn.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 5, 3, 7, 9, 4, 6, 10 ,8};
        QuickSort sort = new QuickSort();
        int[] target = sort.sort1(array, 0, array.length - 1);
        System.out.println(Arrays.toString(target));
    }

    public static int[] sort(int[] arrays, int left, int right) {
        if (left < right) {
            int partition = partition(arrays, left, right);
            sort(arrays, left, partition - 1);
            sort(arrays, partition + 1, right);
        }
        return arrays;
    }

    public static int partition(int[] array, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (array[left] > array[i]) {
                swap(array, index, i);
                index++;
            }
        }
        if (array[left] > array[index]) {
            swap(array, left, index);
        }
        return index - 1;
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    /**
     * --------------------------------------------------------
     */
    public static int[] sort1(int[] arrays, int left, int right) {
        if (left < right) {
            int partition = partition1(arrays, left, right);
            sort1(arrays, left, partition - 1);
            sort1(arrays, partition + 1, right);
        }
        return arrays;
    }

    public static int partition1(int[] array, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && array[l] < array[left]) {
                l++;
            }
            while (l < r && array[r] >= array[left]) {
                r--;
            }
            swap(array, l, r);
        }
        swap(array, l, left);
        return l;
    }

}
