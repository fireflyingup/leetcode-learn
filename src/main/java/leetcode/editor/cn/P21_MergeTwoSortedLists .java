//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists into one sorted list. The list should be made by 
//splicing together the nodes of the first two lists. 
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
// 
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
//
// Related Topics 递归 链表 👍 3387 👎 0


package leetcode.editor.cn;

/**
 * Merge Two Sorted Lists
 *
 * @author DY
 * @date 2023-12-18 10:36:34
 */
class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
        ListNode listNode1 = new P21_MergeTwoSortedLists().new ListNode(1);
        ListNode listNode2 = new P21_MergeTwoSortedLists().new ListNode(2);
        solution.mergeTwoLists(listNode1, listNode2);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            ListNode target = new ListNode();
            ListNode current = target;
            for (; ; ) {
                if (list1 == null) {
                    current.next = list2;
                    break;
                }
                if (list2 == null) {
                    current.next = list1;
                    break;
                }
                if (list1.val < list2.val) {
                    current.next = list1;
                    current = current.next;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    current = current.next;
                    list2 = list2.next;
                }
            }

            return target.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
