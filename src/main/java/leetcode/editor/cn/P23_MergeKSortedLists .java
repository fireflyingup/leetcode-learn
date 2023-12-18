//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2720 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Merge k Sorted Lists
 *
 * @author DY
 * @date 2023-12-18 10:59:14
 */
class P23_MergeKSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P23_MergeKSortedLists().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            if (lists.length == 1) return lists[0];
            return dep(lists);
        }

        public ListNode dep(ListNode[] listNodes) {
            int length = listNodes.length;
            if (length == 1) return listNodes[0];
            if (length == 2) return mergeTwoLists(listNodes[0], listNodes[1]);
            int middle = length/2;
            ListNode left = dep(Arrays.copyOfRange(listNodes, 0, middle));
            ListNode right = dep(Arrays.copyOfRange(listNodes, middle, length));
            return mergeTwoLists(left, right);
        }


        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            ListNode target = new ListNode();
            ListNode current;
            if (list1.val < list2.val) {
                current = list1;
                list1 = list1.next;
            } else {
                current = list2;
                list2 = list2.next;
            }
            target.next = current;
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
