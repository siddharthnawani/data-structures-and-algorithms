package src.com.sid.companyBasedQuestions.amazon.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 ***/
public class ReverseLinkedListII {
    //ref for this techique https://www.youtube.com/watch?v=aL3l2-S9koY
    private boolean stop;
    private ListNode left;

    private void recurseAndReverse(ListNode right, int m, int n) {

        if (n == 1) return;

        right = right.next;

        //move the left pointer until you reach the correct location
        if (m > 1)
            left = left.next;


        recurseAndReverse(right, m - 1, n - 1);

        //do swap here because this is backtracking; right moves automatically by recurion left you have to move

        //write the logic of stopping as well
        if (left == right || right.next == left)
            stop = true;

        if (!stop) {
            int temp = right.val;
            right.val = left.val;
            left.val = temp;

            //move left
            left = left.next;
        }


    }

    public ListNode reverseBetween_UsingRecursion1(ListNode head, int m, int n) {

        left = head;
        stop = false;
        recurseAndReverse(head, m, n);
        return head;

    }

    ListNode successor = null;

    private ListNode reverN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;

    }

    public ListNode reverseBetween_UsingRecursion2(ListNode head, int m, int n) {
        if (m == 1) {
            return reverN(head, n);
        }
        head.next = reverseBetween_UsingRecursion2(head.next, m - 1, n - 1);
        return head;
    }

    //iterative
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode con = prev;
        ListNode tail = curr;
        ListNode third = null;
        while (n > 0) {
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }

        if (con != null)
            con.next = prev;
        else head = prev;

        tail.next = curr;

        return head;
    }
}
