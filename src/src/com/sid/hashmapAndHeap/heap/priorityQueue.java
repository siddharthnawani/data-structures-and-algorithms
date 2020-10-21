package src.com.sid.hashmapAndHeap.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class priorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int[] rank={22,99,1,4,77,3,33,7,4,1,90};
        // n * Log(n)
        for(int val : rank){
            pq.add(val);
        }

        // n * Log(n)
        //sorted list
        while(pq.size() >0){
            System.out.println(pq.peek());
            pq.remove();
        }

        //reverse sorting
        PriorityQueue<Integer> reversePQ=new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("Reverse Order :");
        // n * Log(n)
        for(int val : rank){
            reversePQ.add(val);
        }

        // n * Log(n)
        //reverse sorted list
        while(reversePQ.size() >0){
            System.out.println(reversePQ.peek());
            reversePQ.remove();
        }

    }
}
