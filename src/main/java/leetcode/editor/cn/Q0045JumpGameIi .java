//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2280 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author fireflying
 */
class jumpGameIi {
    //2023-09-23 12:27:31
    //跳跃游戏 II
    //编号：[45]

    public static void main(String[] args) {
        Solution solution = new jumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{2,3,0,1,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int length = nums.length;

            int right = 0;
            int pos = 0;
            int step = 0;
            for (int i = 0; i < length - 1; i++) {
                right = Math.max(right, nums[i] + i);
                if (pos == i) {
                    step++;
                    pos = right;
                }
            }
            return step;
        }

        public int jump1(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            dp[0] = 0;
            for (int i = 1; i < length; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (j + nums[j] >= i && dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
            if (dp[length - 1] == Integer.MAX_VALUE) {
                return 0;
            }
            return dp[length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}