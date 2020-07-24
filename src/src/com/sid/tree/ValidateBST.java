package src.com.sid.tree;

public class ValidateBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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

    public boolean isValidBST(TreeNode root) {

        return helper(root,null,null);

    }

    private boolean helper(TreeNode node,Integer l,Integer r){
        if(node ==null) return true;

        if(l!=null && node.val <= l ) return false;
        if(r!=null && node.val >= r ) return false;

        return helper(node.left,l,node.val) && helper(node.right,node.val,r) ;

    }


}

