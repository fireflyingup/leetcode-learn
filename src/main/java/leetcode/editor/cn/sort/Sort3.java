package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 */
public class Sort3 {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 24, 1, 3, 43, 56, 3, 1, 44, 3, 12};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int index = i - 1;
            while (index >= 0 && temp < nums[index]) {

                index--;
            }
        }
    }


}
