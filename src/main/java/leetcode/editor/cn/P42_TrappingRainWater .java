//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4946 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Trapping Rain Water
 * @author DY
 * @date 2024-01-02 17:13:58
 */
class P42_TrappingRainWater{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P42_TrappingRainWater().new Solution();
		 int trap = solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
		 System.out.println(trap);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
		if (height.length < 3) {
			return 0;
		}
		int[] temp = new int[height.length];
		int max = height[0];
		for (int i = 0; i < height.length; i++) {
			if (height[i] < max) {
				temp[i] = max - height[i];
			}
			max = Math.max(height[i], max);
		}
		max = height[height.length - 1];
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] < max) {
				temp[i] = Math.min(temp[i], max - height[i]);
			} else {
				temp[i] = 0;
			}
			max = Math.max(height[i], max);
		}
		max = 0;
		for (int i = 0; i < temp.length; i++) {
			max += temp[i];
		}
		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
