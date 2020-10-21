package src.com.sid.hashmapAndHeap.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/***
 *
 *
 * **/
public class EfficientHeapConstructor {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }
        //new improved constructor
        // O(n)
        public void add(int[] arr) {
            for(int val:arr){
                this.data.add(val);
            }

           for(int i=data.size()/2 -1 ; i>=0; i--){
               downheapify(i);
           }
        }

        // this will be slow n log n
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
