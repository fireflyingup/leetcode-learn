//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2361 👎 0

package leetcode.editor.cn;

/**
 * @author fireflying
 */
class longestValidParentheses {
    //2023-09-14 18:11:37
    //最长有效括号
    //编号：[32]

    public static void main(String[] args) {
        Solution solution = new longestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()(()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int left = 0;
            int right = 0;
            int len = 0;
            int length = s.length();
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) == '(') {
                    left++;
                }
                if (s.charAt(i) == ')' && left > right) {
                    right++;
                    if (right <= left) {
                        len++;
                    }
                }
            }

            return len * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}