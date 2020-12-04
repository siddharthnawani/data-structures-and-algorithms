package src.com.sid.companyBasedQuestions.amazon.LinkedList;

/***
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 *
 *
 *
 * **/
public class ReverseNodesinkGroup {
    private ListNode reverseList(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        while (k > 0) {
            ListNode nxt_ptr = curr.next;
            curr.next = prev;

            prev = curr;

            curr = nxt_ptr;
            k--;
        }

        return prev;
    }

    public ListNode reverseKGroup_UsingRecursion(ListNode head, int k) {
        if (head == null)
            return head;

        int count = 0;
        ListNode ptr = head;

        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }

        if (count == k) {
            ListNode rev_head = reverseList(head, k);
            head.next = reverseKGroup_UsingRecursion(ptr, k);

            return rev_head;
        }

        return head;


    }

    public ListNode reverseKGroup_IterativeMethod(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode ptr = head;
        ListNode ktail = null;
        ListNode new_head = null;

        while (ptr != null) {
            int count = 0;

            //ptr=head;
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) {

                ListNode rev_head = reverseList(head, k);

                if (new_head == null)
                    new_head = rev_head;

                if (ktail != null)
                    ktail.next = rev_head;

                ktail = head;
                head = ptr;
            }

        }

        if (ktail != null)
            ktail.next = head;

        return new_head == null ? head : new_head;

    }
}
