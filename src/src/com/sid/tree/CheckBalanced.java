package src.com.sid.tree;

public class CheckBalanced {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
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

    private boolean checkBalanced(TreeNode root){
        if(root ==null)
            return true;

        int lh=height(root.left);
        int rh=height(root.right);
        
        return (Math.abs(lh-rh) <=1) && checkBalanced(root.left) && checkBalanced(root.right);
    }

    private int height(TreeNode node) {

        if(node ==null)
            return 0;

        return 1+ Math.max(height(node.left),height(node.right));
    }

    //recursive impl ToDO

    public static void main (String[] args) throws Exception
    {
        TreeNode tree = new TreeNode(5);
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        tree.left.left.left = new TreeNode(7);

        CheckBalanced i  = new CheckBalanced();
        System.out.println(i.checkBalanced(tree));

    }
}
