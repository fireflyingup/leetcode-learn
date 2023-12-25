//Given two strings word1 and word2, return the minimum number of operations 
//required to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
//
// Related Topics 字符串 动态规划 👍 3242 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Edit Distance
 * @author DY
 * @date 2023-12-25 13:53:41
 */
class P72_EditDistance{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P72_EditDistance().new Solution();

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= length2; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(dp[i-1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
				}
			}
		}
		return dp[length1][length2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
