package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次从剩余的数据组选出一个最小值，和剩余数据的第一个互相替换。
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 */
public class Sort2 {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 24, 1, 3, 43, 56, 3, 1, 44, 3, 12};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}
