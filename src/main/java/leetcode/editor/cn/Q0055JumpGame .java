//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2511 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author fireflying
 */
class jumpGame {
    //2023-09-23 12:20:02
    //跳跃游戏
    //编号：[55]

    public static void main(String[] args) {
        Solution solution = new jumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int length = nums.length;
            boolean[] dp = new boolean[length];
            dp[0] = true;
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && nums[j] + j >= i) {
                        dp[i] = true;
                        break;
                    }
                }
                if (!dp[i]) {
                    return false;
                }
            }
            return dp[length - 1];
        }


        public boolean canJump1(int[] nums) {
            int length = nums.length;
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (max < i) {
                    return false;
                }
                max = Math.max(max, nums[i] + i);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}