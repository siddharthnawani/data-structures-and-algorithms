package src.com.sid.companyBasedQuestions.amazon.LinkedList;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 * <p>
 * Input: head = []
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1]
 * Output: [1]
 **/
public class SwapNodesinPairs {
    public ListNode swapPairs_UsingRecursion(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (head != null && head.next != null) {

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            //swap
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            //set for next
            prev = firstNode;
            head = firstNode.next;//jump
        }

        return dummy.next;

    }
}
