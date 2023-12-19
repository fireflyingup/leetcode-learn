package leetcode.editor.cn.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 5, 3, 7, 9, 4, 6, 10 ,8};
        InsertionSort sort = new InsertionSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int temp = array[i];
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
