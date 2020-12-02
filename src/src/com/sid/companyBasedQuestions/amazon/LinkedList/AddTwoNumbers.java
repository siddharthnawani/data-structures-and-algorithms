package src.com.sid.companyBasedQuestions.amazon.LinkedList;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Follow up
 * <p>
 * What if the the digits in the linked list are stored in non-reversed order? For example:
 ***/
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

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int c = 0;

        while (l1 != null || l2 != null || c != 0) {
            if (l1 != null) {
                c += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                c += l2.val;
                l2 = l2.next;
            }

            tmp.next = new ListNode(c % 10);
            c = c / 10;

            tmp = tmp.next;


        }

        return res.next;
    }

    /**
     * for follow up - reverse both list and return reverse answer as well..
     * https://leetcode.com/problems/add-two-numbers/discuss/235796/Java-solution-and-follow-up-solution-with-explanation
     **/
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            curr = curr.next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}

