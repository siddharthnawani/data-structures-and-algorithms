package src.com.sid.companyBasedQuestions.amazon.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 **/
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val)
                    return -1;
                else if (l1.val == l2.val)
                    return 0;
                else
                    return 1;
            }
        };
        //two types of comparator
        Comparator<ListNode> cmp2 = (l1, l2) -> Integer.compare(l1.val, l2.val);

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, cmp);
        ListNode res = new ListNode(0);
        ListNode curr = res;
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        while (pq.size() > 0) {
            curr.next = pq.poll();
            curr = curr.next;

            //increment the current pointed list in priority queue
            if (curr.next != null)
                pq.add(curr.next);
        }
        return res.next;

    }
}
