package src.com.sid.hashmapAndHeap.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/priority-queue-using-heap-official/ojquestion#
 * <p>
 * Question
 * 1. You are required to complete the code of our Priority Queue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
 * 2. Here is the list of functions that you are supposed to complete:
 * 2.1. add -> Should accept new data.
 * 2.2. remove -> Should remove and return smallest value, if available or print
 * "Underflow" otherwise and return -1.
 * 2.3. peek -> Should return smallest value, if available or print "Underflow"
 * otherwise and return -1.
 * 2.4. size -> Should return the number of elements available.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * add 10
 * add 20
 * add 30
 * add 40
 * peek
 * add 50
 * peek
 * remove
 * peek
 * remove
 * peek
 * remove
 * peek
 * remove
 * peek
 * quit
 * Sample Output
 * 10
 * 10
 * 10
 * 20
 * 20
 * 30
 * 30
 * 40
 * 40
 * 50
 **/
public class WritePriorityQueueUsingHeap {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void upheapify(int i) {
            if (i == 0) {
                return;
            }
            int pi = (i - 1) / 2;
            if (data.get(pi) > data.get(i)) {
                swap(i, pi);
                upheapify(pi);
            }
        }

        public void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        public void downheapify(int pi) {
            int min = pi;

            int li = 2 * pi + 1;
            if (li < data.size() && data.get(li) < data.get(min)) {
                min = li;
            }
            int ri = 2 * pi + 2;
            if (ri < data.size() && data.get(ri) < data.get(min)) {
                min = ri;
            }

            if (min != pi) {
                swap(pi, min);
                downheapify(min);
            }
        }


        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
