package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 相邻的两个互相比较，将最大的往右边移动，每次循环选出一个最大的放在最右边。
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 */
public class Sort1 {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 24, 1, 3, 43, 56, 3, 1, 44, 3, 12};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
