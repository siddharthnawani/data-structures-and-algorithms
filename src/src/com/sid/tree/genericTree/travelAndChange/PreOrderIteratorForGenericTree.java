package src.com.sid.tree.genericTree.travelAndChange;

import src.com.sid.tree.genericTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class PreOrderIteratorForGenericTree {

    static class GenericTree implements Iterable<Integer> {

        Node root;

        GenericTree(Node root) {
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }
    }

    static class GTPreorderIterator implements Iterator<Integer> {
        Integer nval;
        Stack<Pair> s;

        public GTPreorderIterator(Node root) {
            s = new Stack<>();
            s.push(new Pair(root, -1));
            next();
        }

        @Override
        public boolean hasNext() {
            if (nval == null)
                return false;
            else
                return true;
        }

        @Override
        public Integer next() {
            Integer fr = nval;

            //move nval forward and if not possibler set it to null
            nval=null;
            while (s.size() > 0) {
                Pair top = s.peek();

                if (top.state == -1) {
                    nval = top.node.data;
                    top.state++;
                    break;
                } else if (top.state == top.node.children.size()) {
                    s.pop();
                } else {
                    s.push(new Pair(top.node.children.get(top.state), -1));
                    top.state++;
                }
            }

            return fr;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = Node.construct(arr);
        //Node.display(root);
        GenericTree genericTree=new GenericTree(root);

        for(int val:genericTree){
            System.out.println(val);
        }

        System.out.println("Printing via iterator");

        Iterator<Integer> itr= genericTree.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}
