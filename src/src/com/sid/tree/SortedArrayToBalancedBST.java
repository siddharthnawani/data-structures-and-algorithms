package src.com.sid.tree;

public class SortedArrayToBalancedBST {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }


    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return _helper(nums,0,nums.length-1);

    }

    private TreeNode _helper(int[] nums, int s, int e) {

        if(s > e){
            return null;
        }
        int mid= (s+e) >>>1;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=_helper(nums,s,mid-1);
        root.right=_helper(nums,mid+1,e);

        return root;


    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(TreeNode node) {
        if (node == null) {
            System.out.print(" null ");
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3, 4, 5, 6};
        int n = arr.length;
        TreeNode root = new SortedArrayToBalancedBST().sortedArrayToBST(arr);
        System.out.println("Preorder traversal of constructed BST");
        new SortedArrayToBalancedBST().preOrder(root);
    }


}
