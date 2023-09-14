//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3374 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fireflying
 */
class generateParentheses {
    //2023-09-14 17:28:00
    //括号生成
    //编号：[22]

    public static void main(String[] args) {
        Solution solution = new generateParentheses().new Solution();
        List<String> list = solution.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            if (n == 0) {
                return list;
            }
            append(list,new StringBuilder(), n, n);
            return list;
        }

        private void append(List<String> list, StringBuilder str, int left, int right) {
            if (left == 0 && right == 0) {
                list.add(str.toString());
            }
            if (left == right) {
                str.append("(");
                append(list, str, left - 1, right);
                str.deleteCharAt(str.length() - 1);
            } else {
                if (left > 0) {
                    str.append("(");
                    append(list, str, left - 1, right);
                    str.deleteCharAt(str.length() - 1);
                }
                if (right > 0) {
                    str.append(")");
                    append(list, str, left, right - 1);
                    str.deleteCharAt(str.length() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}