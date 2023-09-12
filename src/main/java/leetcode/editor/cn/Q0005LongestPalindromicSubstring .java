//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6799 👎 0

package leetcode.editor.cn;

/**
 * @author fireflying
 */
class longestPalindromicSubstring {
    //2023-09-12 15:15:35
    //最长回文子串
    //编号：[5]

    public static void main(String[] args) {
        Solution solution = new longestPalindromicSubstring().new Solution();
        String s = solution.longestPalindrome("aaaa");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();

            return s.substring(0);
        }

        /**
         * 两边回溯
         * @param s
         * @return
         */
        public String longestPalindrome2(String s) {
            int length = s.length();
            int left = 0;
            int right = 0;
            int len = 0;
            int targetLen = 0;
            int start = 0; int end = 0;
            for (int i = 0; i < length; i++) {
                left = i;
                len = 0;
                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    left--;
                    len++;
                }
                right = i;
                while (right <= length - 1 && s.charAt(right) == s.charAt(i)) {
                    right++;
                    len++;
                }
                while (left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    len += 2;
                }
                if (len > targetLen) {
                    targetLen = len;
                    start = left + 1;
                    end = right - 1;
                }
            }
            return s.substring(start, end + 1);
        }

        public String longestPalindromeSelf(String s) {
            int length = s.length();
            int maxIndex = 0;
            int max = 1;
            for (int i = 0; i < length; i++) {
                int left = i - 1;
                int right = i + 1;
                int tempMax = 0;
                int tempMaxIndex = 0;
                while (left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)) {
                    if (tempMax == 0) {
                        tempMax = 3;
                    } else {
                        tempMax += 2;
                    }
                    tempMaxIndex = right;
                    left--; right++;
                }
                if (tempMax > max) {
                    max = tempMax;
                    maxIndex = tempMaxIndex;
                }
                left = i;
                right = i + 1;
                tempMax = 0;
                tempMaxIndex = 0;
                while (left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)) {
                    tempMax += 2;
                    tempMaxIndex = right;
                    left--; right++;
                }
                if (tempMax > max) {
                    max = tempMax;
                    maxIndex = tempMaxIndex;
                }
            }
            return s.substring(maxIndex - max + 1, maxIndex + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}