package src.com.sid.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListofDepths {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private List<List<Integer>> getListOfDepths(TreeNode root){

        List<List<Integer>> l=new ArrayList<>();
        if(root==null)
            return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;

        while(!q.isEmpty()){

            int size=q.size();
            List<Integer> t=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
                t.add(temp.val);
            }
            if(!t.isEmpty())
                l.add(t);
        }
        return l;
    }

    //recursive implementation
    //To do


    public static void main (String[] args) throws Exception
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        ListofDepths i  = new ListofDepths();
        System.out.println(i.getListOfDepths(root));

    }

}
