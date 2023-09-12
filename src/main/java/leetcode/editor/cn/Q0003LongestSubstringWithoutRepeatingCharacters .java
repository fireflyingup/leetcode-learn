//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9614 👎 0

package leetcode.editor.cn;

import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.Map;

/**
    *@author fireflying
*/
class longestSubstringWithoutRepeatingCharacters{
    //2023-09-11 11:50:54
    //无重复字符的最长子串
    //编号：[3]
    
    public static void main(String[] args) {
        Solution solution = new longestSubstringWithoutRepeatingCharacters().new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(abcabcbb);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            if (length == 0) {
                return 0;
            }
            int target = 0;
            int right = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                while (right < length && !map.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), right++);
                }
                if (right < length && map.containsKey(s.charAt(right))) {
                    map.remove(s.charAt(i));
                }
                target = Math.max(target, right - i);

            }
            return target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}