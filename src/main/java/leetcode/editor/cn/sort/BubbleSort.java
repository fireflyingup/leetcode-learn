package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 相邻的两个数字比较，大的数字往后移，一次循环后最大的数在最右边。
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 5, 3, 7, 9, 4, 6, 10 ,8};
        BubbleSort sort = new BubbleSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        int length = array.length;
        if (length < 2) return;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }
}
