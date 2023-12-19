package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 将数组分为排序好的和未排序好的，每次在未排序好的数组里面选取最小值放入排序好的数组里面。
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 5, 3, 7, 9, 4, 6, 10 ,8};
        SelectionSort sort = new SelectionSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
