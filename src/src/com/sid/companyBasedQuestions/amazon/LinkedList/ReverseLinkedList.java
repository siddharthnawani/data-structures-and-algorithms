package src.com.sid.companyBasedQuestions.amazon.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public ListNode reverseList_Iterative(ListNode head) {
        if (head == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return prev;
    }
}
