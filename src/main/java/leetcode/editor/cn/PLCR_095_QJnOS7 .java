//English description is not available for the problem. Please switch to 
//Chinese. 
//
// Related Topics 字符串 动态规划 👍 153 👎 0


package leetcode.editor.cn;

/**
 * 最长公共子序列
 * @author DY
 * @date 2023-12-26 15:45:59
 */
class PLCR_095_QJnOS7{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new PLCR_095_QJnOS7().new Solution();
		 int i = solution.longestCommonSubsequence("ac", "abc");
		 System.out.println(i);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
		int length1 = text1.length();
		int length2 = text2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[length1][length2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
