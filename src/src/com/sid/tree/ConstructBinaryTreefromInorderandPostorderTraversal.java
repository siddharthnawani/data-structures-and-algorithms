package src.com.sid.tree;


/**
 *
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * */

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    private TreeNode helper(int[] inorder, int[] postorder,int inStart,int inEnd,int posStart,int posEnd)
    {
        if(inStart > inEnd)
            return null;

        int rootVal=postorder[posEnd];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=inStart;
        for(;rootIndex<=inEnd; rootIndex++){
            if(inorder[rootIndex]==rootVal)
                break;
        }

        int leftTreeSize=rootIndex-inStart;
        int rightTreeSize=inEnd-rootIndex;
        root.left=helper(inorder,postorder,inStart,rootIndex-1,posStart,posStart+leftTreeSize-1);
        root.right=helper(inorder,postorder,rootIndex+1,inEnd,posEnd-rightTreeSize,posEnd-1);

        return root;



    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        System.out.println(new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder,postorder));

        /**
         *
         * Answer : [3,9,20,null,null,15,7]
         *
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         *
         *
         * ***/



    }


}

