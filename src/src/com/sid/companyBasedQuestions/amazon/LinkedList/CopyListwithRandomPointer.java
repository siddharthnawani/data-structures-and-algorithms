package src.com.sid.companyBasedQuestions.amazon.LinkedList;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *
 * **/
public class CopyListwithRandomPointer {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //HashMap tp store old node -> new node key/val pairs
    Map<Node, Node> visited = new HashMap();

    public Node copyRandomList_UsingRecursion(Node head) {
        if (head == null)
            return head;

        if (visited.containsKey(head)) {
            return visited.get(head);
        } else {
            Node new_head = new Node(head.val);
            visited.put(head, new_head);

            new_head.next = copyRandomList(head.next);
            new_head.random = copyRandomList(head.random);

            return new_head;

        }
    }

    private Node getClonedList(Node node) {
        if (node == null) return node;

        if (visited.containsKey(node))
            return visited.get(node);
        Node new_node = new Node(node.val);
        visited.put(node, new_node);
        return new_node;
    }

    public Node copyRandomList_UsingIteration1(Node head) {

        if (head == null)
            return head;

        Node ptr = head;
        Node new_head = new Node(head.val);
        visited.put(head, new_head);
        while (ptr != null) {
            new_head.next = getClonedList(ptr.next);
            new_head.random = getClonedList(ptr.random);
            ptr = ptr.next;
            new_head = new_head.next;
        }

        return visited.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node ptr = head;

        //just create simple copy
        while (ptr != null) {
            Node new_node = new Node(ptr.val);

            new_node.next = ptr.next;
            ptr.next = new_node;
            ptr = new_node.next;
        }

        ptr = head;

        //now link the random pointers
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        //unweave the list
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node new_head = head.next;

        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;

            //move forward
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;

        }
        return new_head;
    }
}
